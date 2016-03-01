(function(angular, window, undefined) {

	/*var basePath = {
		ctrl: "assets/javascripts/ctrl/",
		view: "assets/view/",
		css: "assets/stylesheets/",
		test: "assets/test/"
	}*/

	/** 路由 **/
	var route = [];

	route.push(constructRouteObject("/homePage", 'ctrl.home', 'view.home.html'));
	route.push(constructRouteObject("/about", 'ctrl.about', 'view.about.html'));
	route.push(constructRouteObject("/index", 'ctrl.index', 'view.index.html'));

	var module = angular.module('base.route', ['ngRoute']);

	module.config(function($routeProvider) {
		for (var i = 0; i < route.length; i++) {
			if (!route[i]) {
				continue;
			}
			$routeProvider.when(route[i].url, {
				templateUrl: basePath.view + route[i].view,
				controller: route[i].ctrl
			});
		}

		$routeProvider.otherwise({
			redirectTo: route[0].url
		});
	});

	function constructRouteObject(reqPath, ctrlName, viewName) {
		var routeTmp = {
			url: reqPath,
			ctrl: ctrlName,
			view: viewName
		}
		return routeTmp;
	}

	/** arguments **/

})(angular, window, undefined);