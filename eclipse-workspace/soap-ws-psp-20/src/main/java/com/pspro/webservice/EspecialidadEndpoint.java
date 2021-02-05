package com.pspro.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pspro.xml.consulta.EspecialidadDetailsRequest;
import com.pspro.xml.consulta.EspecialidadDetailsResponse;
 
@Endpoint
public class EspecialidadEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.pspro.com/xml/consulta";
 
    private EspecialidadRepository EspecialidadRepository;
 
    @Autowired
    public EspecialidadEndpoint(EspecialidadRepository EspecialidadRepository) {
        this.EspecialidadRepository = EspecialidadRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EspecialidadDetailsRequest")
    @ResponsePayload
    public EspecialidadDetailsResponse getEspecialidad(@RequestPayload EspecialidadDetailsRequest request) {
    	EspecialidadDetailsResponse response = new EspecialidadDetailsResponse();
        response.setEspecialidad(EspecialidadRepository.findEspecialidad(request.getNombreEspecialidad()));
 
        return response;
    }
}