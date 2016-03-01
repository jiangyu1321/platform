package com.jhon.yu.code.generator.platform.core.coder.projms;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * JMS接口调用监听类
 *
 */
@Component
public class LogicalProcessService implements ApplicationListener<ContextRefreshedEvent> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CamelContext camelContext;

	ObjectMapper objectMapper = new ObjectMapper();
	//将参数转换过来
	ObjectReader paramsInfoReader = this.objectMapper.reader(Object.class);

	public void init() {
		this.logger.info("init tps interface camel routes");
		try {
			this.camelContext.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					this.from("jms:queue:VirtualTopicConsumers.tps.executeJmsInterface?concurrentConsumers=15").to("bean:logicalProcessService?method=exeLogicalInterface").routeId("Logical-IntefaceMatch");
				}
			});
		} catch (Exception e) {
			this.logger.error("camel context start fail", e);
		}

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.init();
	}

	public Map<String, Object> exeLogicalInterface(@Header("executeJmsInterfaceHeader") String param) throws Exception {
		this.logger.debug("dmp execute tps interface  调用环节信息处理,{}", param);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", param);
		/** 具体的处理逻辑 **/
		System.out.println(resultMap.toString());
		return resultMap;
	}
}
