package com.xworkz.awards.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.awards")
@Slf4j
public class AwardConfiguration {
	
	private Logger log= LoggerFactory.getLogger(this.getClass());


	public AwardConfiguration() {
		
		log.info("Created AwardConfiguration in configuration....");
	}

	@Bean
	public ViewResolver viewResolver() {
		log.info("Running the viewResolver....");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean() {
		log.info("Running the LocalContainerEntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();
	}
}
