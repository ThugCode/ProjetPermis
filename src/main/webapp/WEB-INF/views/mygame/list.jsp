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
				<c:forEach items="${games}" var="item" varStatus="loop">
					<a href="${item.id}">
				        <div class="col-md-3 col-sm-6 col-xs-12">
				        	<div class="info-box">
				            	<span class="info-box-icon bg-navy">
				            		<i class="fa fa-graduation-cap"></i>
				            	</span>
				            	<div class="info-box-content">
				              		<span class="info-box-text">${item.name}</span>
				              		<span class="info-box-number">${fn:length(item.missions)} missions</span>
				            	</div>
				          	</div>
				        </div>
			        </a>
			        <c:if test="${loop.index > 0 && loop.index % 2 == 1}">
			            <div class="clearfix visible-sm-block"></div>
			        </c:if>
				</c:forEach>
			</div>
		</section>
	</jsp:body>
</t:layout>