<%@tag description="Logged-in page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@attribute name="_names" fragment="true" required="true"%>
<%@attribute name="_name" fragment="true" required="true"%>
<%@attribute name="_list_stylesheets" fragment="true" required="false"%>
<%@attribute name="_list_scripts" fragment="true" required="false"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Liste des <jsp:invoke fragment="_names"/>
    </jsp:attribute>
    
	<jsp:attribute name="_page_stylesheets">
	
		<c:url value="/assets/js/datatables/dataTables.bootstrap.css" var="_url" />
		<link rel="stylesheet" href="${fn:escapeXml(_url)}">
		<c:url value="/assets/css/layout/list.css" var="_url" />
		<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
		
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
	
		<a id="btn-add" href="add" class="btn btn-block btn-social btn-bitbucket">
			<i class="fa fa-plus"></i> Ajouter <jsp:invoke fragment="_name"/>
		</a>
		<div id="content-margin" class="content-wrapper">
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body">
								<table id="tableList" class="table table-bordered table-striped">
									<jsp:doBody/>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</jsp:body>
</t:layout>