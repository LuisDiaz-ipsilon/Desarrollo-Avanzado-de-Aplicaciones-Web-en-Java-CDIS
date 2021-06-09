package com.springjpa.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //IMPORTANTE estas dos anotaciones/decoradores son pilares
@Table(name = "clientes") //es importante seguir el estandar de java para la sintaxis en lenguaje SQL las tablas en plural decibo a que es un conjunto de registros
//y las clases de java son en singular debido a que manejamos un objeto a la vez
public class Cliente implements Serializable {
	//implementamos Serializable debido a que el objeto sera transferido a una unidad de almacenamiento, en este caso a una sesion HTTP
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;

	//Esta parte del codigo es una fecha y nos apoyamos de los decoradotes para darle el formato deseado.
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)//con .DATE especificamos solo la fecha, sin horas.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
