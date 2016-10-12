/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);

app.controller('mainCtrl', function($scope, $rootScope, dataService){
	this.recieptIsLogin = false;
	
	$scope.selectedTicket = null;
	$scope.selectedFlight = null;
	$scope.currentUser = null;
	$scope.selectTicket = function(ticket) {
		$scope.selectedTicket=ticket;
	};
	$scope.selectFlight = function(flight) {
		$scope.selectedFlight=flight;
	};
	$scope.setCurrentUser = function(user) {
		$scope.currentUser = user;
	};
	$scope.isAdmin = function() {
		if($rootScope.authenticated){return false;}
		return !!$rootScope.authenticated;
	};
	$scope.testAdminStatus = function() { /* REMOVE THIS METHOD WHEN DEBUGGING IS FINISHED. */
		$scope.admintest=$scope.isAdmin();
	};
	$scope.findFlight = function(flightId) {
		$scope.flightInfo = "Loading...";
		console.log('About To Get '+flightId);
		console.log(flightId);
		dataService.findFlight(flightId, function(response){$scope.flightInfo = response.data.flightId;});
	};
	$scope.findTicketBySeat = function(seatId) {
		$scope.ticketInfo = "Loading...";
		console.log('Getting ticket, using seat id: ' + seatId);
		dataService.findTicketBySeat(seatId, function(response){$scope.ticketInfo = JSON.stringify(response);});
	};
	$scope.findSeatByFlight = function(flightId) {
		$scope.seatInfo = "Loading...";
		console.log('Getting seat, using flight id: ' + flightId);
		dataService.findSeatsByFlight(flightId, function(response){$scope.seatInfo = JSON.stringify(response);});
	};
	$rootScope.$on('seatClick', function(event, data) {
		$scope.selectedSeat=data;
	});
	$scope.setSeat = function(ticketId, seatId) {
		$scope.newSeatInfo = "Loading...";
		console.log('Getting seat, using: ' + ticketId + " " + seatId);
		dataService.setSeat(ticketId, seatId, function(response){$scope.newSeatInfo = JSON.stringify(response);});
	};
	$scope.reassignSeat = function(ticketId, seatId) {
		$scope.newSeatInfo2 = "Loading...";
		console.log('Getting seat, using: ticket-' + ticketId + " seat-" + seatId);
		dataService.reassignSeat(ticketId, seatId, function(response){$scope.newSeatInfo2 =  "Seat #"+JSON.stringify(seatId)+" has been reassigned to ticket #"+JSON.stringify(response.data.ticketId);});
	};
	$scope.findFlightByTicket = function(ticketId) {
		$scope.flightByTicket = "Loading...";
		console.log('Getting flight, using: ' + ticketId);
		dataService.findFlightByTicket(ticketId, function(response){$scope.flightByTicket = JSON.stringify(response);});
	};
	
	this.viewResize = function() {
		var content = $(".plane");
		var height = $(window).height();
		var width = $(window).width();
		var scale;
		scale = Math.min(width / 1920, height / 971);
		content.css({
			transform : "scale(" + scale + ")" 
		});
	}
	var me = this;
	window.onresize = function(event) {
		me.viewResize();
	};
	
	/* MUST BE IN app.js TO ACCESS ROUTE CHANGE EVENT PROPERLY
	 * A bit of a hack to get the view to resize automatically on page load.
	 * After the view is received from the server, it waits a short time for it to change
	 * then resizes the view. it repeats at scaling intervals to account for slow hardware
	 */
	$rootScope.$on("$routeChangeSuccess", function(event) {
		setTimeout(function(){
			me.viewResize();
		}, 5);
		setTimeout(function(){
			me.viewResize();
		}, 20);
		setTimeout(function(){
			me.viewResize();
		}, 100);
		setTimeout(function(){
			me.viewResize();
		}, 500);
		setTimeout(function(){
			me.viewResize();
		}, 2500);
	});
});
	
app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "pages/b737-800-plane.html"
	});
	
	$routeProvider.when("/flight", {
		templateUrl : "pages/flightInfo.html"
	});
});

app.service('dataService', function($http, $rootScope){
	this.findFlight = function(flightId, callback) {
		$http.get('rest/findFlight/'+flightId, flightId).then(callback);
	}
	this.findFlightByTicket = function(ticketId, callback) {
		$http.get('rest/findFlightByTicket/'+ticketId,ticketId).then(callback);
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
	this.authenticate = function(username, password, callback, failure) {
		var data = JSON.stringify({"username": username, "password": password});
		$http.post('rest/authenticate', data).then(callback, failure);
	}
	this.setSeat = function(ticketId, seatId, callback, failure) {
		// Set the seat for the ticket
		var data = JSON.stringify({"ticketId": ticketId, "seatId": seatId});
		$http.post('rest/setSeat', data).then(callback, failure);
	}
	this.reassignSeat = function(ticketId, seatId, callback, failure) {
		// Reassign the seat for the ticket
		console.log("Reassigning, not setting");
		var data = JSON.stringify({"ticketId": ticketId, "seatId": seatId, "loginToken": $rootScope.loginToken});
		$http.post('rest/reassignSeat/', data).then(callback, failure);
	}
});
