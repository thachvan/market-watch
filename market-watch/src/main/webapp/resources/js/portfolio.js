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
		type : "GET",
		url : "http://localhost:8080/market-watch/portfolio/delete?ids=" + ids,
		async: false,
		success : refresh()
	});
}

function refresh() {
}
