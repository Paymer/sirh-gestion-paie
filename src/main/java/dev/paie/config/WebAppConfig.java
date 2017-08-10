package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@Import(ServicesConfig.class)
@ComponentScan("dev.paie.web.controller")
public class WebAppConfig {

	@Bean
	public ViewResolver viewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}
	
}
