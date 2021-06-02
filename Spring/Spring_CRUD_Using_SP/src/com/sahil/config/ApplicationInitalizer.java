package com.sahil.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitalizer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("SpringSpDispatcher",new DispatcherServlet(context));
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
	}

}
