/*
 * For the speech bubble that appears when you click on a seat
 */

var infoApp = angular.module("airline");

infoApp.controller("infoController", function($scope, $rootScope, infoService) {
	$scope.infoVisible = false;
	
	// This event is triggered when a seat is clicked
    $rootScope.$on('seatClick', function(event, data) {
//        var str = data.seatType.seatTypeName + " (Seat #" + data.seatId + ")\r\n\r\nFlight " + data.flight.flightId + "\r\nTo " + data.flight.destination.destinationName + " (" + data.flight.destination.destinationCode + 
//        	")\r\n\r\n" + data.flight.airline.name + "\r\n" + data.flight.airplane.airplaneName;
        var str = data.seatType.seatTypeName + " (Seat #" + data.seatId + ")";
        
        var isAdminCheck = infoService.isAdmin();
        console.log("response from isadmin:" + JSON.stringify(isAdminCheck));
        // the code works but what it's returning is weird
        // if invalid token it returns the same result as if it is a valid token
        // although the cntrler is proper
        // null tokens work
        $scope.infoVisible = true;
        $scope.infoContents = str;
    })
});

infoApp.service('infoService', function($http, $rootScope){
	this.isAdmin = function() {
		if ($rootScope.loginToken == null) {
			return false;
		} else {
			return $http.get('rest/isAdmin/'+$rootScope.loginToken, $rootScope.loginToken);
		}
	}
	
});