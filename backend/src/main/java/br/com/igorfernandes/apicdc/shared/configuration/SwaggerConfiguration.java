package br.com.igorfernandes.apicdc.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

@Configuration
public class SwaggerConfiguration {

    	@Bean
    	public Docket api() {
    		Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("br.com.igorfernandes.apicdc");
    		Predicate<String> apiUrls = PathSelectors.ant("/api/**");
    		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage)
    				.paths(apiUrls).build();

    	}
}
