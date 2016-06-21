<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Mes formations - ${fn:escapeXml(game.name)}
    </jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <c:url value="/assets/css/game/view.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <div class="box-header with-border">
                          <h3 class="box-title">${game.name}</h3>
                    </div>
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <i class="icon fa fa-info"></i> 
                            Terminez toutes les missions pour valider votre épreuve.
                        </div>
                        <%-- @todo Add a message when there are no missions --%>
                        <c:forEach items="${game.missions}" var="item">
                            <a class="missionLine" href="#" >
	                            <div class="panel panel-default">
	                                <div class="panel-heading">
	                                    <h3 class="panel-title">${item.title}</h3>
	                                </div>
	                                <div class="panel-body">
	                                    <div class="progress">
		                                    <div
			                                    class="progress-bar progress-bar-striped active"
			                                    role="progressbar"
			                                    aria-valuenow="45"
			                                    aria-valuemin="0"
			                                    aria-valuemax="100" 
			                                    style="width: 45%"
		                                    >
		                                      40%
		                                    </div>
                                        </div>
	                                </div>
	                            </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>