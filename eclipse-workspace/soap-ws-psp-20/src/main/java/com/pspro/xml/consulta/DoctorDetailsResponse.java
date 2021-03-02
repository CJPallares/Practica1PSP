//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.02 a las 10:47:10 PM CET 
//


package com.pspro.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Doctor" type="{http://www.pspro.com/xml/consulta}Doctor"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "doctor"
})
@XmlRootElement(name = "DoctorDetailsResponse")
public class DoctorDetailsResponse {

    @XmlElement(name = "Doctor", required = true)
    protected Doctor doctor;

    /**
     * Obtiene el valor de la propiedad doctor.
     * 
     * @return
     *     possible object is
     *     {@link Doctor }
     *     
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Define el valor de la propiedad doctor.
     * 
     * @param value
     *     allowed object is
     *     {@link Doctor }
     *     
     */
    public void setDoctor(Doctor value) {
        this.doctor = value;
    }

}
