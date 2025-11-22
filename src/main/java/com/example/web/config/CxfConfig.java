package com.example.web.config;

import com.example.web.Ws.CompteSoapService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {


    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/services/*");
    }


    @Bean(name = SpringBus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public Endpoint compteEndpoint(SpringBus springBus,
                                   CompteSoapService compteSoapService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, compteSoapService);
        endpoint.publish("/ws");
        return endpoint;
    }
}

