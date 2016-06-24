<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="fr_FR" />
<fmt:requestEncoding value="UTF-8" />

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
        <script type="text/javascript">
	        $(function() {
	        	// Options
	        	var barChartOptions = {
			      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
			      scaleBeginAtZero: true,
			      //Boolean - Whether grid lines are shown across the chart
			      scaleShowGridLines: true,
			      //String - Colour of the grid lines
			      scaleGridLineColor: "rgba(0,0,0,.05)",
			      //Number - Width of the grid lines
			      scaleGridLineWidth: 1,
			      //Boolean - Whether to show horizontal lines (except X axis)
			      scaleShowHorizontalLines: true,
			      //Boolean - Whether to show vertical lines (except Y axis)
			      scaleShowVerticalLines: true,
			      //Boolean - If there is a stroke on each bar
			      barShowStroke: true,
			      //Number - Pixel width of the bar stroke
			      barStrokeWidth: 2,
			      //Number - Spacing between each of the X value sets
			      barValueSpacing: 5,
			      //Number - Spacing between data sets within X values
			      barDatasetSpacing: 1,
			      //String - A legend template
			      <%--
			      legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
			      --%>
			      //Boolean - whether to make the chart responsive
			      responsive: true,
			      maintainAspectRatio: true,
			      datasetFill: false
			    };
	        	// Build dataset
	        	var studentsPerGameData = {
        			labels: [],
        			datasets: [{
        				label: "Répartation des apprenants",
	       		        fillColor: "#4E638B",
	       		        strokeColor: "#4E638B",
	       		        pointColor: "#4E638B",
	       		        pointStrokeColor: "#4E638B",
	       		        pointHighlightFill: "#fff",
	       		        pointHighlightStroke: "rgba(60,141,188,1)",
	       		        data: []
        			}]
	        	};
	        	
	        	<c:forEach items="${studentsPerGameData}" var="row">
	        	    studentsPerGameData.labels.push("${row[0]}");
	        	    studentsPerGameData.datasets[0].data.push(${row[1]});
	        	</c:forEach>
	        	
	        	// Then, draw graphics
	        	var barChartCanvas = $("#repartitionChart").get(0).getContext("2d");
	            var barChart = new Chart(barChartCanvas);
	            barChart.Bar(studentsPerGameData, barChartOptions);
	        });
        </script>
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
                        <div class="chart">
                            <c:if test="${not empty loginData && fn:length(loginData) gt 0}">
                                <ul>
                                    <c:forEach items="${loginData}" var="row">
                                        <li>
                                            ${fn:escapeXml(row.student.firstname)}
                                            ${fn:escapeXml(row.student.lastname)}
                                            s'est connecté(e) à
                                            <fmt:formatDate type="time" value="${row.dateLogin}" />
                                            le
                                            <fmt:formatDate type="date" value="${row.dateLogin}" />
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                            <%-- <canvas id="connectionChart" style="height: 250px"></canvas> --%>
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