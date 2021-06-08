package com.springformejemplo.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springformejemplo.springboot.form.app.models.domain.Usuario;
import com.springformejemplo.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-K");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	//Vemos una anotacion diferente, cada que se necesite hacer un post podemos utilizar @PostMapping y la direccion de la vista
	@PostMapping("/form")
	//El objeto dentro BindingResult, es propio de Spring, y en caso de fallar la validacion nos apoyara con la notificacion.
	//nota: es importante que se inyecte despues del objeto con la etiqueta @Value. si se agrega un argumento entre los dos fallara.
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		// validador.validate(usuario, result);
		
		model.addAttribute("titulo", "Resultado form");
		
		//con este metodo hacemos uso del objeto BindingResult que nos notificara de algun error
		if(result.hasErrors()) {
			/*//con esta dorma obtenermos una lista que guardamos en un map para poder mostrarlos en la vista, esta es un de las opciones por mostrar los errores.
			Map<String, String> errores= new HashMap<>();
			result.getFieldErrors().forEach(err->{
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);*/
			//se comenta esta parte ya que el framwork nos apoya para la automatizacion de muchas de las validaciones, como se implemento en las etiquetas de  los divs en la vista de form 
			//principalmente por el uso de la etiqueta th:errors"*{objeto}"
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
        status.setComplete();
		return "resultado";
	}

	/*
	@PostMapping("/form")
	public String procesar(Model model,
			//Estos son los tres campos que recibimos desde la vista form.html, en caso de nom
			@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam String email) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}*/

}
