window.name = "platform";

var app = angular.module('myApp', [
	// 官方模块
	'ngRoute',
	// 自定义
	'base.route',
	'auth'
]);

app.run(['$rootScope', function($rootScope) {
	$rootScope.ready = false;

}]);

var basePath = {
	ctrl: "assets/javascripts/ctrl/",
	view: "assets/view/",
	css: "assets/stylesheets/",
	test: "assets/test/"
};