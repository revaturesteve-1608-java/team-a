/**
 * 
 */
var app = angular.module("airline");

app.controller("planeController", function($scope, $rootScope, planeDataService) {
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
	this.selectedSeat;
	
	var me = this;
	var flightId = 1402;
	planeDataService.getFormattedSeats(flightId, function(response){
		me.firstclass = response.data.first;
		me.buisclass = response.data.buisness;
		me.econclass = response.data.economy;
	});
	
	this.selectSeat = function(seat){
		this.selectionDisplay = "Selected seat: " + seat.seatId;
		this.selectedSeat = seat;
		// Trigger an event in the info controller (info.js)
        $rootScope.$emit('seatClick', this.selectedSeat);
        console.log($("seat" + index).css("box-shadow"));
        console.log($("seat" + index).css("left"));
	};
});


app.service("planeDataService", function($http){
	this.getFormattedSeats = function(flightId, callback) {
		$http.get("rest/getFormattedSeats/"+flightId, flightId).then(callback);
	}
});



