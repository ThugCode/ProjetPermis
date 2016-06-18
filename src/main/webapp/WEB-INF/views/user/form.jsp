<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Ajouter un utilisateur
    </jsp:attribute>
	<jsp:attribute name="_page_stylesheets">
		<c:url value="/assets/css/user/form.css" var="_url" />
		<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
    </jsp:attribute>
	<jsp:attribute name="_page_scripts">
		<c:url value="/assets/js/user/form.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
		<c:url value="/assets/js/datatables/jquery.dataTables.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/datatables/dataTables.bootstrap.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
	<jsp:body>

		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12 col-lg-8 col-lg-offset-2">
					<!-- general form elements -->
					<div class="box box-primary">
						<!-- form start -->
						<form role="form">
							<div class="box-body">
								<div class="form-group">
									<label for="exampleInputEmail1">Nom</label>
									<input type="email" class="form-control" id="inputName" placeholder="Nom">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Prénom</label>
									<input type="email" class="form-control" id="inputSurname" placeholder="Prénom">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Email</label>
									<input type="email" class="form-control" id="inputEmail" placeholder="Email">
								</div>
								<div class="checkbox">
									<label>
										<input id="cbAdmin" type="checkbox"/> Administrateur
									</label>
								</div>
							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<a href="../" class="btn btn-warning">Annuler</a>
								<button type="submit" class="btn btn-bitbucket pull-right">&nbsp;&nbsp;Créer&nbsp;&nbsp;</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</jsp:body>
</t:layout>