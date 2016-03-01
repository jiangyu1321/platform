var app = angular.module('myApp',[]);
app.controller('ctrl.hello',function($scope){
	$scope.firstName = "Hello";
	$scope.lastName = "World";
});