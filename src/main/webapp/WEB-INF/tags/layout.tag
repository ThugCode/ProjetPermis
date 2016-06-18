<%@tag description="Logged-in page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t"%>
<%@attribute name="_page_title" fragment="true" required="false"%>
<%@attribute name="_page_stylesheets" fragment="true" required="false"%>
<%@attribute name="_page_scripts" fragment="true" required="false"%>

<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		
		<title>AdN Formations - <jsp:invoke fragment="_page_title"/></title>
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/favicon.ico"/>

		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/admin-lte.min.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/skin-black.min.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/layout.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/reset.css" />
		
		<jsp:invoke fragment="_page_stylesheets" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<c:url value="/assets/js/admin-lte.min.js" var="_url" />
		<script type="text/javascript" src="${_url}"></script>
		
		<jsp:invoke fragment="_page_scripts" />
		
	</head>
	
	<body class="hold-transition skin-black sidebar-mini">
	<div class="wrapper">
		
		<t:header></t:header>
		
		<aside class="main-sidebar">
			<section class="sidebar">

				<form class="sidebar-form" method="get" action="#">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="Rechercher..." />
						<span class="input-group-btn">
							<button type="submit" name="search" id="search-btn" class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<ul class="sidebar-menu">
					<li>
						<c:url value="/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-pie-chart fa-lg"></i>
					 		<span>Statistiques</span>
					 	</a>
					</li>
					<li>
						<c:url value="/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-graduation-cap fa-lg"></i>
					 		<span>Mes formations</span>
					 	</a>
					</li>
					<li>
						<c:url value="/users/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-users fa-lg"></i>
					 		<span>Utilisateurs</span>
					 	</a>
					</li>
					<li>
						<c:url value="/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-files-o fa-lg"></i>
					 		<span>Parcours</span>
					 	</a>
					</li>
					<li>
						<c:url value="/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-file-o fa-lg"></i>
					 		<span>Modules</span>
					 	</a>
					</li>
					<li>
						<c:url value="/goals/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-check-square fa-lg"></i>
					 		<span>Objectifs</span>
					 	</a>
					</li>
					<!--
					<li class="treeview">
			          	<a href="#">
				            <i class="fa fa-pie-chart"></i>
			            	<span>Charts</span>
				            <i class="fa fa-angle-left pull-right"></i>
			          	</a>
			          	<ul class="treeview-menu">
			            	<li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
			            	<li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
			            	<li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
			            	<li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
			          	</ul>
			        </li>
			        -->
				</ul>
			</section>
		</aside>
		
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					${page}
				</h1>
			</section>
			<section class="content">
				<jsp:doBody />
			</section>
		</div>
		
		<t:footer></t:footer>
		
		<aside class="control-sidebar control-sidebar-dark"></aside>
		<div class="control-sidebar-bg"></div>
	</div>
	
</body>
</html>