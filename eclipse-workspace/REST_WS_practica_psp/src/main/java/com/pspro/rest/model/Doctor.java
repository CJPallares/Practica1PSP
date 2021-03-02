package com.pspro.rest.model;
/**
 * Clase que representa a una Tabla de una Base de Datos. Forma parte del modelo de datos necesario para recibir las peticiones de clientes.
 * @author: Carlos Jiménez
 * @version: 01/03/2021/C
 *
 */
public class Doctor {
	private String id;
	private String nombre;
	private int edad;
	private String dni;
	Especialidad especialidad;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
}
