angular.module("airline")
.controller("receiptController",function($scope,$rootScope,$location,dataService){
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
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		dataService.authenticate(username, password,
			function(response){
				$scope.setCurrentUser(response.data);
				$rootScope.loginToken = response.data.token;
			}, function(response) {
				$rootScope.authenticated=false;
				$scope.setCurrentUser($scope.errorUser);
			}
		);
		$scope.loginVisible=false;
	};
	$scope.employeeLogout=function(){
		document.getElementById("username").value = "";
		document.getElementById("password").value = "";
		$rootScope.loginToken = undefined;
		$scope.loginVisible=true;
	};
	$scope.slideReceipt=function(In)
	{
		$("#ReceiptModal").animate({top:(In?"0":"-320px")});
	};
	$scope.slideReceipt(false);
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='employeeLogout()'>{{loginVisible?'Login':'Logout'}}</a>"
	};
});