/**
 * 
 */
var timerUpdate, timerGet;

function updateSymbols(symbolName, ask, bid) {
	$.ajax({ type: "GET",
		url: "http://localhost:8080/market-watch/symbol/update?name=" + symbolName + "&ask=" + ask + "&bid=" + bid,
		async: false,
        success : function(text)
        {
            alert(text);
        }
	});
}

function startstop() {
	var button = document.getElementById("startstop");
	
	if (button.value == "Stop") {
		clearInterval(timerUpdate);
		clearInterval(timerGet);
		button.value="Start";
	}
	else {
		button.value="Stop";
		timerUpdate = setInterval(function(){updateSymbols('GOLD', 1104.2, 1103.9);}, 1000);
		timerGet = setInterval(showRates, 1000);
	}
}

function showRates() {
	var response = '';
	$.ajax({ type: "GET",   
	         url: "http://localhost:8080/market-watch/symbol/get?name=GOLD",   
	         async: false,
	         success : function(text)
	         {
	             response = text;
	         }
	});
	
	var result = document.getElementById("result");
	result.innerHTML = JSON.stringify(response, null, 2);
}
