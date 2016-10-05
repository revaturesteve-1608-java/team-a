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
	this.findFlight = function(flightId, callback){
		$http.get('rest/findFlight/'+flightId, flightId).then(callback)
			
	}
}); 
