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
		this.findFlight = function(flightId, callback){
			$http.get('rest/findFlight/'+flightId, flightId).then(callback)
				
		}
	}); 
