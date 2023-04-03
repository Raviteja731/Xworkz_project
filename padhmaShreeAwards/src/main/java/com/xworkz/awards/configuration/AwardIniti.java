package com.xworkz.awards.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AwardIniti extends AbstractAnnotationConfigDispatcherServletInitializer 
								implements WebMvcConfigurer {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	public AwardIniti() {
		log.info("Created AwardIniti..."+getClass().getSimpleName());
		
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("Created getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("Created getServletConfigClasses");
		Class[] ref = {AwardConfiguration.class};
		return ref;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Created getServletMappings");
		String[] strings = {"/"};
		return strings;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("Created configureDefaultServletHandling");
		configurer.enable();
	}
}
