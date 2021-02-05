//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.02.05 a las 01:50:34 AM CET 
//


package com.pspro.xml.consulta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pspro.xml.consulta package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Xxx_QNAME = new QName("http://www.pspro.com/xml/consulta", "xxx");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pspro.xml.consulta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoctorEspecialidadResponse }
     * 
     */
    public DoctorEspecialidadResponse createDoctorEspecialidadResponse() {
        return new DoctorEspecialidadResponse();
    }

    /**
     * Create an instance of {@link Doctor }
     * 
     */
    public Doctor createDoctor() {
        return new Doctor();
    }

    /**
     * Create an instance of {@link EspecialidadDetailsResponse }
     * 
     */
    public EspecialidadDetailsResponse createEspecialidadDetailsResponse() {
        return new EspecialidadDetailsResponse();
    }

    /**
     * Create an instance of {@link Especialidad }
     * 
     */
    public Especialidad createEspecialidad() {
        return new Especialidad();
    }

    /**
     * Create an instance of {@link DoctorNameRequest }
     * 
     */
    public DoctorNameRequest createDoctorNameRequest() {
        return new DoctorNameRequest();
    }

    /**
     * Create an instance of {@link DoctorNameResponse }
     * 
     */
    public DoctorNameResponse createDoctorNameResponse() {
        return new DoctorNameResponse();
    }

    /**
     * Create an instance of {@link DoctorName }
     * 
     */
    public DoctorName createDoctorName() {
        return new DoctorName();
    }

    /**
     * Create an instance of {@link EspecialidadDetailsRequest }
     * 
     */
    public EspecialidadDetailsRequest createEspecialidadDetailsRequest() {
        return new EspecialidadDetailsRequest();
    }

    /**
     * Create an instance of {@link DoctorEspecialidadRequest }
     * 
     */
    public DoctorEspecialidadRequest createDoctorEspecialidadRequest() {
        return new DoctorEspecialidadRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pspro.com/xml/consulta", name = "xxx")
    public JAXBElement<String> createXxx(String value) {
        return new JAXBElement<String>(_Xxx_QNAME, String.class, null, value);
    }

}
