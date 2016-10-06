angular.module("airline")
.controller("receiptController",function($scope,dataService){
	$scope.loginVisible=false;
	$scope.loadingTicket={ticketId:"Enter ticket ID.",email:"",firstName:"",lastName:"",phone:"",seat:{flight:{flightId:"None"}}};
	$scope.ticket=$scope.loadingTicket;
	$scope.saveTicketId=function(){
		$scope.ticket=$scope.loadingTicket;
		var ticketidbox=document.getElementById("ticketidbox");
		var ticketid=ticketidbox.value;
		$scope.ticket=$scope.loadingTicket;
		dataService.findTicket(+ticketid,function(response){
			$scope.ticket=response.data;
			document.getElementById("FlightNumberView").innerHTML=ticket.seat.flight.flightId;
		});
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
	}
});