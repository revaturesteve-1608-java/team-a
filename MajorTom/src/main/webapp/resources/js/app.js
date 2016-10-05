/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);


app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "landing.html"
	})
	.when("/flight", {
		templateUrl : "flightInfo.html"
	})

}); 
