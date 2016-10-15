/*
 * For the speech bubble that appears when you click on a seat
 */

var infoApp = angular.module("airline");

infoApp.controller("infoController", function($scope, $rootScope) {
	$scope.infoVisible = false;
	
	// This event is triggered when a seat is clicked
    $rootScope.$on('seatClick', function(event, data) {
        var str = data.seatType.seatTypeName + " (Seat #" + data.seatId + ")";
        $scope.infoVisible = true;
        $scope.infoContents = str;
    })
    $scope.setFirstSelection = function(seat){
    	$rootScope.firstSelect = seat;
    }
    $scope.setSecondSelection = function(seat){
    	$rootScope.secondSelect = seat;
    }
});