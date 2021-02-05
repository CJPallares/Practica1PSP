package com.pspro.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pspro.xml.consulta.DoctorEspecialidadRequest;
import com.pspro.xml.consulta.DoctorEspecialidadResponse;
import com.pspro.xml.consulta.DoctorNameRequest;
import com.pspro.xml.consulta.DoctorNameResponse;

 
@Endpoint
public class DoctorEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.pspro.com/xml/consulta";
 
    private DoctorRepository DoctorRepository;
 
    @Autowired
    public DoctorEndpoint(DoctorRepository DoctorRepository) {
        this.DoctorRepository = DoctorRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public DoctorNameResponse getStudent(@RequestPayload DoctorNameRequest request) {
    	DoctorNameResponse response = new DoctorNameResponse();
        response.setDoctor(DoctorRepository.findDoctor(request.getFirstname()));
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DoctorEspecialidadRequest")
    @ResponsePayload
    public DoctorEspecialidadResponse getStudent(@RequestPayload DoctorEspecialidadRequest request) {
    	DoctorEspecialidadResponse response = new DoctorEspecialidadResponse();
        response.setDoctor(DoctorRepository.findDoctor(request.getNombreEspecialidad()));
 
        return response;
    }
    
}