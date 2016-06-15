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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>AdN Formations - <jsp:invoke fragment="_page_title" />
</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"
	media="screen" />
<c:url value="/assets/css/admin-lte.min.css" var="_url" />
<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}"
	media="screen" />
<c:url value="/assets/css/skin-black.min.css" var="_url" />
<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}"
	media="screen" />
<jsp:invoke fragment="_page_stylesheets" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/reset.css" />
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/favicon.ico" />
</head>
<body class="hold-transition skin-black sidebar-mini">
	<div class="wrapper">
		<t:header>
		</t:header>
		<aside class="main-sidebar">
			<section class="sidebar">
				<div class="user-panel">
	        		<!-- <div class="pull-left image">
		          		<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
		        	</div>-->
	        		<div class="pull-left info">
		          		<p>Alexander Pierce</p>
		          		<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		        	</div>
		      	</div>
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
					 		<i class="fa fa-graduation-cap"></i>
					 		<span>Mes formations</span>
					 	</a>
					</li>
					<li>
						<c:url value="/" var="_url"/>
					 	<a href="${fn:escapeXml(_url)}">
					 		<i class="fa fa-users"></i>
					 		<span>Utilisateurs</span>
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
					Titre <small>Sous-titre</small>
				</h1>
				<ol class="breadcrumb">
					<li><c:url value="/" var="_url" /> <a href="${_url}">Accueil</a>
					</li>
				</ol>
			</section>
			<section class="content">
				<jsp:doBody />
			</section>
		</div>
		<t:footer>
		</t:footer>
		<aside class="control-sidebar control-sidebar-dark"></aside>
		<div class="control-sidebar-bg"></div>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
	<script type="text/javascript"
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<c:url value="/assets/js/admin-lte.min.js" var="_url" />
	<script type="text/javascript" src="${_url}"></script>
	<jsp:invoke fragment="_page_scripts" />
</body>
</html>