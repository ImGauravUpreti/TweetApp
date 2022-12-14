package com.tweetapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * 
	 * @return
	 */
	 @Bean
     public Docket postsApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .paths(PathSelectors.ant("/tweets/**"))
                 .build();
     }

 
	 
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("Tweet App")
                 .description(" Service API for Tweetapp")
                 .termsOfServiceUrl("http://www.cognizant.com")
                 .version("1.0")
                 .build();
     }

	

}