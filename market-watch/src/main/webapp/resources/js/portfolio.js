/**
 * 
 */

function removePortfolioItem() {
	alert("remove");
	var $portfolioTable = $('#portfolioTable');
	var ids = $.map($portfolioTable.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
	$portfolioTable.bootstrapTable('remove', {field: 'id', values: ids});
}
