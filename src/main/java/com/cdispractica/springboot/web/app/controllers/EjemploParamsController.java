package com.cdispractica.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {

		return "params/index";
	}

	// Todos los parametos se envian con un nombre, lo podemos capturar con la
	// notacion @RequestParam
	@GetMapping("/string")
	// Con el valor required hacemos que la vista puede ser ejecutada aunque no se
	// le mande un texto y con el valor defaultValue se indica el texto por defect
	public String param(@RequestParam(required = false, defaultValue = "No se ingreso texto") String texto,
			Model model) {
		model.addAttribute("resultado", "Eltexto enviado es: " + texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El texto es: '" + saludo + "' y el numero es: '" + numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo= request.getParameter("saludo");
		Integer numero=null;
		try {
			numero= Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		model.addAttribute("resultado", "El texto es: '" + saludo + "' y el numero es: '" + numero + "'");
		return "params/ver";
	}
}
