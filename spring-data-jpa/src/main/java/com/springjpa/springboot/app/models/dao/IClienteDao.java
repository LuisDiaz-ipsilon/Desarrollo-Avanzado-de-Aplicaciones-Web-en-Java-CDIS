package com.springjpa.springboot.app.models.dao;

import java.util.List;

import com.springjpa.springboot.app.models.entity.Cliente;

//Por estandar anteponemos la letra I para indicar que es una interfece
//es importante crear una clase de Implementacion, en donde declaremos los metodos de esta interface
public interface IClienteDao {


	
	public List<Cliente> findAll();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
