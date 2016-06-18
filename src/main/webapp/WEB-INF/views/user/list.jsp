<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Liste des utilisateurs
    </jsp:attribute>
	<jsp:attribute name="_page_stylesheets">
		<c:url value="/assets/css/user/list.css" var="_url" />
		<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
		
		<c:url value="/assets/js/datatables/dataTables.bootstrap.css" var="_url" />
		<link rel="stylesheet" href="${fn:escapeXml(_url)}">
  
		
    </jsp:attribute>
	<jsp:attribute name="_page_scripts">
		<c:url value="/assets/js/user/list.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
		<c:url value="/assets/js/datatables/jquery.dataTables.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/datatables/dataTables.bootstrap.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
	<jsp:body>
	
	<a id="btn-add-user" href="add" class="btn btn-block btn-social btn-bitbucket">
		<i class="fa fa-user-plus"></i> Ajouter un utilisateur
	</a>
              
  <!-- Content Wrapper. Contains page content -->
  <div id="content-margin" class="content-wrapper">

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">

          <div class="box">
            
            <div class="box-body">
              <table id="tableList" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Nom</th>
                  <th>Prénom</th>
                  <th>Email</th>
                  <th>En attente de validation</th>
                  <th>Contrôles</th>
                </tr>
                </thead>
                <tbody>
                
                <c:forEach items="${users}" var="item">
					<tr class="<c:if test='${item.isEnabled}'>waitingActivate</c:if>">
						<td>${item.lastname}</td>
						<td>${item.firstname}</td>
						<td>${item.mail}</td>
						<td><c:if test='${item.isEnabled}'>OUI</c:if></td>
						<td class="actionCol dt-right">
							<c:if test='${item.isEnabled}'>
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
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

</jsp:body>
</t:layout>