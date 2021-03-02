package com.pspro.webservice;
/**
 * Clase  encargada de procesar peticiones.
 * @author: Carlos Jiménez
 * @version: 5/02/2021/C
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pspro.xml.consulta.DoctorColegiadoRequest;
import com.pspro.xml.consulta.DoctorColegiadoResponse;
import com.pspro.xml.consulta.DoctorDetailsRequest;
import com.pspro.xml.consulta.DoctorDetailsResponse;


 
@Endpoint
public class DoctorEndpoint 
{
	// Se indica la dirección a la que tenemos que conectarnos para hacer una petición (consumir un web service)
    private static final String NAMESPACE_URI = "http://www.pspro.com/xml/consulta";
 
    private DoctorRepository DoctorRepository;
    
    //En el momento en que se levante la aplicación se creará un objeto de tipo Endpoint automáticamente
    @Autowired
    public DoctorEndpoint(DoctorRepository DoctorRepository) {
        this.DoctorRepository = DoctorRepository;
    }
    
    // Método que recibe la información de una petición de tipo DoctorDetailsRequest y devolverá como respuesta
    // la información del objeto Doctor cuyo nombre coincida con el que se encuentre en el Map.
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DoctorDetailsRequest")
    @ResponsePayload
    public DoctorDetailsResponse getDoctor(@RequestPayload DoctorDetailsRequest request) {
    	DoctorDetailsResponse response = new DoctorDetailsResponse();
        response.setDoctor(DoctorRepository.findDoctor(request.getFirstname()));
        return response;
    }
    
    // Método que recibe la información de una petición de tipo DoctorColegiadoRequest y devolverá como respuesta
    // el número de colegiado del doctor cuyo nombre coincida con el que se encuentre en el Map.
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DoctorColegiadoRequest")
    @ResponsePayload
    public DoctorColegiadoResponse getDoctor(@RequestPayload DoctorColegiadoRequest request) {
    	DoctorColegiadoResponse response = new DoctorColegiadoResponse();
        response.setNColegiado(DoctorRepository.findDoctor(request.getFirstname()).getNColegiado());
        return response;
    }
    
}