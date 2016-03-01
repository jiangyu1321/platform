package com.jhon.yu.code.generator.platform.aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Description: 自定义日志切面
 * @className: LogAnnotation
 * @userName: jiangyu
 * @date: 2016年2月23日 下午8:52:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    /**
     * @Description: 模块名称
     * @userName: jiangyu
     * @date: 2016年2月23日 下午8:54:55
     * @return
     */
    String opeModuleName();

    /**
     * @Description: 方法名称
     * @userName: jiangyu
     * @date: 2016年2月23日 下午8:54:59
     * @return
     */
    String opeFunName();

    /**
     * @Description: 描述
     * @userName: jiangyu
     * @date: 2016年2月23日 下午8:55:04
     * @return
     */
    String opeDes();
}
