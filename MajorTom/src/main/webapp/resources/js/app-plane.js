/**
 * 
 */
var app = angular.module("airline");

app.controller("planeController", function() {
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