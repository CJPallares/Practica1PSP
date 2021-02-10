package com.pspro.rest.model;
/**
 * Clase que representa a una Tabla de una Base de Datos. Forma parte del modelo de datos necesario para recibir las peticiones de clientes.
 * @author: Carlos Jiménez
 * @version: 10/02/2021/B
 *
 */
public class Especialidad {
	private String id;
	private String nombreEsp;
	private int nConsulta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreEsp() {
		return nombreEsp;
	}

	public void setNombreEsp(String nombreEsp) {
		this.nombreEsp = nombreEsp;
	}

	public int getNConsulta() {
		return nConsulta;
	}

	public void setNConsulta(int nConsulta) {
		this.nConsulta = nConsulta;
	}

}
