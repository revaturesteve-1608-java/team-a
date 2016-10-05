/**
 * 
 */
var app = angular.module("airline", ["ngRoute"]);

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
	$routeProvider
	.when("/", {
		templateUrl : "pages/landing.html"
	})
	.when("/flight", {
		templateUrl : "pages/flightInfo.html"
	})
	.otherwise({
		redirectTo : "/"
	})

}); 
