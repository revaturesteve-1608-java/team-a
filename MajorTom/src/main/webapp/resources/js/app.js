/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);

app.controller('mainCtrl', function($scope, dataService){
	$scope.findFlight = function(flightId){
		$scope.flightInfo = "Loading..."
		console.log('About To Get '+flightId);
		console.log(flightId);
		dataService.findFlight(flightId, function(response){$scope.flightInfo = response.data.flightId});
	}
	$scope.findTicketBySeat = function(seatId) {
		$scope.ticketInfo = "Loading..."
		console.log('Getting ticket, using seat id: ' + seatId);
		dataService.findTicketBySeat(seatId, function(response){$scope.ticketInfo = JSON.stringify(response)});
	}
	$scope.findSeatByFlight = function(flightId) {
		$scope.seatInfo = "Loading..."
		console.log('Getting seat, using flight id: ' + flightId);
		dataService.findSeatsByFlight(flightId, function(response){$scope.seatInfo = JSON.stringify(response)});
	}
});

app.controller("planeController", function() {
	this.pilot = {
		name: "Major Tom"
	};
	this.copilot = {
		name: "Major Todd"
	};
	
	
	this.firstclassleft = [
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}]
	];
	this.firstclassright = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];
	
	
	this.buisclassleft = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];
	this.buisclassright = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];

	
	this.econclassleft = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];
	this.econclassright = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];
	
});

	
app.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "pages/landing.html"
		});
		
		$routeProvider.when("/flight", {
			templateUrl : "pages/flightInfo.html"
		})
});

app.service('dataService', function($http){
	this.findFlight = function(flightId, callback) {
		$http.get('rest/findFlight/'+flightId, flightId).then(callback);
	}
	this.findTicket = function(ticketId, callback){
		$http.get('rest/findTicket/'+ticketId, ticketId).then(callback);
	}
	this.findTicketBySeat = function(seatId, callback) {
		$http.get('rest/findTicketBySeat/'+seatId, seatId).then(callback);
	}
	this.findSeatsByFlight = function(flightId, callback) {
		$http.get('rest/findSeatsByFlight/'+flightId, flightId).then(callback);
	}
});