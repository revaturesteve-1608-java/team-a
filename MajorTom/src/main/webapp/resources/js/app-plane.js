/**
 * 
 */
var app = angular.module("airline");

app.controller("planeController", function(planeDataService) {
	var me = this;
	
	this.getMessages = function() {
		
		dataService.get(function(response) {
			console.log(response.data);
			me.messages = response.data;
		});
	};

	this.pilot = {
		name: "Major Tom"
	};
	this.copilot = {
		name: "Major Todd"
	};
	
	this.selectionDisplay = "No seat selected";
	
	var me = this;
	var flightId = 1402;
	planeDataService.getFormattedSeats(flightId, function(response){
		me.firstclass = response.data.first;
		me.buisclass = response.data.buisness;
		me.econclass = response.data.economy;
	});
	
	this.selectSeat = function(seat){
		console.log(seat.toSource());
		this.selectionDisplay = "Selected seat: " + seat.seatId;
	};
	
//	this.firstclass = [[{
//		name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"
//	}]];
//	
//	this.buisclass = [[{
//		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
//	}]];
//
//	this.econclass = [[{
//		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
//		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
//	}]];

});


app.service("planeDataService", function($http){
	this.getFormattedSeats = function(flightId, callback) {
		$http.get("rest/getFormattedSeats/"+flightId, flightId).then(callback);
	}
});

window.onload = windowResize();

window.onresize = function(event) {
	windowResize();
};

function windowResize() {
	var content = $(".plane");
	var height = $(window).height();
	var width = $(window).width();
	var scale;
	scale = Math.min(width / 1920, height / 971);
	content.css({
		transform : "scale(" + scale + ")" 
	});
}

