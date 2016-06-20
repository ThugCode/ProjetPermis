<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:list>

	<jsp:attribute name="_name">un objectif</jsp:attribute>
	<jsp:attribute name="_names">objectifs</jsp:attribute>
    
	<jsp:body>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Nombre d'actions associées</th>
				<th>Contrôles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goals}" var="item">
				<tr>
					<td>${item.name}</td>
					<td class="text-center">${fn:length(item.actions)}</td>
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