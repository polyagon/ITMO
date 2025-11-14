function getTableBySession(){
	$.ajax({
		type: 'GET',
		url: 'ControllerServlet',
		data: {'getTable' : 'true'},
		success: function(data) {
			console.log("got from server:");
			console.log(data);
			initSessionTable(data);
		},
		error: function(data) {
			alert(data.statusText + ": " + data.responseText);
		}
	});
}

function sendForm(x, y, r) {
	$.ajax({
		type: 'POST',
		url: 'ControllerServlet',
		data: {
			'x': x,
			'y': y,
			'r': r,
			'offset': new Date().getTimezoneOffset()
		},
		success: function(data) {
			pointsContainer.push([data.x, data.y, data.r, data.hit]);
			addInTable(data);
			redrawGraph();
		},
		error: function(data) {
		    alert(data.statusText + ": " + data.responseText);
			console.log(data)
		}
	});
}

function clean_table() {
	$.ajax({
		type: "DELETE",
		url: "ControllerServlet",
		data: {"clean" : "true"},
		success: function (response) {
			resultsTable.innerHTML = '';
			pointsContainer=[];
			redrawGraph();
		},
		error: function (response) {
			//alert(response.statusText + ": " + response.responseText);
		}
	});
}



function initSessionTable(data){
	if(data === null || data.length === null){
		return;
	}
	data.forEach(point => {
		addInTable(point);
	});
	initialize_table(pointsContainer);
}