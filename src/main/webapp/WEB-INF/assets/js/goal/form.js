$(document).ready(function () {

	$('#addAction').click( addAction );
	
	//Build string with id of used action
	$('#form').submit(function() {
		var input = "";
		$('.panel-body .card').each( function() {
			if($(this).children('.box').css('display') != 'none')
				input += $(this).data('id')+"x";
	    });
		$("#inputActions").val(input);
	});
});

function addAction() {
	alert("Popup actions");
}