/**
 * 
 */

function removePortfolioItem() {
	var $portfolioTable = $('#portfolioTable');
	var ids = $.map($portfolioTable.bootstrapTable('getSelections'), function(
			row) {
		return row.id;
	});
	$portfolioTable.bootstrapTable('remove', {
		field : 'id',
		values : ids
	});
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/market-watch/portfolio/delete",
		data : {
			'ids' : '{' + ids + '}',
			'_csrf.parameterName' : _csrf.token
		},
		success : refresh()
	});
}

function refresh() {
	alert('refresh');
}
