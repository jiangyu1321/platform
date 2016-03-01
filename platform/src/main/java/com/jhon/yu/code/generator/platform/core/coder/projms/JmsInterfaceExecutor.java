package com.jhon.yu.code.generator.platform.core.coder.projms;

import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import com.jhonyu.framework.util.json.JsonUtil;


@Component
public class JmsInterfaceExecutor {

	@Produce(uri = "jms:topic:executeJmsInterface")
	ProducerTemplate executeJmsInterfaceTemplate;

	public Map<String, Object> executJmsInterface(Object vObject) {
		this.executeJmsInterfaceTemplate.sendBodyAndHeader(null, "executeJmsInterfaceHeader", JsonUtil.objectToJson(vObject));
		return null;
	}
}
