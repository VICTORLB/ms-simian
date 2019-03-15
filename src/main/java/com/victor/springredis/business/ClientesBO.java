package com.victor.springredis.business;

import java.util.List;

import com.victor.springredis.model.Cliente;

public interface ClientesBO {

	public Cliente getCliente(String nome);
	
	public List<Cliente> getClientes();
	
}
