(function(w){
	var map = w.ERR = {
			"2000000": '',//调用taobao注册宝箱活动接口异常,异常原因为{0},
			"2000001": '',//sessionKey 为空,
			"2000002": '',//调用taobao取消注册宝箱活动接口异常,异常原因为{0},
			"2000003": '',//调用taobao取消注册宝箱活动接口异常,异常原因为{0},
			"2000004": '',//宝箱活动不存在,
			"2000005": '',//{0}状态的宝箱活动不允许执行上线操作,
			"2000006": '',//{0}状态的宝箱活动不允许执行下线操作,
			"2000007": '',//调用taobao{0}操作宝箱活动接口异常,异常原因为{1},
			"2000008": '',//宝箱活动id为空,
			"2000009": '',//查询客户信息时，客户id为空 ,
			"2000010": '',//未知的操作类型,
			"2000011": '',//{0}的时候宝箱实例为空,
			"2000012": '',//Access_Token已经过期,
			"2000013": '',//用户还没有进行没有授权操作 ,
			"2000014": '',//ACCESS_TOKEN为空,
			"2000015": '',//活动已过期，请确认活动时间,
			"2000016": '',//上线状态的宝箱活动不能进行操作,
			"2000017": '',//用户id为空,
			"2000018": '',//'删除失败，请重试',//删除操作调用TB接口失败,异常原因为:{0},
			"2000019": '',//调用淘宝的注册接口返回结果失败,失败原因:{0},
			"2000020": '',//token无效，原因:{0}
			"999999":'服务器繁忙，请重试'
		}
	map.push =  function(id, msg){
		this[i] = msg ;
		return true ;
	}
})(window);