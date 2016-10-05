/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);


app.controller('mainCtrl', function($scope, dataService){
		$scope.findFlight = function(flightId){
			console.log('About To Get '+flightId);
			console.log(flightId);
			dataService.findFlight(flightId);
		}
	})
	.config(function($routeProvider) {
		$routeProvider.when("/", {
			templateUrl : "pages/landing.html"
		})
		.when("/flight", {
			templateUrl : "pages/flightInfo.html"
		})
		.otherwise({
			redirectTo : "/"
		})
	})
	.service('dataService', function($http){
		this.findFlight = function(flightId){
			$http.get('rest/findFlight/'+flightId, flightId).then(
				function(response){
					console.log(response.data.flightId)
				}
			)
		}
		this.findTicket = function(flightId){
			$http.get('rest/findTicket/'+flightId, flightId).then(
				function(response){
					console.log(response.data.flightId)
				}
			)
		}
	}); 
