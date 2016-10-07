/**
 * 
 */
var app = angular.module("airline");

app.controller("planeController", function() {
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
	
	this.firstclass = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];
	
	this.buisclass = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];

	this.econclass = [[{
		name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"}],
		[{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"},{name: "none"
	}]];

});

app.service('planeDataService', function($http){
	this.findFlight = function(flightId, callback) {
		$http.get('rest/findFlight/'+flightId, flightId).then(callback);
	}
});

