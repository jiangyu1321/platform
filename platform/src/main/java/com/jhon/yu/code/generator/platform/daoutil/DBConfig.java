package com.jhon.yu.code.generator.platform.daoutil;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jhonyu.framework.frame.util.SpringContextUtil;


/**
 * 数据库公共配置类，数据来源config/common.properties 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangyu
 * @version 2015年11月9日
 * @see DBConfig
 * @since
 */
@Component("dbconfig")
public class DBConfig
{
    private DBConfig()
    {
    }

    private static DBConfig getConfig()
    {
        return (DBConfig)SpringContextUtil.getApplicationContext().getBean("dbconfig");
    }

    @Value("#{commonProps['db.datasource.dynamic.driverClasss']}")
    private String driverClass;

    @Value("#{commonProps['db.datasource.dynamic.address.prefix']}")
    private String urlPrefix;

    @Value("#{commonProps['db.datasource.dynamic.address.suffix']}")
    private String urlSuffix;

    @Value("#{commonProps['db.datasource.dynamic.address.dateConvert']}")
    private String convertConfig;

    @Value("#{commonProps['db.datasource.dynamic.default.username']}")
    private String userName;

    @Value("#{commonProps['db.datasource.dynamic.default.password']}")
    private String password;

    /**
     * @Description: 获取数据库驱动
     * @userName: jiangyu
     * @date: 2015年11月10日 下午1:52:21
     * @return
     */
    public static String getDriverClass()
    {
        return getConfig().driverClass;
    }
    /**
     * @Description: 获取数据库连接url
     * @userName: jiangyu
     * @date: 2015年11月10日 下午1:52:45
     * @param domain
     * @param dbnameSufix
     * @return
     */
    public static String getUrl(String domain, String dbnameSufix)
    {
        StringBuffer url = new StringBuffer();
        url.append(getConfig().urlPrefix).append(domain).append(getConfig().urlSuffix)
            .append(dbnameSufix).append(getConfig().convertConfig);
        return url.toString();
    }
    /**
     * @Description: 获取用户名
     * @userName: jiangyu
     * @date: 2015年11月10日 下午1:53:09
     * @return
     */
    public static String getUserName()
    {
        return getConfig().userName;
    }
    /**
     * @Description: 获取密码
     * @userName: jiangyu
     * @date: 2015年11月10日 下午1:53:21
     * @return
     */
    public static String getPassword()
    {
        return getConfig().password;
    }
    
    @Value("#{commonProps['db.datasource.test.address']}")
    private String testAddress;
    
    @Value("#{commonProps['db.datasource.test.suffix']}")
    private String testAddressSuffix;

    @Value("#{commonProps['db.datasource.test.default.username']}")
    private String testName;

    @Value("#{commonProps['db.datasource.test.default.password']}")
    private String testPass;

    public static String getTestAddress()
    {
        return getConfig().testAddress;
    }

    public static String getTestName()
    {
        return getConfig().testName;
    }

    public static String getTestPass()
    {
        return getConfig().testPass;
    }

    public static String getTestAddressSuffix()
    {
        return getConfig().testAddressSuffix;
    }
    
}
