angular.module("airline")
.controller("receiptController",function($scope){
	$scope.loginVisible=false;
})
.directive("airlineLoginBtn",function(){
	return {
		template:
			"<a href='' class='farbutton' data-ng-click='loginVisible=!loginVisible'>Login</a>"
	};
});