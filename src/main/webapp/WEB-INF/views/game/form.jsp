<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Ajouter une épreuve
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
									<label for="inputName">Nom</label>
									<input class="form-control" id="inputName" placeholder="Name">
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">Missions de l'épreuve</div>
									<div class="panel-body">
										Aucune mission pour le moment
									</div>
									<div class="panel-footer text-center">
										<button class="btn btn-bitbucket"><i class="fa fa-plus"></i>&nbsp;Ajouter une mission</button>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">Utilisateurs pouvant accéder à l'épreuve</div>
									<div class="panel-body">
										Aucun utilisateur pour le moment
									</div>
									<div class="panel-footer text-center">
										<button class="btn btn-bitbucket"><i class="fa fa-plus"></i>&nbsp;Ajouter un utilisateur</button>
									</div>
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