/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);

app.controller('mainCtrl', function($scope, $rootScope, $location, dataService){
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
		if($rootScope.authenticated){
			return false
		;}
		return !!$rootScope.authenticated;
	};

	// Asks the data service to find flight by flight id
	$scope.findFlight = function(flightId) {
		$scope.flightInfo = "Loading...";
		dataService.findFlight(flightId, function(response){$scope.flightInfo = response.data.flightId;});
	};
	// Asks the data service to find ticket by seat id
	$scope.findTicketBySeat = function(seatId) {
		$scope.ticketInfo = "Loading...";
		dataService.findTicketBySeat(seatId, function(response){$scope.ticketInfo = JSON.stringify(response);});
	};
	// Asks the data service to find seat by flight id
	$scope.findSeatByFlight = function(flightId) {
		$scope.seatInfo = "Loading...";
		dataService.findSeatsByFlight(flightId, function(response){$scope.seatInfo = JSON.stringify(response);});
	};
	// Event that is triggered when a seat is clicked.  Refers to info.js.
	$rootScope.$on('seatClick', function(event, data) {
		$scope.selectedSeat=data;
	});
	// Asks the data service to set a ticket into a seat
	$scope.setSeat = function(ticketId, seatId, seatInfo) {
		$scope.newSeatInfo = "Loading...";
		if (seatInfo.ticket==null){
			dataService.setSeat(ticketId, seatId, function(response){
				$scope.newSeatInfo = JSON.stringify(response); 
				$rootScope.$emit('changeFlight', $scope.selectedTicket.flight.flightId);
			});
		}
	};
	// Asks the data service to swap 2 seats
	$scope.reassignSeat = function(ticketId, seatId, seat2Id) {
		$scope.newSeatInfo2 = "Loading...";
		dataService.reassignSeat(ticketId, seatId.seatId, seat2Id.seatId, function(response){$scope.newSeatInfo2 =  "Seat #"+JSON.stringify(seatId.seatId)+" has been reassigned to ticket #"+JSON.stringify(response.data.ticketId);});
		var tempTicket = seatId.ticket;
		seatId.ticket = seat2Id.ticket;
		seat2Id.ticket = tempTicket;
		setTimeout($('#seat'+seat2Id.seatId).addClass('seat-taken'), 2500);
		setTimeout($('#seat'+seatId.seatId).removeClass('seat-taken'), 2500);
		$scope.$root.firstSelect = null;
		$scope.$root.secondSelect = null;
		$rootScope.$emit('hideInfo');
	};
	// Asks the data service to find a flight by ticket id
	$scope.findFlightByTicket = function(ticketId) {
		$scope.flightByTicket = "Loading...";
		dataService.findFlightByTicket(ticketId, function(response){$scope.flightByTicket = JSON.stringify(response);});
	};
	
	dataService.findAllFlights(function(response) {
		// Only do it for the first item (that's where the flights are)
		// To get the first item, just use a for-each and take the first item
		$scope.flightList = response.data;
	})
	
	$scope.changeFlight = function(id) {
		$location.path("b737");
		// Emit an event to app-plane.js to update the airplane
		$rootScope.$emit('changeFlight', id);
	}
	
	// Resize on window resize
	this.viewResize = function() {
		var content = $(".rout-container");
		var height = $(window).height();
		var width = $(window).width();
		var scale;
		scale = Math.min(width / 1920, height / 971);
		content.css({
			transform : "scale(" + scale + ")" 
		});
	}
	var me = this;
	window.onresize = function() {
		me.viewResize();
	};
	
	/* MUST BE IN app.js TO ACCESS ROUTE CHANGE EVENT PROPERLY
	 * A bit of a hack to get the view to resize automatically on page load.
	 * After the view is received from the server, it waits a short time for it to change
	 * then resizes the view. it repeats at scaling intervals to account for slow hardware
	 */
	$rootScope.$on("$routeChangeSuccess", function() {
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

// Routing
app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "pages/home.html"
	});
	
	$routeProvider.when("/b737", {
		templateUrl : "pages/Boeing_737.html"
	});
	
	$routeProvider.when("/flight", {
		templateUrl : "pages/flightInfo.html"
	});
});

// Data service, which calls methods on the server-sided REST controller
app.service('dataService', function($http, $rootScope){
	this.findFlight = function(flightId, callback) {
		// Finds a flight by id
		$http.get('rest/findFlight/'+flightId, flightId).then(callback);
	}
	this.findTicket = function(ticketId, callback) {
		// Finds a ticket by id
		$http.get('rest/findTicket/'+ticketId, ticketId).then(callback);
	}
	this.findTicketBySeat = function(seatId, callback) {
		// Finds a ticket by seat id
		$http.get('rest/findTicketBySeat/'+seatId, seatId).then(callback);
	}
	this.findSeatsByFlight = function(flightId, callback) {
		// Finds seats by flight id
		$http.get('rest/findSeatsByFlight/'+flightId, flightId).then(callback);
	}
	this.findAllFlights = function(callback) {
		// Finds all flights
		$http.get('rest/findAllFlights').then(callback);
	}
	this.authenticate = function(username, password, callback, failure) {
		// Checks to see if the username/password is valid
		var data = JSON.stringify({"username": username, "password": password});
		$http.post('rest/authenticate', data).then(callback, failure);
	}
	this.setSeat = function(ticketId, seatId, callback, failure) {
		// Set the seat for the ticket
		var data = JSON.stringify({"ticketId": ticketId, "seatId": seatId});
		$http.post('rest/setSeat', data).then(callback, failure);
	}
	this.reassignSeat = function(ticketId, seatId, seat2Id, callback, failure) {
		// Reassign the seat for the ticket
		var data = JSON.stringify({"ticketId": ticketId, "seatId": seatId, "seat2Id": seat2Id, "loginToken": $rootScope.loginToken});
		$http.post('rest/reassignSeat/', data).then(callback, failure);
	}
	
});
