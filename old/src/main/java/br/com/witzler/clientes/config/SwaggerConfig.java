package br.com.witzler.clientes.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Profile( value = {"swagger"} )
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docket () {
		return new Docket(DocumentationType.SWAGGER_2)
					.useDefaultResponseMessages(false)
					.select()
					.apis( RequestHandlerSelectors.basePackage("br.com.witzler.clientes.api.controller") )
					.paths(PathSelectors.any())
					.build()
					.securityContexts(Arrays.asList(securityContext()))
					.securitySchemes(Arrays.asList(apiKey()))
					.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
					.title("Api Clientes Witzler")
					.description("Api para o sistema web Witzler Energia | Mercado Livre de Energia")
					.version("1.1")
					.contact(contact())
					.build();
	}
	
	private Contact contact() {
		return new Contact("Leonardo Sousa", "https://www.witzler.com.br", "leonardo.sousa@witzlerenergia.com.br");
	}
	
	
	public ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	
	
	private SecurityContext securityContext () {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.any()).build();
	}
	
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope( "global", "accessEverything");
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = authorizationScope;
		SecurityReference reference = new SecurityReference("JWT",scopes);
		List<SecurityReference> auths = new ArrayList<>();
		auths.add(reference);
		return auths;
	}
	
	
	/*
	@RequestMapping( value="swagger-ui.html", method = RequestMethod.GET )
	public void getSwagger(HttpServletResponse httpResponse ) throws IOException {
		httpResponse.setStatus( HttpStatus.NOT_FOUND.value() );
	}*/

}
