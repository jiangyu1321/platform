package com.jhon.yu.code.generator.platform.utils;

import java.util.ResourceBundle;

/**
 * @Description: 读取配置文件
 * @className: ResourceUtil
 * @userName: jiangyu
 * @date: 2016年1月8日 下午10:35:49
 */
public class ResourceUtil
{
    private static ResourceBundle bundle;

    static{
        bundle = java.util.ResourceBundle.getBundle("config/setting");
    }
    /**
     * @Description: 获取bundle实例
     * @userName: jiangyu
     * @date: 2016年1月8日 下午10:36:58
     * @return
     */
    public static ResourceBundle getInstance()
    {
        return bundle;
    }

}

