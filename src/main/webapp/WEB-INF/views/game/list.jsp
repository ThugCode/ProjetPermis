<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:list>

	<jsp:attribute name="_name">une épreuve</jsp:attribute>
	<jsp:attribute name="_names">épreuves</jsp:attribute>
    <jsp:attribute name="_url_add">
        <c:url value="/games/add" var="_url"/>
        ${fn:escapeXml(_url)}
    </jsp:attribute>
	<jsp:body>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Nombre de missions associées</th>
				<th>Nombre d'utilisateurs associés</th>
				<th>Contrôles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${games}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${fn:length(item.missions)}</td>
					<td>${fn:length(item.students)}</td>
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