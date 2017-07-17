package com.cml.learn.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CacheService {
	@Autowired
	private StringRedisTemplate template;

	public void setName(String name) {
		template.boundValueOps("name").set(name);
	}

	public String getName() {
		return (String) template.boundValueOps("name").get();
	}

}
