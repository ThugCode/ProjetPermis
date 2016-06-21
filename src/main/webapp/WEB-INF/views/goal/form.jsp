<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">Ajouter un objectif</jsp:attribute>
    
    <jsp:attribute name="_page_scripts">
		<c:url value="/assets/js/goal/form.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
    
	<jsp:body>
		<section class="content">
			<div class="row">
				<div class="col-md-12 col-lg-8 col-lg-offset-2">
					<div class="box box-primary">
						<form id="form" role="form" action="/permis/goals/add" method="post">
							<div class="box-body">
								<input type="hidden" id="inputId" name="inputId" value="${goal.id}">
								<input type="hidden" id="inputActions" name="inputActions">
								<div class="form-group">
									<label for="inputName">Nom</label>
									<input class="form-control" id="inputName" name="inputName" placeholder="Nom" value="${goal.name}">
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">Actions requises pour valider l'objectif</div>
									<div id="panelCards" class="panel-body">
										<c:if test="${empty goal.actions}">Aucune action pour le moment</c:if>
										<c:forEach items="${goal.actions}" var="item">
											<div class="col-md-3 card" data-id="${item.id}">
												<div class="box box-warning">
													<div class="box-header with-border">
														<h3 class="box-title">${item.name}</h3>
														<div class="box-tools pull-right">
															<button type="button" class="btn btn-box-tool" data-widget="remove">
																<i class="fa fa-times"></i>
															</button>
														</div>
            										</div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="panel-footer text-center">
										<button id="addAction" type="button" class="btn btn-bitbucket" data-toggle="modal" data-target="#actionModal">
											<i class="fa fa-plus"></i>&nbsp;Ajouter une action
										</button>
									</div>
								</div>
							</div>
							
							<div class="box-footer">
								<a href="/permis/goals/" class="btn btn-warning">Annuler</a>
								<button type="submit" class="btn btn-bitbucket pull-right">${buttonSubmit}</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		
		<div class="modal modal-default fade" id="actionModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">Ajouter des actions</h4>
					</div>
					<div class="modal-body">
						<table class="table table-bordered">
                			<tbody>
                				<c:forEach items="${actions}" var="item">
	                				<tr>
										<td style="width: 40px">
											<input type="checkbox" value="${item.id}">
										</td>
										<td>${item.name}</td>
									</tr>
								</c:forEach>
              				</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary pull-left" data-dismiss="modal">Annuler</button>
						<button id="saveActions" type="button" class="btn btn-primary">Sauvegarder</button>
					</div>
				</div>
			</div>
		</div>
		
	</jsp:body>
</t:layout>