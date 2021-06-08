package com.practicacdis.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.practicacdis.springboot.di.app.models.domain.ItemFactura;
import com.practicacdis.springboot.di.app.models.domain.Producto;
import com.practicacdis.springboot.di.app.models.service.IServicio;
import com.practicacdis.springboot.di.app.models.service.MiSegundoService;
import com.practicacdis.springboot.di.app.models.service.MiServicio;

@Configuration
public class AppConfig {
	
	//al igual que con la anotacion @Component en el archivo MiServicio.java utilizamos el mismo nombre y se trabaja de la misma manera.
	
	@Bean("miServicioSimple")
	@Primary //al igual tambien podemos indicar con esta anotacion cual es la que deseamos por default
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	//en caso de no colocar la anotacion @Bean no se podra ejecutar correctamente, 
	@Bean("miSegundoService")
	public IServicio registrarMiServicioComplejo() {
		return new MiSegundoService();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Libro Calculo", 300);
		Producto producto2 = new Producto("Plumas de colores", 50);
		
		ItemFactura itemF1 = new ItemFactura(producto1, 2);
		ItemFactura itemF2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(itemF1, itemF2);
	}

	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Libro Calculo", 300);
		Producto producto2 = new Producto("Plumas de colores", 50);
		Producto producto3 = new Producto("Grapadora ", 80);

		
		ItemFactura itemF1 = new ItemFactura(producto1, 2);
		ItemFactura itemF2 = new ItemFactura(producto2, 1);
		ItemFactura itemF3 = new ItemFactura(producto3, 1);

		
		return Arrays.asList(itemF1, itemF2, itemF3);
	}
	
}
