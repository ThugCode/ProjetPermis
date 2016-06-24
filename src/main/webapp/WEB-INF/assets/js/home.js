$(function () {
    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

	//-------------
    //- PIE CHART -
    //-------------
    
    var pourcentage = 60;
    
    $("#totalPourcentage").text(pourcentage+"%");
    
    
    var pieChartCanvas = $("#completionTotalChart").get(0).getContext("2d");
    var pieChart = new Chart(pieChartCanvas);
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
    pieChart.Doughnut(PieData, pieOptions);
    
    
    //--------------
    //- AREA CHART -
    //--------------

    var learnersRepartitionData = {
      labels: ["Formation 1", "Formation 2", "Formation 3"],
      datasets: [
        {
          label: "Répartition des apprenants",
          fillColor: "#4E638B",
          strokeColor: "#4E638B",
          pointColor: "#4E638B",
          pointStrokeColor: "#4E638B",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: [65, 59, 80]
        }
      ]
    };
    
    var completionData = {
      labels: ["Formation 1", "Formation 2", "Formation 3"],
      datasets: [
        {
          label: "Non commencé",
          fillColor: "#4E638B",
          strokeColor: "#4E638B",
          pointColor: "#4E638B",
          pointStrokeColor: "#4E638B",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: [15, 5, 20]
        },
        {
          label: "Commencé",
          fillColor: "#D2AC91",
          strokeColor: "#D2AC91",
          pointColor: "#D2AC91",
          pointStrokeColor: "#D2AC91",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: [28, 48, 42]
        },
        {
            label: "Terminé",
            fillColor: "#181C20",
            strokeColor: "#181C20",
            pointColor: "#181C20",
            pointStrokeColor: "#181C20",
            pointHighlightFill: "#fff",
            pointHighlightStroke: "rgba(60,141,188,1)",
            data: [22, 6, 18]
          }
      ]
    };

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
      legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
      //Boolean - whether to make the chart responsive
      responsive: true,
      maintainAspectRatio: true
    };
    barChartOptions.datasetFill = false;
    
    //-------------
    //- BAR CHARTS -
    //-------------
    
    var barChartCanvas = $("#completionChart").get(0).getContext("2d");
    var barChart = new Chart(barChartCanvas);
    barChart.Bar(completionData, barChartOptions);
  });
