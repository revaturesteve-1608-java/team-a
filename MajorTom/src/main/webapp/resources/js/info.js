
var infoApp = angular.module("airline");

infoApp.controller("infoController", function($scope, $rootScope, dataService) {
	$scope.infoVisible = false;
    $scope.$on('seatClick', function(event, data) {
        console.log("hello from info controller" + data);
    })
});