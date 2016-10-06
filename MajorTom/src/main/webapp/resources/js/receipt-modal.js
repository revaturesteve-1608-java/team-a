angular.module("airline")
.controller("receiptController",function($scope,$rootScope,dataService){
	$scope.loginVisible=true;
	$scope.loadingTicket={ticketId:"Loading...",firstName:"",lastName:""};
	$scope.selectTicket($scope.loadingTicket);
	$scope.loadingFlight={flightId:"No flight selected."};
	$scope.selectFlight($scope.loadingFlight);
	$scope.loadingUser={username:"Loading...",firstName:"",lastName:"",authenticated:false};
	$scope.errorUser={username:"Not Found",firstName:"",lastName:"",authenticated:false};
	$scope.setCurrentUser(null);
	$scope.saveTicketId=function(){
		$scope.selectTicket($scope.loadingTicket);
		$scope.selectFlight($scope.loadingFlight);
		var ticketidbox=document.getElementById("TicketIDBox");
		var ticketid=ticketidbox.value;
		dataService.findTicket(+ticketid,function(response){
			response.data.authenticated=true;
			$scope.selectTicket(response.data);
		});
		dataService.findFlightByTicket(+ticketid,function(response){
			$scope.selectFlight(response.data);
		});
		$scope.loginVisible=false;
	};
	$scope.employeeLogin=function(){
		$scope.setCurrentUser($scope.loadingUser);
		var username=document.getElementById("EmployeeUsernameBox").value;
		var password=document.getElementById("EmployeePasswordBox").value;
		dataService.authenticate(username, password,
			function(response){
				$scope.setCurrentUser(response.data);
			}, function(response) {
				$scope.setCurrentUser($scope.errorUser);
			}
		);
		$scope.loginVisible=false;
	};
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='loginVisible=!loginVisible'>{{loginVisible?'Cancel':'Login'}}</a>"
	};
});