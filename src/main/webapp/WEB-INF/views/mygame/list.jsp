<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Ajouter un utilisateur
    </jsp:attribute>

	<jsp:body>
		<section class="content">
			<div class="row">
				<c:forEach items="${games}" var="item">
					<a href="${item.id}">
			        <div class="col-md-4 col-sm-6 col-xs-12">
			        	<div class="info-box">
			            	<span class="info-box-icon btn-bitbucket">
			            		<c:url value="/assets/img/games/default.png" var="_url" />
			            		<img src="${fn:escapeXml(_url)}"></img>
			            	</span>
			            	<div class="info-box-content">
			              		<span class="info-box-text">${item.name}</span>
			              		<span class="info-box-number">${fn:length(item.missions)} missions</span>
			            	</div>
			          	</div>
			        </div>
			        </a>
				</c:forEach>
			</div>
		</section>
	</jsp:body>
</t:layout>