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
import com.pspro.xml.consulta.EspecialidadDetailsRequest;
import com.pspro.xml.consulta.EspecialidadDetailsResponse;


@Endpoint
public class EspecialidadEndpoint 
{
	// Se indica la dirección a la que tenemos que conectarnos para hacer una petición (consumir un web service)
    private static final String NAMESPACE_URI = "http://www.pspro.com/xml/consulta";
 
    private EspecialidadRepository EspecialidadRepository;
    
    //En el momento en que se levante la aplicación se creará un objeto de tipo Endpoint automáticamente
    @Autowired
    public EspecialidadEndpoint(EspecialidadRepository EspecialidadRepository) {
        this.EspecialidadRepository = EspecialidadRepository;
    }
    
    /**
     * Método que recibe la información de una petición de tipo EspecialidadDetailsRequest y devolverá como respuesta
     * la información del objeto Especialidad cuyo nombre coincida con el que se encuentre en el Map.
     * @param request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EspecialidadDetailsRequest")
    @ResponsePayload
    public EspecialidadDetailsResponse getEspecialidad(@RequestPayload EspecialidadDetailsRequest request) {
    	EspecialidadDetailsResponse response = new EspecialidadDetailsResponse();
        response.setEspecialidad(EspecialidadRepository.findEspecialidad(request.getNombreEspecialidad()));
        return response;
    }
}