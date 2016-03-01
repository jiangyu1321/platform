(function(angular, window, undefined) {

	var module = angular.module('auth', []);

	module.factory('auth.login', ['$http', function($http) {

		function doSubmit(username, password, cb) {

			$http.post("/login.do", {
					username: username,
					password: password
				})
				.success(function(data, status, headers, config) {
					if (data) {
						return cb && cb(data.retCode, data.msg);
					}
				})
				.error(function(data, status, headers, config) {
					return cb && cb(9999, "");
				});
			return true;
		}

		var mySer = {
			doSubmit: doSubmit
		};

		return mySer;
	}]);

})(angular, window, undefined);