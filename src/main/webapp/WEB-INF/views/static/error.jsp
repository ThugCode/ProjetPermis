<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">Erreur</jsp:attribute>

	<jsp:body>
		<section class="content">
			<div class="error-page">
				<h2 class="headline text-yellow"> 404 </h2>
				<div class="error-content">
					<h3><i class="fa fa-warning text-yellow"></i> Oups! Page introuvable.</h3>
					<p> ${customMessage}</p>
					<p>${errorMessage}</p>
					<p>${stackTrace}</p>
					<p style="text-align: justify;">Nous n'avons pas pu trouver la page que vous recherchez.
					Vous pouvez <a href="/permis/">retourner au tableau de bord</a> ou utiliser le champs de recherche.
					</p>

					<form class="search-form">
						<div class="input-group">
							<input type="text" name="search" class="form-control" placeholder="Search">
							<div class="input-group-btn">
								<button type="submit" name="submit" class="btn btn-warning btn-flat">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</section>
	</jsp:body>
</t:layout>