<%@tag description="Logged-in page template" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@attribute name="_page_title" fragment="true" required="false" %>
<%@attribute name="_page_stylesheets" fragment="true" required="false" %>
<%@attribute name="_page_scripts" fragment="true" required="false" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>
            [Nom du site]
            <jsp:invoke fragment="_page_title" />
        </title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/skin-black.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <jsp:invoke fragment="_page_stylesheets" />
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition skin-black sidebar-mini">
    	<div class="wrapper">
    		<header class="main-header">
    			<c:url value="/" var="_url" />
    			<a class="logo" href="${_url}">
    				<span class="logo-mini"><b>A</b>B</span>
    				<span class="logo-lg"><b>ABC</b>DEF</span>
    			</a>
    			<nav class="navbar navbar-static-top">
    				<a class="sidebar-toggle" data-toggle="offcanvas" role="button" href="#">
    					<span class="sr-only">Afficher / Cacher la navigation</span>
    				</a>
    				<div class="navbar-custom-menu">
    					<ul class="nav navbar-nav">
    						<li class="dropdown messages-menu">
					            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
					              <i class="fa fa-envelope-o"></i>
					              <span class="label label-success">4</span>
					            </a>
					            <ul class="dropdown-menu">
					              	<li class="header">You have 4 messages</li>
					              	<li>
					                <!-- inner menu: contains the actual data -->
					                	<ul class="menu">
					                  		<li><!-- start message -->
					                    		<a href="#">
					                      			<div class="pull-left">
					                        			<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
					                      			</div>
					                      			<h4>
					                        			Support Team
					                        			<small><i class="fa fa-clock-o"></i> 5 mins</small>
					                      			</h4>
					                      			<p>Why not buy a new awesome theme?</p>
				                    			</a>
					                  		</li>
					                  		<!-- end message -->
					                  		<li>
					                    		<a href="#">
					                      			<div class="pull-left">
					                        			<img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
					                      			</div>
					                      			<h4>
					                        			AdminLTE Design Team
					                        			<small><i class="fa fa-clock-o"></i> 2 hours</small>
					                      			</h4>
					                      			<p>Why not buy a new awesome theme?</p>
				                    			</a>
					                  		</li>
					                  		<li>
					                    		<a href="#">
					                      			<div class="pull-left">
					                        			<img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
					                      			</div>
					                      			<h4>
					                        			Developers
					                        			<small><i class="fa fa-clock-o"></i> Today</small>
					                      			</h4>
					                      			<p>Why not buy a new awesome theme?</p>
				                    			</a>
				                  			</li>
					                  		<li>
				                    			<a href="#">
					                      			<div class="pull-left">
					                        			<img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
					                      			</div>
					                      			<h4>
					                        			Sales Department
					                        			<small><i class="fa fa-clock-o"></i> Yesterday</small>
					                      			</h4>
					                      			<p>Why not buy a new awesome theme?</p>
					                    		</a>
					                  		</li>
					                  		<li>
					                    		<a href="#">
					                      			<div class="pull-left">
					                        			<img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
					                      			</div>
					                      			<h4>
					                        			Reviewers
					                        			<small><i class="fa fa-clock-o"></i> 2 days</small>
					                      			</h4>
					                      			<p>Why not buy a new awesome theme?</p>
					                    		</a>
					                  		</li>
						                </ul>
					              	</li>
					              	<li class="footer"><a href="#">See All Messages</a></li>
				            	</ul>
				          	</li>
				          	<li class="dropdown notifications-menu">
            					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
              						<i class="fa fa-bell-o"></i>
              						<span class="label label-warning">10</span>
            					</a>
            					<ul class="dropdown-menu">
              						<li class="header">You have 10 notifications</li>
           							<li>
                						<!-- inner menu: contains the actual data -->
						                <ul class="menu">
						                  	<li>
						                    	<a href="#">
						                      	<i class="fa fa-users text-aqua"></i> 5 new members joined today
						                    	</a>
						                  	</li>
						                  	<li>
							                    <a href="#">
								                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
								                      page and may cause design problems
							                    </a>
						                  	</li>
						                  	<li>
							                    <a href="#">
							                      	<i class="fa fa-users text-red"></i> 5 new members joined
							                    </a>
						                  	</li>
						                  	<li>
							                    <a href="#">
							                      	<i class="fa fa-shopping-cart text-green"></i> 25 sales made
							                    </a>
						                  	</li>
						                  	<li>
					                    		<a href="#">
						                      		<i class="fa fa-user text-red"></i> You changed your username
							                    </a>
						                  	</li>
					                	</ul>
					              	</li>
					              	<li class="footer"><a href="#">View all</a></li>
            					</ul>
       						</li>
          <!-- Tasks: style can be found in dropdown.less -->
				          	<li class="dropdown tasks-menu">
				            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				              		<i class="fa fa-flag-o"></i>
				              		<span class="label label-danger">9</span>
			            		</a>
				            	<ul class="dropdown-menu">
				              		<li class="header">You have 9 tasks</li>
				              		<li>
				                		<!-- inner menu: contains the actual data -->
				                		<ul class="menu">
				                  			<li><!-- Task item -->
				                    			<a href="#">
				                      				<h3>
				                        				Design some buttons
			                        					<small class="pull-right">20%</small>
				                      				</h3>
				                      				<div class="progress xs">
				                        				<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
					                          				<span class="sr-only">20% Complete</span>
				                        				</div>
				                      				</div>
			                    				</a>
				                  			</li>
				                  			<!-- end task item -->
				                  			<li><!-- Task item -->
				                    			<a href="#">
				                      				<h3>
				                        				Create a nice theme
				                        				<small class="pull-right">40%</small>
			                      					</h3>
							                      	<div class="progress xs">
								                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
							                          		<span class="sr-only">40% Complete</span>
							                        	</div>
							                      	</div>
				                    			</a>
				                  			</li>
				                  			<!-- end task item -->
				                  			<li><!-- Task item -->
				                    			<a href="#">
				                      				<h3>
								                        Some task I need to do
								                        <small class="pull-right">60%</small>
				                      				</h3>
				                      				<div class="progress xs">
				                        				<div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
				                          					<span class="sr-only">60% Complete</span>
				                        				</div>
				                      				</div>
				                    			</a>
				                  			</li>
				                  			<!-- end task item -->
				                  			<li><!-- Task item -->
				                    			<a href="#">
							                      	<h3>
							                        	Make beautiful transitions
							                        	<small class="pull-right">80%</small>
							                      	</h3>
				                      				<div class="progress xs">
				                        				<div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
				                          					<span class="sr-only">80% Complete</span>
				                        				</div>
				                      				</div>
				                    			</a>
				                  			</li>
				                  			<!-- end task item -->
				                		</ul>
				              		</li>
				              		<li class="footer">
				                		<a href="#">View all tasks</a>
				              		</li>
				            	</ul>
				          	</li>
       						<!-- User Account: style can be found in dropdown.less -->
          					<li class="dropdown user user-menu">
					            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
					              	<img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image" />
					              	<span class="hidden-xs">Alexander Pierce</span>
					            </a>
            					<ul class="dropdown-menu">
              						<!-- User image -->
              						<li class="user-header">
                						<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                						<p>
						                  	Alexander Pierce - Web Developer
						                  	<small>Member since Nov. 2012</small>
                						</p>
           							</li>
              						<!-- Menu Body -->
              						<li class="user-body">
                						<div class="row">
                  							<div class="col-xs-4 text-center">
                    							<a href="#">Followers</a>
                  							</div>
                  							<div class="col-xs-4 text-center">
						                    	<a href="#">Sales</a>
						                  	</div>
						                  	<div class="col-xs-4 text-center">
							                    <a href="#">Friends</a>
						                  	</div>
                						</div>
                						<!-- /.row -->
              						</li>
              						<!-- Menu Footer-->
              						<li class="user-footer">
                						<div class="pull-left">
                  							<a href="#" class="btn btn-default btn-flat">Profile</a>
                						</div>
               							<div class="pull-right">
                  							<a href="#" class="btn btn-default btn-flat">Sign out</a>
                						</div>
              						</li>
            					</ul>
          					</li>
   						</ul>
   					</div>
    			</nav>
    		</header>
    		<aside class="main-sidebar">
    			<section class="sidebar">
    				<div class="user-panel">
    					<div class="pull-left image">
    						<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
    					</div>
    					<div class="pull-left info">
				          	<p>Alexander Pierce</p>
				          	<a href="#">
				          		<i class="fa fa-circle text-success"></i> Online
				          	</a>
				        </div>
    				</div>
    				<form class="sidebar-form" method="get" action="#">
    					<div class="input-group">
				          	<input type="text" name="q" class="form-control" placeholder="Search..." />
			              	<span class="input-group-btn">
				                <button type="submit" name="search" id="search-btn" class="btn btn-flat">
				                	<i class="fa fa-search"></i>
				                </button>
			              	</span>
				        </div>
    				</form>
    				<ul class="sidebar-menu">
    				</ul>
    			</section>
    		</aside>
    		<div class="content-wrapper">
    			<section class="content-header">
    				<h1>
    					Titre
    					<small>Sous-titre</small>
    				</h1>
    				<ol class="breadcrumb">
    					<li>
    						<c:url value="/" var="_url" />
    						<a href="${_url}">Accueil</a>
    					</li>
    				</ol>
    			</section>
    			<section class="content">
    				<jsp:doBody />
    			</section>
    		</div>
    		<footer class="main-footer">
    			<div class="pull-right hidden-xs">
    				<b>Version</b> 1.0
    			</div>
    			<strong>&copy; [Nom du site]</strong>, 2016
    		</footer>
    		<aside class="control-sidebar control-sidebar-dark">
    		</aside>
    		<div class="control-sidebar-bg"></div>
    	</div>
    	
    	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <c:url value="/assets/js/admin-lte.min.js" var="_url" />
        <script type="text/javascript" src="${_url}"></script>
        <jsp:invoke fragment="_page_scripts" />
    </body>
</html>