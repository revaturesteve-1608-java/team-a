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
				response.data.authenticated=true;
				$scope.setCurrentUser(response.data);
			}, function(response) {
				$scope.setCurrentUser($scope.errorUser);
			}
		);
		$scope.loginVisible=false;
	};
	$scope.receiptAnimTimeout=null;
	$scope.resetReceiptAnim=function(){
		var receipt=document.getElementById("ReceiptModal");
		receipt.classname="";
		if(receiptAnimTimeout!=null){
			window.clearTimeout($scope.receiptAnimTimeout);
		}
		$scope.receiptAnimTimeout=setTimeout(function(){
			$scope.receiptAnimTimeout=null;
			receipt.classname="ReceiptAnim";
		},10);
	};
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='loginVisible=!loginVisible'>{{loginVisible?'Cancel':'Login'}}</a>"
	};
});