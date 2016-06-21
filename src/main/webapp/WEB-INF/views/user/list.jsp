<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:list>
    <jsp:attribute name="_name">un utilisateur</jsp:attribute>
    <jsp:attribute name="_names">utilisateurs</jsp:attribute>
    <jsp:attribute name="_url_add">
        <c:url value="/users/add" var="_url"/>
        ${fn:escapeXml(_url)}
    </jsp:attribute>
    <jsp:attribute name="_list_stylesheets">
        <c:url value="/assets/css/user/list.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_list_scripts">
        <c:url value="/assets/js/user/list.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
    <jsp:body>
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>En attente de validation</th>
                <th>Est administrateur ?</th>
                <th>Contrôles</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="item">
                <tr class="<c:if test='${!item.isEnabled}'>waitingActivate</c:if>">
                    <td>
                        ${item.lastname}
                    </td>
                    <td>
                        ${item.firstname}
                    </td>
                    <td>
                        ${item.mail}
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${!item.isEnabled}">
                                Oui
                            </c:when>
                            <c:otherwise>
                                Non
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${item.isAdmin}">
                                Oui
                            </c:when>
                            <c:otherwise>
                                Non
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="actionCol">
	                    <c:if test="${!item.isEnabled}">
	                        <a type="button" class="btn self-border" title="Valider">
	                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
	                        </a>
	                    </c:if>
                        <a type="button" class="btn self-border" title="Modifier">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                        <a type="button" class="btn btndel self-border" title="Supprimer">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </jsp:body>
</t:list>