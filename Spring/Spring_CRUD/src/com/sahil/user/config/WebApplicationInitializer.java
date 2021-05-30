package com.sahil.user.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(MvcConfig.class);
		
		ServletRegistration.Dynamic dispatch = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(applicationContext));
		dispatch.setLoadOnStartup(1);
		dispatch.addMapping("/");
	}

}
