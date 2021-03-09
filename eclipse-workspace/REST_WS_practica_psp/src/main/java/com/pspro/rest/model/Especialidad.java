package com.pspro.rest.model;

import java.util.HashMap;

/**
 * Clase que representa a una Tabla de una Base de Datos. Forma parte del modelo de datos necesario para recibir las peticiones de clientes.
 * @author: Carlos Jiménez
 * @version: 01/03/2021/C
 *
 */
public class Especialidad {
	private String id;
	private String nombreEsp;
	private int nConsulta;
	HashMap<String, Doctor> listaDoctores;
	

	public Especialidad() {
		this.listaDoctores = new HashMap<>();
	}

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
	
	public HashMap<String, Doctor> getListaDoctores() {
		return listaDoctores;
	}

	public void setListaDoctores(HashMap<String, Doctor> listaDoctores) {
		this.listaDoctores = listaDoctores;
	}
	
	public void addDoctor(Doctor doctor) {
		this.listaDoctores.put(doctor.getId(), doctor);
	}
	
	public void eliminaDoctor(String id) {
		this.listaDoctores.remove(id);
	}
}
