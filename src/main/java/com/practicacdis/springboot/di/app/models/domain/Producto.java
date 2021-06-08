package com.practicacdis.springboot.di.app.models.domain;

public class Producto {
	private String nombre;
	private Integer precio;

	public Producto(String nombre, Integer precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}
