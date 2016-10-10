angular.module("airline")
.controller("receiptController",function($scope,$rootScope,dataService){
	$scope.loginVisible=true;
	$scope.loadingTicket={ticketId:"Loading...",firstName:"",lastName:""};
	$scope.selectTicket($scope.loadingTicket);
	$scope.selectFlight(null);
	$scope.loadingUser={username:"Loading...",firstName:"",lastName:"",authenticated:false};
	$scope.errorUser={username:"Not Found",firstName:"",lastName:"",authenticated:false};
	$scope.setCurrentUser(null);
	$scope.saveTicketId=function(){
		$scope.selectTicket($scope.loadingTicket);
		$scope.selectFlight($scope.loadingFlight);
		var ticketidbox=document.getElementById("TicketIDBox");
		var ticketid=ticketidbox.value;
		dataService.findTicket(+ticketid,function(response){
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
				$rootScope.authenticated=true;
				$scope.setCurrentUser(response.data);
			}, function(response) {
				$rootScope.authenticated=false;
				$scope.setCurrentUser($scope.errorUser);
			}
		);
		$scope.loginVisible=false;
	};
	$scope.employeeLogout=function(){
		$scope.setCurrentUser($scope.loadingUser);
		document.getElementById("EmployeeUsernameBox").value = "";
		document.getElementById("EmployeePasswordBox").value = "";
		$rootScope.authenticated=false;
		$scope.loginVisible=true;
	};
	$scope.slideReceipt=function(In)
	{
		$("#ReceiptModal").animate({top:(In?"0":"-360px")});
	};
	$scope.slideReceipt(false);
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='loginVisible=!loginVisible'>{{loginVisible?'Cancel':'Login'}}</a>"
	};
});