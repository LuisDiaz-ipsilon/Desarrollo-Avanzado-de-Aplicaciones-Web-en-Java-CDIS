package com.practicacdis.springboot.di.app.models.service;

//import org.springframework.stereotype.Component;

//@Component("miSegundoService")
public class MiSegundoService implements IServicio{

	@Override
	public String operacion() {
		return "Data que provinene de mi segundo servicio";
	}
	
}
