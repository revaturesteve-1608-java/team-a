angular.module("airline")
.controller("receiptController",function($scope){
	$scope.loginVisible=false;
	$scope.saveTicketId=function(){
		
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
			<input type='submit' value='Save' data-ng-click='saveTicketId()'/>\
			"
	}
});