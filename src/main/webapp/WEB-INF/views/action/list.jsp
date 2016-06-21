<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:list>

	<jsp:attribute name="_name">une action</jsp:attribute>
	<jsp:attribute name="_names">actions</jsp:attribute>
    <jsp:attribute name="_url_add">
        <c:url value="/actions/add" var="_url"/>
        ${fn:escapeXml(_url)}
    </jsp:attribute>
	<jsp:body>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Contrôles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${actions}" var="item">
				<tr>
					<td>${item.name}</td>
					<td class="actionCol">
						<a type="button" href="modify/${item.id}" class="btn self-border" title="Modifier">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>
						<a type="button" href="delete/${item.id}" class="btn btndel self-border" title="Supprimer">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</jsp:body>
</t:list>