<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<header class="main-header">
    <c:url value="/" var="_url" />
    <a class="logo" href="${fn:escapeXml(_url)}">
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
                        <span class="label label-success">${fn:length(_user.messages)}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">
                            <c:choose>
                                <c:when test="${fn:length(_user.messages) gt 1}">
                                    Vous avez ${fn:length(_user.messages)} messages.
                                </c:when>
                                <c:when test="${fn:length(_user.messages) eq 1 }">
                                    Vous avez 1 message.
                                </c:when>
                                <c:otherwise>
                                    Vous n'avez aucun message.
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li>
                            <ul class="menu">
                                <c:forEach items="${_user.messages}" var="item">
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
                        <span class="label label-danger">${fn:length(_user.games)}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">
                            <c:choose>
                                <c:when test="${fn:length(_user.games) gt 1}">
                                    Vous avez ${fn:length(_user.games)} formations.
                                </c:when>
                                <c:when test="${fn:length(_user.games) eq 1 }">
                                    Vous avez 1 formation.
                                </c:when>
                                <c:otherwise>
                                    Vous n'avez aucune formation.
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li>
                            <ul class="menu">
                                <c:forEach items="${_user.games}" var="item">
                                    <li>
                                        <c:url value="/mygames/${item.id}" var="_url" />
                                        <a href="${fn:escapeXml(_url)}">
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
                            <a href="${fn:escapeXml(_url)}">Voir toutes mes formations</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user fa-lg"></i>
                        <span class="hidden-xs">${_user.firstname} ${_user.lastname}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <p>
                                ${_user.firstname} ${_user.lastname}
                                <small>${_user.mail}</small>
                            </p>
                        </li>
                        <li class="user-footer">
                            <%--
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profil</a>
                            </div>
                            --%>
                            <div class="pull-right">
                                <c:url value="/logout" var="_url" />
                                <a href="${fn:escapeXml(_url)}" class="btn btn-default btn-flat">Déconnexion</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
