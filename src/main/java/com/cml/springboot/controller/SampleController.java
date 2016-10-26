package com.cml.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cml.springboot.test.SampleTomcatJspApplication;

@SpringBootApplication
@Controller
@ComponentScan(basePackages = "com.cml.springboot.framework")
public class SampleController {

	@RequestMapping("/uploadAction")
	@ResponseBody
	public String upload(MultipartHttpServletRequest req) {
		MultipartFile file = req.getFile("file");
		System.out.println(file.getName());
		return file.getName();
	}
	@RequestMapping("/uploadAction2")
	@ResponseBody
	public String upload2(@RequestParam(name="file2" ,required=true) MultipartFile file) {
		System.out.println(file.getName());
		return file.getName();
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println("test");
		return "test";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		System.out.println("test");
		return "welcome";
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	// @Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.getUrlMappings().clear();
		registration.addUrlMappings("*.do");
		registration.addUrlMappings("*.json");
		// WebMvcAutoConfiguration
		return registration;
	}

	// @Bean
	// public FilterRegistrationBean filterRegistration(Filter filter) {
	// FilterRegistrationBean registration = new FilterRegistrationBean();
	// registration.setFilter(filter);
	// // registration.getUrlMappings().clear();
	// // registration.addUrlMappings("*.do");
	// // registration.addUrlMappings("*.json");
	// return registration;
	// }
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(SampleController.class);
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}