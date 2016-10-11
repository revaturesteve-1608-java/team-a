
var infoApp = angular.module("airline");

infoApp.controller("infoController", function($scope, $rootScope, dataService) {
	$scope.infoVisible = false;
	
	// This event is triggered when a seat is clicked
    $rootScope.$on('seatClick', function(event, data) {
        console.log("Hello from info controller" + JSON.stringify(data));
        $scope.infoVisible = true;
        $scope.infoContents = JSON.stringify(data);
    })
});