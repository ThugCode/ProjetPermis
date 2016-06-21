<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:list>
    <jsp:attribute name="_name">une mission</jsp:attribute>
    <jsp:attribute name="_names">missions</jsp:attribute>
    <jsp:attribute name="_url_add">
        <c:url value="/missions/add" var="_url"/>
        ${fn:escapeXml(_url)}
    </jsp:attribute>
    <jsp:body>
        <thead>
            <tr>
                <th>Titre</th>
                <th>Nombre d'objectif(s) associé(s)</th>
                <th>Contrôles</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${missions}" var="item">
                <tr>
                    <td>
                        ${item.title}
                    </td>
                    <td class="text-center">
                        ${fn:length(item.goals)}
                    </td>
                    <td class="actionCol">
                        <c:url value="/missions/modify/${item.id}" var="_url" />
                        <a type="button" href="${fn:escapeXml(_url)}" class="btn self-border" title="Modifier">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a>
                        <c:url value="/missions/delete/${item.id}" var="_url" />
                        <a type="button" href="${fn:escapeXml(_url)}" class="btn btndel self-border" title="Supprimer">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </jsp:body>
</t:list>