//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.02.05 a las 03:31:45 PM CET 
//


package com.pspro.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Doctor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Doctor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="edad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nColegiado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Especialidad" type="{http://www.pspro.com/xml/consulta}Especialidad"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Doctor", propOrder = {
    "firstname",
    "lastname",
    "edad",
    "nColegiado",
    "especialidad"
})
public class Doctor {

    @XmlElement(required = true)
    protected String firstname;
    @XmlElement(required = true)
    protected String lastname;
    protected int edad;
    @XmlElement(required = true)
    protected String nColegiado;
    @XmlElement(name = "Especialidad", required = true)
    protected Especialidad especialidad;

    /**
     * Obtiene el valor de la propiedad firstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Define el valor de la propiedad firstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Obtiene el valor de la propiedad lastname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Define el valor de la propiedad lastname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Obtiene el valor de la propiedad edad.
     * 
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Define el valor de la propiedad edad.
     * 
     */
    public void setEdad(int value) {
        this.edad = value;
    }

    /**
     * Obtiene el valor de la propiedad nColegiado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNColegiado() {
        return nColegiado;
    }

    /**
     * Define el valor de la propiedad nColegiado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNColegiado(String value) {
        this.nColegiado = value;
    }

    /**
     * Obtiene el valor de la propiedad especialidad.
     * 
     * @return
     *     possible object is
     *     {@link Especialidad }
     *     
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Define el valor de la propiedad especialidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Especialidad }
     *     
     */
    public void setEspecialidad(Especialidad value) {
        this.especialidad = value;
    }

}
