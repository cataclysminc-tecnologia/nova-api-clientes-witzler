package br.com.witzler.clientes;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import br.com.witzler.clientes.domain.entity.Bandeiras;
import br.com.witzler.clientes.domain.repositorio.BandeirasRepositorio;

@SpringBootApplication
public class ClientesApplication {
	
		public static void main(String[] args) {
			SpringApplication.run(ClientesApplication.class, args);
		}
		
		
		@PostConstruct
	    public void init(){
	      // Setting Spring Boot SetTimeZone
	      TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	      
	      System.out.println("Date in GMT: " + new Date().toString());
	      
	    }
		
		@Bean
		public ConfigurableServletWebServerFactory webServerFactory() {
		    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
		        @Override
		        public void customize(Connector connector) {
		            connector.setProperty("relaxedQueryChars", "|{}[]");
		        }
		    });
		    return factory;
		}
}
