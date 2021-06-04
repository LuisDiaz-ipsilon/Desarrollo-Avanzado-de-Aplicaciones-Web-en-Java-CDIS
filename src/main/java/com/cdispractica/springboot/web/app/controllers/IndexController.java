package com.cdispractica.springboot.web.app.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdispractica.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.index}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//el nombre del metodo correponde al nombre de la pagina,
	@GetMapping({"/index", "/home", "/", ""}) //en caso de omitir el requestmetod el mismo es por defecto GET, puede usar el @GetMapping o correspondiente
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		//al utilizar el model enviamos parametros para usarlos en el index para poder mostrar esos datos
		return "index";
	}
	//un metodo puede estar mapeado a varias rutas URL como "home"
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario= new Usuario();
		usuario.setNombre("Armando");
		usuario.setApellido("Muñoz");
		usuario.setEmail("armando@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		model.addAttribute("titulo", textoListar);
	
		
		return "listar";
	}
	
	//normalmente se utiliza el @ModelAttribute para pasar datos a la vista o controler del formularrio
	@ModelAttribute("usuarios")
	public ArrayList<Usuario> llenarUsuarios(){
		ArrayList<Usuario> usuarios= new ArrayList<>();
		
		usuarios.add(new Usuario("armando", "Campos", "armando@correo.com"));
		usuarios.add(new Usuario("Eliot", "Alderson", "Eliot@correo.com"));
		usuarios.add(new Usuario("Amanda", "Alderson", "amanda@correo.com"));
		
		return usuarios;	
	}
	
	
	
}
