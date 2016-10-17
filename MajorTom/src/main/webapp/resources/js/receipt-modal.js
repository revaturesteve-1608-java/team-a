angular.module("airline")
.controller("receiptController",function($scope,$rootScope,$location,dataService,$timeout){
	$scope.loginVisible = true;
	$scope.loadingTicket = {
		ticketId:"Loading...",
		flight:null
	};
	$scope.errorTicket = {
		ticketId:"Ticket Not Found.",
		flight:null
	};
	$scope.selectTicket($scope.loadingTicket);
	$scope.loadingUser = {
		username:"Loading...",
		firstName:"",
		lastName:"",
		authenticated:false
	};
	$scope.errorUser = {
		username:"Not Found",
		firstName:"",
		lastName:"",
		authenticated:false
	};
	$scope.setCurrentUser(null);
	$scope.saveTicketId=function(){
		if($scope.currentUse!=null){
			$scope.employeeLogout();
		}
		$scope.selectTicket($scope.loadingTicket);
		var ticketidbox=document.getElementById("TicketIDBox");
		var ticketid=ticketidbox.value;
		dataService.findTicket(+ticketid,function(response){
			$scope.selectTicket(response.data);
			$location.path("b737");
		});
		$scope.loginVisible=false;
		if($scope.ticketTimeoutID){
			$timeout.cancel($scope.ticketTimeoutID);
		}
		$scope.ticketTimeoutID=$timeout(function(){
			$scope.timeoutTicket(ticketid);
		},60000);
	};
	$scope.timeoutTicket=function(ticketid){
		if(ticketid === undefined || $scope.selectedTicket.ticketId === ticketid)
		{
			$scope.selectTicket($scope.loadingTicket);
			$scope.loginVisible=true;
		}
	};
	$scope.employeeLogin=function(){
		$scope.setCurrentUser($scope.loadingUser);
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		dataService.authenticate(username, password,
			function(response){
				$scope.setCurrentUser(response.data);
				$rootScope.loginToken = response.data.token;
			}, function() {
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
		$scope.setCurrentUser(null)
		$rootScope.$emit("hideInfo");
	};
	$scope.slideReceipt=function(In)
	{
		$scope.receiptOpen=In;
		$("#ReceiptModal").animate({top:(In?"0":"-32vw")});
		$(".receipt-arrow").toggleClass("receipt-arrow-up");
		$(".receipt-arrow").toggleClass("receipt-arrow-down");
	};
	$scope.toggleReceipt=function()
	{
		$scope.slideReceipt(!$scope.receiptOpen);
	};
	$scope.slideReceipt(true);
	$(".receipt-arrow").removeClass("receipt-arrow-down");
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='employeeLogout()'>{{loginVisible?'Login':'Logout'}}</a>"
	};
});