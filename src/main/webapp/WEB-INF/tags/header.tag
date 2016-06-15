<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t"%>

<header class="main-header">
			<c:url value="/" var="_url" />
			<a class="logo" href="${_url}"> <span class="logo-mini"><b>A</b>d<b>N</b></span>
				<span class="logo-lg"><b>A</b>d<b>N</b> Formations</span>
			</a>
			<nav class="navbar navbar-static-top">
				<a class="sidebar-toggle" data-toggle="offcanvas" role="button"
					href="#"> <span class="sr-only">Afficher / Cacher la
						navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <span class="label label-success">3</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">Vous avez 3 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">

										<li><a href="#">
												<div class="pull-left">
													<img
														src="<%=request.getContextPath()%>/assets/img/notify_B.png"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Bienvenue <small><i class="fa fa-clock-o"></i> 1
														semaine</small>
												</h4>
												<p>Bienvenue sur votre plateforme de formation</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img
														src="<%=request.getContextPath()%>/assets/img/notify_NF.png"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Nouvelle Formation <small><i class="fa fa-clock-o"></i>
														2 heures</small>
												</h4>
												<p>Vous avez été incrit à une nouvelle formation :
													Formation 3</p>
										</a></li>
										<li><a href="#">
												<div class="pull-left">
													<img
														src="<%=request.getContextPath()%>/assets/img/notify_A.png"
														class="img-circle" alt="User Image">
												</div>
												<h4>
													Message Administrateur <small><i
														class="fa fa-clock-o"></i> 1 heures</small>
												</h4>
												<p>Bonjour, votre formation seront disponible pendant 6
													mois.</p>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">Voir tous mes messages</a></li>
							</ul></li>

						<!-- Tasks: style can be found in dropdown.less -->


						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-flag-o"></i> <span class="label label-danger">${fn:length(user.games)}</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">Vous avez ${fn:length(user.games)}
									formations</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">

										<c:forEach items="${user.games}" var="item">

											<li>
												<!-- Task item --> <a href="#">
													<h3>
														${item.name} <small class="pull-right">20%</small>
													</h3>
													<div class="progress xs">
														<!-- progress-bar-green ou progress-bar-red ou progress-bar-yellow -->
														<div class="progress-bar progress-bar-aqua"
															style="width: 20%" role="progressbar" aria-valuenow="20"
															aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">20% Complete</span>
														</div>
													</div>
											</a>
											</li>

										</c:forEach>

									</ul>
								</li>
								<li class="footer"><a href="#">Voir toutes mes
										formations</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="<%=request.getContextPath()%>/assets/img/user.png"
								class="user-image" alt="User Image" /> <span class="hidden-xs">${user.firstname}
									${user.lastname}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="<%=request.getContextPath()%>/assets/img/bigUser.png"
									class="img-circle" alt="User Image" />
									<p>
										${user.firstname} ${user.lastname} <small>${user.mail}</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profil</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Déconnexion</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>