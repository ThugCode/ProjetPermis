<%@tag description="Logged-in page template" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@attribute name="_names" fragment="true" required="true" %>
<%@attribute name="_name" fragment="true" required="true" %>
<%@attribute name="_url_add" fragment="true" required="true" %>
<%@attribute name="_list_stylesheets" fragment="true" required="false" %>
<%@attribute name="_list_scripts" fragment="true" required="false" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Liste des <jsp:invoke fragment="_names"/>
    </jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <c:url value="/assets/js/datatables/dataTables.bootstrap.css" var="_url" />
        <link rel="stylesheet" href="${fn:escapeXml(_url)}">
        <c:url value="/assets/css/layout/list.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <%-- Specific stylesheets --%>
        <jsp:invoke fragment="_list_stylesheets"/>
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <jsp:invoke fragment="_list_scripts"/>
        <c:url value="/assets/js/layout/list.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/datatables/jquery.dataTables.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/datatables/dataTables.bootstrap.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
    <jsp:body>
        <a id="btn-add" href="<jsp:invoke fragment="_url_add" />" class="btn btn-block btn-social btn-bitbucket">
            <i class="fa fa-plus"></i>
            Ajouter <jsp:invoke fragment="_name"/>
        </a>
        <div class="clear"></div>
        <c:if test="${not empty _flashes && fn:length(_flashes) gt 0}">
            <c:forEach items="${_flashes}" var="flash">
                <div class="alert alert-${flash.type} alert-dismissible">
		            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		            ${flash.contents}
		        </div>
            </c:forEach>
        </c:if>
        <div class="box">
            <div class="box-body">
                <table id="tableList" class="table table-bordered table-striped">
                    <jsp:doBody />
                </table>
            </div>
        </div>
    </jsp:body>
</t:layout>