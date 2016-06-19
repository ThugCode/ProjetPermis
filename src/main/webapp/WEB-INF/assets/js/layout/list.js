$(function () {
	
	if (typeof orderDefault == 'undefined') {
		orderDefault = 0;
	}
	
	if (typeof orderDirectionDefault == 'undefined') {
		orderDirectionDefault = "asc";
	}

	var table = $("#tableList").DataTable({
		"paging": true,
		"lengthChange": true,
		"searching": true,
		"ordering": true,
		"info": true,
		"autoWidth": true,
		"bSort": true,
		"order": [[ orderDefault, orderDirectionDefault ]],
		"oLanguage": {
			"sProcessing":     "Traitement en cours...",
		    "sSearch":         "Rechercher&nbsp;:",
		    "sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
		    "sInfo":           "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
		    "sInfoEmpty":      "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
		    "sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
		    "sInfoPostFix":    "",
		    "sLoadingRecords": "Chargement en cours...",
		    "sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
		    "sEmptyTable":     "Aucune donn&eacute;e disponible dans le tableau",
		    "oPaginate": {
		        "sFirst":      "Premier",
		        "sPrevious":   "Pr&eacute;c&eacute;dent",
		        "sNext":       "Suivant",
		        "sLast":       "Dernier"
		    }
		}
	});
});