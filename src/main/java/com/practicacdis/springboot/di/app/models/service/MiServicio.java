package com.practicacdis.springboot.di.app.models.service;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//@Primary //con esta anotacion hacemos que esta sea nuestro servicio por default ya que si no lo usamos al levantar el servidor surgira un error indicando que existen dos servicios
//@Component("miServicioSimple") //se deactivan estan anotaciones para dar ejemplo de como seria utilizando una clase de configuracion, al comentar las anotaciones ya no estan en el contenedor
//por lo mencionado anteriomemente puedes ir a el archivo AppConfig.java para ver la otra opcion.
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		//En un servicio por lo general colocamos las peticiones HTTP para los servidores de donde obtenemos la informacion
		//un ejemplo puede ser una funcion que traiga los datos de un cliente en especifico con un id, o la verificacion de pass. y username de una base de datos de usuarios registrados.
		return "Data que proviene de mi servicio";
	}
	//TODO Component Spring debe de tener un constructor por defecto ya que Spring utiliza ese metodo Constructor
	
}
 