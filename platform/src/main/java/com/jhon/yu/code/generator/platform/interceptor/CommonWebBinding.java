package com.jhon.yu.code.generator.platform.interceptor;


import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @Description: 解决日期转换问题
 * @className: CommonWebBinding
 * @userName: jiangyu
 * @date: 2016年1月7日 下午4:36:26
 */
public class CommonWebBinding implements WebBindingInitializer
{

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
        // 自定义的PropertyEditorSupport
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
    }
}
