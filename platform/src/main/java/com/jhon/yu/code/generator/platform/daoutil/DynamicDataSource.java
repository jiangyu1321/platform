package com.jhon.yu.code.generator.platform.daoutil;


import javax.sql.DataSource;

import com.jhonyu.framework.frame.datasource.RoutingDataSource;


/**
 * @Description: 动态数据源对应的bean
 * @className: DynamicDataSource
 * @userName: jiangyu
 * @date: 2015年11月6日 下午4:48:13
 */
public class DynamicDataSource extends RoutingDataSource
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        String index = DBContextHolder.getDataSourceIndex();
        return index;
    }

    @Override
    public void addDataSource(String key, DataSource ds)
    {
        if (null == key || "".equals(key))
        {
            return;
        }

        if (null != ds)
        {
            super.getTargetDataSources().put(key, ds);
            super.getResolvedDataSources().put(key, ds);
        }
    }
}
