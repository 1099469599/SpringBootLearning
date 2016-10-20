package com.cml.springboot.controller;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableWebMvc()
//@ComponentScan(basePackages = "com.cml.springboot")
public class MyWebmvcAdapter extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/webapp");
		System.out.println("=============================MyWebmvcAdapter.addResourceHandlers");
	}
}
