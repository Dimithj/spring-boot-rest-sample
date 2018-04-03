package org.samples.springbootrestsample;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ProductizationConfiguration extends WebMvcConfigurerAdapter{
	
	
	

//	  @Autowired 
//	  HandlerInterceptor yourInjectedInterceptor;

	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
//	    registry.addInterceptor(getYourInterceptor()).; 

	    }

}



