$(document).ready(function () {

	$('#addUser').click( checkUsers );
	$('#saveUsers').click( saveUsers );
	
	$('#addMission').click( checkMissions );
	$('#saveMissions').click( saveMissions );
	
	//Build string with id of used action
	$('#form').submit(function() {
		var inputMission = "";
		$('#panelCardsMissions .card').each( function() {
			if($(this).children('.box').css('display') != 'none')
				inputMission += $(this).data('id')+"x";
	    });
		$("#inputMissions").val(inputMission);
		
		var inputUser = "";
		$('#panelCardsUsers .card').each( function() {
			if($(this).children('.box').css('display') != 'none')
				inputUser += $(this).data('id')+"x";
	    });
		$("#inputUsers").val(inputUser);
	});
});

function checkMissions() {

	//Already in the cards
	var array = [];
	$('#panelCardsMissions .card').each( function() {
		if($(this).children('.box').css('display') != 'none')
			array.push(parseInt($(this).data('id')));
    });
	
	$('#missionModal input:checkbox').each( function() {
		$(this).prop("checked", false);
		if ($.inArray( parseInt($(this).val()), array ) >= 0) {
			$(this).prop("checked", true);
		}
	});
}

function checkUsers() {

	//Already in the cards
	var array = [];
	$('#panelCardsUsers .card').each( function() {
		if($(this).children('.box').css('display') != 'none')
			array.push(parseInt($(this).data('id')));
    });
	
	$('#userModal input:checkbox').each( function() {
		$(this).prop("checked", false);
		if ($.inArray( parseInt($(this).val()), array ) >= 0) {
			$(this).prop("checked", true);
		}
	});
}

function saveMissions() {
	
	var count = 0;
	var html = "";
	$('#missionModal input:checkbox').each( function() {
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
		html = "Aucune mission pour le moment";
	}
	
	$("#panelCardsMissions").html(html);
	
	$('#missionModal').modal('hide')
}

function saveUsers() {
	
	var count = 0;
	var html = "";
	$('#userModal input:checkbox').each( function() {
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
		html = "Aucun apprenant pour le moment";
	}
	
	$("#panelCardsUsers").html(html);
	
	$('#userModal').modal('hide')
	
}