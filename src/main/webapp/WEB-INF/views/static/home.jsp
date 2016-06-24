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
			      //Boolean - whether to make the chart responsive
			      responsive: true,
			      maintainAspectRatio: true,
			      datasetFill: false
			    };
			    
	        	// Build datasets
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

	        	<c:if test="${_user.isAdmin}">
	        	<c:forEach items="${studentsPerGameData}" var="row">
	        	    studentsPerGameData.labels.push("${row[0]}");
	        	    studentsPerGameData.datasets[0].data.push("${row[1]}");
	        	</c:forEach>
	        	
	        	// Then, draw graphics
	        	var barChartCanvas = $("#repartitionChart").get(0).getContext("2d");
	            var barChart = new Chart(barChartCanvas);
	            barChart.Bar(studentsPerGameData, barChartOptions);
	            </c:if>
	            
	            var completionData = {
	            	      labels: [],
	            	      datasets: [
	            	        {
	            	          label: "Non commencé",
	            	          fillColor: "#4E638B",
	            	          strokeColor: "#4E638B",
	            	          pointColor: "#4E638B",
	            	          pointStrokeColor: "#4E638B",
	            	          pointHighlightFill: "#fff",
	            	          pointHighlightStroke: "rgba(60,141,188,1)",
	            	          data: []
	            	        },
	            	        {
	            	          label: "Commencé",
	            	          fillColor: "#D2AC91",
	            	          strokeColor: "#D2AC91",
	            	          pointColor: "#D2AC91",
	            	          pointStrokeColor: "#D2AC91",
	            	          pointHighlightFill: "#fff",
	            	          pointHighlightStroke: "rgba(60,141,188,1)",
	            	          data: []
	            	        },
	            	        {
	            	            label: "Terminé",
	            	            fillColor: "#181C20",
	            	            strokeColor: "#181C20",
	            	            pointColor: "#181C20",
	            	            pointStrokeColor: "#181C20",
	            	            pointHighlightFill: "#fff",
	            	            pointHighlightStroke: "rgba(60,141,188,1)",
	            	            data: []
	            	        }
           	      	]
           	    };

	            <c:forEach items="${meanCompletion}" var="row">
	            	completionData.labels.push("${row[0]}");
	            	completionData.datasets[0].data.push(parseInt("${row[1]}"));
	            	completionData.datasets[1].data.push(parseInt("${row[2]}"));
	            	completionData.datasets[2].data.push(100-parseInt("${row[1]}")+parseInt("${row[2]}"));
        		</c:forEach>
        	    
	            var barChartCanvas = $("#completionChart").get(0).getContext("2d");
	            var barChart = new Chart(barChartCanvas);
	            barChart.Bar(completionData, barChartOptions);

			<c:if test="${!_user.isAdmin}">
	            var pourcentage = ${totalCompletion};
	            
	            $("#totalPourcentage").text(pourcentage+"%");
	            
	            var PieData = [
	              {
	                value: pourcentage,
	                color: "#4E638B",
	                label: "Complétion"
	              },
	              {
	                value: 100-pourcentage,
	                color: "#D2AC91",
	                label: ""
	              }
	            ];
	            
	            var pieOptions = {
	              //Boolean - Whether we should show a stroke on each segment
	              segmentShowStroke: false,
	              //Number - The percentage of the chart that we cut out of the middle
	              percentageInnerCutout: 60,
	              //Number - Amount of animation steps
	              animationSteps: 100,
	              //String - Animation easing effect
	              animationEasing: "easeOutBounce",
	              //Boolean - Whether we animate the rotation of the Doughnut
	              animateRotate: true,
	              //Boolean - Whether we animate scaling the Doughnut from the centre
	              animateScale: false,
	              //Boolean - whether to make the chart responsive to window resizing
	              responsive: true,
	              // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
	              maintainAspectRatio: true,
	              //String - A legend template
	              legendTemplate: "60",
	              inGraphDataShow: true,
	              inGraphDataRadiusPosition: 2,
	              inGraphDataFontColor: 'white'
	            };
	            
	            //Create pie or douhnut chart
	            // You can switch between pie and douhnut using the method below.
	            
	            var pieChartCanvas = $("#completionTotalChart").get(0).getContext("2d");
	            var pieChart = new Chart(pieChartCanvas);
	            pieChart.Doughnut(PieData, pieOptions);
            </c:if>

	        });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            
            <c:if test="${!_user.isAdmin}">
            <!-- COMPLETION TOTAL CHART -->
            <div class="col-md-6 sectionChart">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Completion total des formations</h3>
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
	                        <div id="totalPourcentage"></div>
	                        <canvas id="completionTotalChart"></canvas>
	                    </div>
                    </div>
                </div>
            </div>
           </c:if>
           
            <!-- DERNIERES CONNEXIONS -->
            <div class="col-md-6 sectionChart">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Dernières connexions</h3>
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
                                            <c:choose>
                                                <c:when test="${_user.isAdmin}">
                                                    <c:url value="/users/modify/${row.student.id}" var="_url" />
                                                    <a href="${_url}">
                                                        ${fn:escapeXml(row.student.firstname)} 
                                                        ${fn:escapeXml(row.student.lastname)} s'est connecté(e) à
                                                    </a>
                                                </c:when>
                                                <c:otherwise>
                                                    Vous vous êtes connecté(e) à 
                                                </c:otherwise>
                                            </c:choose>
                                            <fmt:formatDate type="time" value="${row.dateLogin}" />
                                            le
                                            <fmt:formatDate type="date" value="${row.dateLogin}" />
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- REPARTITION APPRENANT -->
            <c:if test="${_user.isAdmin}">
            <div class="col-md-6 sectionChart">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Répartition des apprenants par formation</h3>
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
                        <canvas id="repartitionChart"></canvas>
                    </div>
                </div>
            </div>
            </c:if>
            
            <!-- COMPLETION CHART -->
            <div class="col-md-6 sectionChart">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Completion moyenne</h3>
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
                            <canvas id="completionChart"></canvas>
                        </div>
                    </div>
                </div>
            </div>

		</div>
    </jsp:body>
</t:layout>