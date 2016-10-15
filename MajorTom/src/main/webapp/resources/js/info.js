/*
 * For the speech bubble that appears when you click on a seat
 */

var infoApp = angular.module("airline");


infoApp.controller("infoController", function($scope, $rootScope, infoService) {
	$scope.infoVisible = false;
	
	// This event is triggered when a seat is clicked
    $rootScope.$on('seatClick', function(event, data) {
        var str = data.seatType.seatTypeName + " (Seat #" + data.seatId + ")";
        
        infoService.fillInfo(str, data, $scope);
    })
    $scope.setFirstSelection = function(seat){
    	$rootScope.firstSelect = seat;
    }
    $scope.setSecondSelection = function(seat){
    	$rootScope.secondSelect = seat;
    }
});

infoApp.service('infoService', function($http, $rootScope){
	this.fillInfo = function(str, data, $scope) {
		if ($rootScope.loginToken == null) {
			// No token
	        $scope.infoVisible = true;
	        $scope.infoContents = str;
		} else {
			// Async call and callback to check for admin
			$http.get('rest/isAdmin/'+$rootScope.loginToken, $rootScope.loginToken).then(function(response) {
				// Check HTTP status to get the result of the function
				var status = response.status;
				console.log(status);
				
		        $scope.infoVisible = true;
		        if (status >= 400) {
		        	// Wrong token
		        	$scope.infoContents = str;
		        } else {
		        	// Correct token, show ticket info too
		        	if (data.ticket != null) {
		        		$scope.infoContents = str + "\r\n" + data.ticket.firstName + " " + data.ticket.lastName + "\r\n" + data.ticket.email + "\r\n" + data.ticket.phone;
		        	} else {
		        		$scope.infoContents = str;
		        	}
		        }
			});
		}
	}
});