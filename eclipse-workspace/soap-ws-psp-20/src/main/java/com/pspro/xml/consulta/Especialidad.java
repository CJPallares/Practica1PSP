//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.02.05 a las 01:50:34 AM CET 
//


package com.pspro.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Especialidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Especialidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreEspecialidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreHospital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nConsulta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Especialidad", propOrder = {
    "nombreEspecialidad",
    "nombreHospital",
    "nConsulta"
})
public class Especialidad {

    @XmlElement(required = true)
    protected String nombreEspecialidad;
    @XmlElement(required = true)
    protected String nombreHospital;
    protected int nConsulta;

    /**
     * Obtiene el valor de la propiedad nombreEspecialidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    /**
     * Define el valor de la propiedad nombreEspecialidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEspecialidad(String value) {
        this.nombreEspecialidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreHospital.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreHospital() {
        return nombreHospital;
    }

    /**
     * Define el valor de la propiedad nombreHospital.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreHospital(String value) {
        this.nombreHospital = value;
    }

    /**
     * Obtiene el valor de la propiedad nConsulta.
     * 
     */
    public int getNConsulta() {
        return nConsulta;
    }

    /**
     * Define el valor de la propiedad nConsulta.
     * 
     */
    public void setNConsulta(int value) {
        this.nConsulta = value;
    }

}
