$(document).ready(function () {

	$('#addGoal').click( checkGoals );
	$('#saveGoals').click( saveGoals );
	
	//Build string with id of used action
	$('#form').submit(function() {
		var input = "";
		$('.panel-body .card').each( function() {
			if($(this).children('.box').css('display') != 'none')
				input += $(this).data('id')+"x";
	    });
		$("#inputGoals").val(input);
	});
});

function checkGoals() {

	//Already in the cards
	var array = [];
	$('.panel-body .card').each( function() {
		if($(this).children('.box').css('display') != 'none')
			array.push(parseInt($(this).data('id')));
    });
	
	$('#goalModal input:checkbox').each( function() {
		$(this).prop("checked", false);
		if ($.inArray( parseInt($(this).val()), array ) >= 0) {
			$(this).prop("checked", true);
		}
	});
}

function saveGoals() {
	
	var count = 0;
	var html = "";
	$('#goalModal input:checkbox').each( function() {
		if($(this).prop("checked")) {
			count++;
			
			html += "<div class=\"col-md-3 card\" data-id=\""+$(this).val()+"\">"+
						"<div class=\"box box-warning\">"+
							"<div class=\"box-header with-border\">"+
								"<h3 class=\"box-title\">"+$(this).parent("td").next("td").text()+"</h3>"+
								"<div class=\"box-tools pull-right\">"+
									"<button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\">"+
										"<i class=\"fa fa-times\"></i>"+
									"</button>"+
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>";
		}
	});
	
	if(count == 0) {
		html = "Aucun objectif pour le moment";
	}
	
	$("#panelCards").html(html);
	
	$('#goalModal').modal('hide')
	
}