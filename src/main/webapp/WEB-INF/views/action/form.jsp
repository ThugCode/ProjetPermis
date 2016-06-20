<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">Ajouter une action</jsp:attribute>
    
	<jsp:body>
		<section class="content">
			<div class="row">
				<div class="col-md-12 col-lg-8 col-lg-offset-2">
					<div class="box box-primary">
						<form role="form" action="/permis/actions/add" method="post">
							<div class="box-body">
								<input type="hidden" id="inputId" name="inputId" value="${action.id}">
								<div class="form-group">
									<label for="inputName">Nom</label>
									<input class="form-control" id="inputName" name="inputName" placeholder="Nom" value="${action.name}">
								</div>
							</div>
							
							<div class="box-footer">
								<a href="/permis/actions/" class="btn btn-warning">Annuler</a>
								<button type="submit" class="btn btn-bitbucket pull-right">${buttonSubmit}</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</jsp:body>
</t:layout>