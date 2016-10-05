/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);


app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "pages/landing.html"
	})
	.when("/flight", {
		templateUrl : "pages/flightInfo.html"
	})
	.otherwise({
		redirectTo : "/"
	})

}); 
