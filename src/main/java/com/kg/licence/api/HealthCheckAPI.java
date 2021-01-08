package com.kg.licence.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kg.licence.model.Info;

@RestController
@RequestMapping("/api/health")
public class HealthCheckAPI {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Info healthCheck() {
		Info info = new Info();
		return info;
	}
	
}
