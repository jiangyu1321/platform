(function(angular, window, undefined) {

	var module = module('platform.req', []);

	/** 封装http请求模块  **/
	module.factory('pf.req', ['$http', '$rootScope', function($http, $rootScope) {

		/** 判断是否开启DEBUG模式 **/
		var DEBUG = location.href.toUpperCase().indexOf("DEBUG") >= 0;
		DEBUG && console.info("OPEN DEBUG MODEL");

		/** 请求参数封装对象的数组 **/
		var req_store = {};

		/** 请求内容对象的定义 **/
		function ReqItem(config, exp) {
			this.method = config.method;
			this.url = config.url;
			/** 扩展  **/
			this.exp = exp;
		}

		/** 发起http请求 **/
		ReqItem.prototype.getResources = function(param, callback) {

			var _DEBUG = DEBUG;
			DEBUG = DEBUG || this.url.toUpperCase().indexOf("DEBUG") >= 0;

			var debug_path = basePath.test + this.url.replace(/$\//, "") + ".json";
			if (this.method === "POST") {
				httpConfig = {
					method: DEBUG ? "GET" : "POST",
					url: DEBUG ? debug_path : this.url
				};
				httpConfig[DEBUG ? "params" : "data"] = DEBUG ? param : JSON.stringfy(param);
			} else {
				httpConfig = {
					method: 'GET',
					url: DEBUG ? debug_path : this.url
					params: param
				};
			}

			/** 成功处理 **/
			var handleSuccess = function(response, status, headers, cfg) {
					if (response) {
						if (response.retCode === "0") {
							responseFormat.retCode = response.retCode;
							responseFormat.retMsg = response.retMsg;
							responseFormat.retObj = response.retObj;
						} else {
							responseFormat.retCode = response.retCode ? response.retCode : "-2";
							responseFormat.retMsg = response.retMsg ? response.retMsg : "服务器异常"；
							responseFormat.retObj = response.retObj ? response.retObj : null;
						}
					}
					callback(responseFormat);
				}
				/** 错误处理 **/
			var handleError = function(response, status, headers, cfg) {
				callback(responseFormat);
			};

			$http(httpConfig).success(handleSuccess).error(handleError);
			DEBUG = _DEBUG;
		}



		/** 设置http请求的参数 **/
		function setParams(key, config, exp) {

			/** 如果config不是object,默认是请求的方法 **/
			if (typeof config === "string") {
				var temp = config;
				config = new Object();
				config.method = temp;
			}
			var _this = {
				method: config && config.method ? config.method : "GET",
				url: config && config.url
			}
			if (!_this.url) {
				return null;
			}
			if (req_store[key]) {
				return req_store[key];
			}
			//TODO 注释
			var newItem = new ReqItem(_this, exp);
			req_store[key] = newItem;
			return req_store[key];
		}

		/** 获取http请求的参数 **/
		function getParams(key, param, callback) {
			var responseFormat = {
				retCode: "-1",
				retMsg: "非法的资源请求",
				retObj: null
			}

			if (req_store[key]) {
				req_store[key].getResources(params, callback);
			} else {
				callback(responseFormat);
			}
		}

	}]);
})(angular, window, undefined);