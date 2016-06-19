<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Epreuve ${game.name}
    </jsp:attribute>
    
	<jsp:body>
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12 col-lg-8 col-lg-offset-2">
					<!-- general form elements -->
					<div class="box box-primary">
						
					</div>
				</div>
			</div>
		</section>
	</jsp:body>
</t:layout>