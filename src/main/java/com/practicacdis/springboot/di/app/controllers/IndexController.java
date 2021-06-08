package com.practicacdis.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practicacdis.springboot.di.app.models.service.IServicio;

//Con la anotacion controller se ha declarado esta clase java como Spring Bean 
@Controller
public class IndexController {
	
	//Con la anotacion autowired inyectamos los objetos que esten en nuestro contenedor Spring con el tipo de dato "mi servicio"
	@Autowired
	@Qualifier("miSegundoService") //la anotacion @Qualifier permite seleccionar atraves del nombre en especifico del componente que implementa la interfaz, entre las comillas se escribe el nombre previo
	private IServicio servicio;

	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	
	
	
	
}
