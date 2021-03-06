<%@tag description="Logged-in page template" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@attribute name="_page_title" fragment="true" required="false" %>
<%@attribute name="_page_stylesheets" fragment="true" required="false" %>
<%@attribute name="_page_scripts" fragment="true" required="false" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>AdN Formations - <jsp:invoke fragment="_page_title"/></title>
        <c:url value="/assets/favicon.ico" var="_url" />
        <link rel="shortcut icon" href="${fn:escapeXml(_url)}"/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/skin-black.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <c:url value="/assets/css/layout.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <%--
        <c:url value="/assets/css/reset.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        --%>
        <jsp:invoke fragment="_page_stylesheets" />
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
                            <c:url value="/mygames/" var="_url"/>
                            <a href="${fn:escapeXml(_url)}">
                                <i class="fa fa-graduation-cap fa-lg"></i>
                                <span>Mes formations</span>
                            </a>
                        </li>
                        <c:if test="${_user.isAdmin}">
                            <li>
                                <c:url value="/users/" var="_url"/>
                                <a href="${fn:escapeXml(_url)}">
                                    <i class="fa fa-users fa-lg"></i>
                                    <span>Utilisateurs</span>
                                </a>
                            </li>
                            <li>
                                <c:url value="/games/" var="_url"/>
                                <a href="${fn:escapeXml(_url)}">
                                    <i class="fa fa-th fa-lg"></i>
                                    <span>Épreuves</span>
                                </a>
                            </li>
                            <li>
                                <c:url value="/missions/" var="_url"/>
                                <a href="${fn:escapeXml(_url)}">
                                    <i class="fa fa-list-alt fa-lg"></i>
                                    <span>Missions</span>
                                </a>
                            </li>
                            <li>
                                <c:url value="/goals/" var="_url"/>
                                <a href="${fn:escapeXml(_url)}">
                                    <i class="fa fa-check-square fa-lg"></i>
                                    <span>Objectifs</span>
                                </a>
                            </li>
                            <li>
                                <c:url value="/actions/" var="_url"/>
                                <a href="${fn:escapeXml(_url)}">
                                    <i class="fa fa-star fa-lg"></i>
                                    <span>Actions</span>
                                </a>
                            </li>
                        </c:if>
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
       </div>
       <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
       <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
       <c:url value="/assets/js/admin-lte.min.js" var="_url" />
       <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
       <jsp:invoke fragment="_page_scripts" />
    </body>
</html>