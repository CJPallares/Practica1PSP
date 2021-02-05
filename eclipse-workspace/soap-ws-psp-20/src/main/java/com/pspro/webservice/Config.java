package com.pspro.webservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
 
@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter 
{
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) 
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }
    //Nombre del contrato (nombre con el que se publica) nuestro servicio web, en el que se especifican todas las operaciones que se pueden hacer en el servicio web.
    @Bean(name = "doctorDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) 
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DoctorDetailsPort");
        wsdl11Definition.setLocationUri("/service/doctor-details");
        wsdl11Definition.setTargetNamespace("http://www.pspro.com/xml/consulta");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }
 
    @Bean
    public XsdSchema countriesSchema() 
    {
        return new SimpleXsdSchema(new ClassPathResource("consulta.xsd"));
    }
}
