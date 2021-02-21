package com.soapws.springbootsoapwebserviceclient.controller;

import com.soapws.springbootsoapwebserviceclient.client.CountryClient;
import com.soapws.springbootsoapwebserviceclient.jaxb.GetCountryRequest;
import com.soapws.springbootsoapwebserviceclient.jaxb.GetCountryResponse;
import com.soapws.springbootsoapwebserviceclient.jaxb.ObjectFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

    private final CountryClient countryClient;

    @GetMapping("{countryName}")
    public GetCountryResponse getMethodName(@PathVariable String countryName) {
        final ObjectFactory factory = new ObjectFactory();
        final GetCountryRequest getCountryRequest = factory.createGetCountryRequest();
        getCountryRequest.setName(countryName);
        return countryClient.getCountryResponse(getCountryRequest)
                            .orElseThrow();
    }
    
}
