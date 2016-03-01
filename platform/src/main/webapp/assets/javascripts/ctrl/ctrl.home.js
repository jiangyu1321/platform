app.controller('ctrl.home', ['$scope', 'auth.login', "$location", function($scope, $login, $location) {

	var login = $scope.login = {
		username: "",
		password: "",
		error: ""
	};

	$scope.login.submit = function($ev) {
		$login.doSubmit(login.username, login.password, function(code, msg) {
			switch (code) {
				case "0":
					$location.path("/index");
				default:
					login.error = msg || "系统异常";
			}
		});
	}

}])