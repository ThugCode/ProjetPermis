<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:list>

	<jsp:attribute name="_name">une mission</jsp:attribute>
	<jsp:attribute name="_names">missions</jsp:attribute>
    
	<jsp:body>
		<thead>
			<tr>
				<th>Titre</th>
				<th>Nombre d'objectifs associés</th>
				<th>Contrôles</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${missions}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${fn:length(item.goals)}</td>
					<td class="actionCol">
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