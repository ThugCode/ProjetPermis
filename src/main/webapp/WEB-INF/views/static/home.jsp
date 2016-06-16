<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
	<jsp:attribute name="_page_title">
        Accueil
    </jsp:attribute>
	<jsp:attribute name="_page_stylesheets">
		<c:url value="/assets/css/home.css" var="_url" />
		<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
    </jsp:attribute>
	<jsp:attribute name="_page_scripts">
        <!-- Scripts -->
    </jsp:attribute>
	<jsp:body>
		<section class="content">
			<div class="row">
			
				<!-- LEFT COLUMN -->
				<div class="col-md-6">
	        
					<!-- DERNIERES CONNEXIONS -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Dernières connexions (admin)</h3>
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
		              			Bar chart à venir
		                		<canvas id="connectionChart" style="height: 250px"></canvas>
		              		</div>
	            		</div>
	          		</div>
	
					<!-- REPARTITION APPRENANT -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Répartition des apprenants par formation (admin)</h3>
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
	            			Bar chart à venir
	              			<canvas id="repartitionChart" style="height: 250px"></canvas>
	            		</div>
	          		</div>
	          		
	          		<!-- COMPLETION TOTAL CHART -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Completion total des formations (Apprenant)</h3>
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
		              			Pie chart à venir
		                		<canvas id="connectionChart" style="height: 250px"></canvas>
		              		</div>
	            		</div>
	          		</div>
	          		
        		</div>
	        	<!-- /LEFT COLUMN -->
	        	
	        	<!-- RIGHT COLUMN -->
				<div class="col-md-6">

					<!-- TEMPS MOYEN -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Temps moyen par formation (admin et apprenant)</h3>
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
							Line chart à venir
								<canvas id="meanTimeChart" style="height: 250px"></canvas>
							</div>
						</div>
					</div>
	
					<!-- COMPLETION CHART -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Completion moyenne (admin et apprenant)</h3>
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
								Bar chart à venir
								<canvas id="completionChart" style="height: 230px"></canvas>
							</div>
						</div>
					</div>
					
        		</div>
	        	<!-- /RIGHT COLUMN -->
	        	
			</div>
    	</section>
    </jsp:body>
</t:layout>