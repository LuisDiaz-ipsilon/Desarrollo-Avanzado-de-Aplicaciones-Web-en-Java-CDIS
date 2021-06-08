package com.practicacdis.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component //Las clases POJO tambien pueden ser manejados por Spring mediante la anotacion @Component
@RequestScope //Con esta anotacion, este beans durara solo la peticion HTTP por cada usuario que se conecte, en otro casos se duplicaria por cada actualizacion
public class Factura implements Serializable{ //se recomienda implementar Seriazable para que se pueda guardar y transportar
	
	private static final long serialVersionUID = 94600357128146951L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired //esta lista no esta configurada como componente pero se registro en la clase AppConfig.java, para poder ser inyectada
	private List<ItemFactura> items;
	
	@PostConstruct //Esta anotacion se ejecuta despues de crear el objeto, despues de inyectar la despues de inyectar la independencia, cone esto podemos modificar los valores.
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("José"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy //esta es la contraparte del @PostConstruct, esta se ejecuta despues de parar la aplicacion en el servidor. 
	//se utiliza principalmente para cerrar recursos.
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
