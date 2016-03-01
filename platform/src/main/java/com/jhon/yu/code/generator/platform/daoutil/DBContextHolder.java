package com.jhon.yu.code.generator.platform.daoutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jhon.yu.code.generator.platform.constants.StrConstant;

/**
 * @Description: 设置数据库的上下文持有者
 * @className: DBContextHolder
 * @userName: jiangyu
 * @date: 2015年11月6日 下午4:02:02
 */
public class DBContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setGlobalDataSource() {
		contextHolder.set(StrConstant.SESSION_VAR_GLOBAL);
	}

	public static void setDynamicDataSource() {
		ServletRequestAttributes requests = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null == requests || null == requests.getRequest()) {
			return;
		}
		HttpServletRequest request = requests.getRequest();
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(StrConstant.SESSION_VAR_SHOP_ID);
		if (obj == null) {
			contextHolder.set(StrConstant.SESSION_VAR_GLOBAL);
		} else {
			String brandId = String.valueOf(obj);
			contextHolder.set(brandId);
		}
	}

	public static void setDynamicDataSource(int shopId) {
		contextHolder.set(String.valueOf(shopId));
	}

	public static String getDataSourceIndex() {
		return contextHolder.get();
	}

	public static void clear() {
		contextHolder.remove();
	}
}
