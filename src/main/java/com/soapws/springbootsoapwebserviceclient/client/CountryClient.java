package com.soapws.springbootsoapwebserviceclient.client;

import java.util.Optional;

import com.soapws.springbootsoapwebserviceclient.jaxb.GetCountryRequest;
import com.soapws.springbootsoapwebserviceclient.jaxb.GetCountryResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryClient extends WebServiceGatewaySupport {

    public Optional<GetCountryResponse> getCountryResponse(GetCountryRequest getCountryRequest) {

        final GetCountryResponse getCountryResponse = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(getCountryRequest);
        return Optional.ofNullable(getCountryResponse);
    }
    
}
