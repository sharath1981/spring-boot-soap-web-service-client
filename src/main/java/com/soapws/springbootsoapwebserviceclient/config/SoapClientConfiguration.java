package com.soapws.springbootsoapwebserviceclient.config;

import com.soapws.springbootsoapwebserviceclient.client.CountryClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfiguration {

    @Bean
	public Jaxb2Marshaller marshaller() {
		final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.soapws.springbootsoapwebserviceclient.jaxb");
		return marshaller;
	}

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        final CountryClient countryClient = new CountryClient();
        countryClient.setDefaultUri("http://localhost:9999/ws");
		countryClient.setMarshaller(marshaller);
		countryClient.setUnmarshaller(marshaller);
        return countryClient;
    }
    
}
