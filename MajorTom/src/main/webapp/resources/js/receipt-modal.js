angular.module("airline")
.controller("receiptController",function($scope,$rootScope,dataService){
	$scope.loginVisible=true;
	$scope.loadingTicket={ticketId:"Loading...",firstName:"",lastName:""};
	$scope.selectTicket($scope.loadingTicket);
	$scope.loadingFlight={flightId:"No flight selected."};
	$scope.selectFlight($scope.loadingFlight);
	$scope.saveTicketId=function(){
		$scope.selectTicket($scope.loadingTicket);
		$scope.selectFlight($scope.loadingFlight);
		var ticketidbox=document.getElementById("ticketidbox");
		var ticketid=ticketidbox.value;
		dataService.findTicket(+ticketid,function(response){
			$scope.selectTicket(response.data);
		});
		dataService.findFlightByTicket(+ticketid,function(response){
			$scope.selectFlight(response.data);
		});
		$scope.loginVisible=false;
	}
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='loginVisible=!loginVisible'>Login</a>"
	};
})
.directive("enterTicketInfo",function(){
	return {
		template:
			"<label>TicketID:</label>\
			<input type='text' id='ticketidbox'/>\
			<input type='submit' value='Save' data-ng-click='saveTicketId()'/>"
	};
});