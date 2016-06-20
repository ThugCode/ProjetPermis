<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t"%>

<header class="main-header">
    <c:url value="/" var="_url" />
    <a class="logo" href="${_url}">
        <span class="logo-mini"><b>A</b>d<b>N</b></span>
        <span class="logo-lg"><b>A</b>d<b>N</b> Formations</span>
    </a>
    <nav class="navbar navbar-static-top">
        <a class="sidebar-toggle" data-toggle="offcanvas" role="button" href="#">
            <span class="sr-only">Afficher / Cacher la navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope"></i>
                        <span class="label label-success">${fn:length(user.messages)}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">Vous avez ${fn:length(user.messages)} messages</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <c:forEach items="${user.messages}" var="item">
                                    <li>
                                        <a href="#">
                                           <div class="pull-left">
                                               <i class="fa fa-bookmark<c:if test="${item.read}">-o</c:if>"></i>
                                           </div>
                                           <h4>
                                               ${item.subject}
                                               <small><i class="fa fa-clock-o"></i>${item.dateReception}</small>
                                           </h4>
                                           <p>${item.body}</p>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="footer">
                            <a href="#">Voir tous mes messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown tasks-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-graduation-cap"></i>
                        <span class="label label-danger">${fn:length(user.games)}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">
                            Vous avez ${fn:length(user.games)} formations
                        </li>
                        <li>
                            <ul class="menu">
                                <c:forEach items="${user.games}" var="item">
                                    <li>
                                        <a href="#">
                                            <h3>
                                                ${item.name}
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <!-- progress-bar-green ou progress-bar-red ou progress-bar-yellow -->
                                                <div
                                                    class="progress-bar progress-bar-aqua"
                                                    style="width: 20%"
                                                    role="progressbar"
                                                    aria-valuenow="20"
                                                    aria-valuemin="0"
                                                    aria-valuemax="100"
                                                >
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="footer">
                            <c:url value="/mygames" var="_url" />
                            <a href="${_url}">Voir toutes mes formations</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user fa-lg"></i>
                        <span class="hidden-xs">${user.firstname} ${user.lastname}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <c:url value="/assets/img/bigUser.png" var="_url" />
                            <img src="${_url}" class="img-circle" alt="User Image" />
                            <p>
                                ${user.firstname} ${user.lastname}
                                <small>${user.mail}</small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profil</a>
                            </div>
                            <div class="pull-right">
                                <c:url value="/logout" var="_url" />
                                <a href="${_url}" class="btn btn-default btn-flat">Déconnexion</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
