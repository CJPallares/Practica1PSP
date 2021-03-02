package com.pspro.rest.model;
/**
 * Clase que representa a una Tabla de una Base de Datos. Forma parte del modelo de datos necesario para recibir las peticiones de clientes.
 * @author: Carlos Jiménez
 * @version: 01/03/2021/C
 *
 */
public class Hospital {
	private String id;
	private String nombre;
	private int nHabitaciones;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getnHabitaciones() {
		return nHabitaciones;
	}

	public void setnHabitaciones(int nHabitaciones) {
		this.nHabitaciones = nHabitaciones;
	}

}