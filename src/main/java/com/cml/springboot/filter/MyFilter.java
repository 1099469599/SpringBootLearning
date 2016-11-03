package com.cml.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 目前只能通过类名命名来设置执行顺序
 * 
 * @author team-lab
 *
 */
public class MyFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(arg0, arg1);

		HttpServletRequest request = (HttpServletRequest) arg0;

		System.out.println(
				"=============================dofilter===============================" + request.getRequestURL());

	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("=============================init===============================");
	}

}
