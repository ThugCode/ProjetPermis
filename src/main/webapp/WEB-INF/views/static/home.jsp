<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Accueil
    </jsp:attribute>
    <jsp:attribute name="_page_stylesheets">
        <c:url value="/assets/css/home.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
    </jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <c:url value="/assets/js/Chart.min.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
        <c:url value="/assets/js/home.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <!-- LEFT COLUMN -->
            <div class="col-md-6">
                <!-- COMPLETION TOTAL CHART -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Completion total des formations (AP)</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove">
                                <i class="fa fa-times"></i>
                            </button>
                          </div>
                    </div>
                    <div class="box-body">
	                    <div class="chart">
	                        <div id="totalPourcentage">60%</div>
	                        <canvas id="completionTotalChart" style="height: 250px"></canvas>
	                    </div>
                    </div>
                </div>
                <!-- DERNIERES CONNEXIONS -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Dernières connexions (AD et AP)</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove">
                                <i class="fa fa-times"></i>
                            </button>
                          </div>
                    </div>
                    <div class="box-body">
                        <div class="chart">Liste à venir
                            <canvas id="connectionChart" style="height: 250px"></canvas>
                        </div>
                    </div>
                </div>
                <!-- REPARTITION APPRENANT -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Répartition des apprenants par formation (AD)</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove">
                                <i class="fa fa-times"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <canvas id="repartitionChart" style="height: 250px"></canvas>
                    </div>
                </div>
            </div>
            <!-- /LEFT COLUMN -->
            <!-- RIGHT COLUMN -->
            <div class="col-md-6">
                <!-- TEMPS MOYEN -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Temps moyen par formation (AD et AP)</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove">
                                <i class="fa fa-times"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="chart">
                            <canvas id="meanTimeChart" style="height: 250px"></canvas>
                        </div>
                    </div>
                </div>
                <!-- COMPLETION CHART -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Completion moyenne (AD et AP)</h3>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                <i class="fa fa-minus"></i>
                            </button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove">
                                <i class="fa fa-times"></i>
                            </button>
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="chart">
                            <canvas id="completionChart" style="height: 230px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /RIGHT COLUMN -->
        </div>
    </jsp:body>
</t:layout>