package com.victor.springredis.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.victor.springredis.model.Cliente;
import com.victor.springredis.repository.ClienteRepository;


@Component
public class RepositoryTeste implements ApplicationRunner 
{

	private static final long ID_CLIENTE_1 = 11l;
	private static final long ID_CLIENTE_2 = 22l;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

    	System.out.println(">>> Iniciando carga de dados...");
    	Cliente client1 = new Cliente(ID_CLIENTE_1,"Joao","Barueri");
    	Cliente client2 = new Cliente(ID_CLIENTE_2,"Pedro","Sao Paulo");    	
    	
	clienteRepository.saveAndFlush(client2);
	System.out.println(">>> Gravado cliente 2: "+client2);

    	clienteRepository.saveAndFlush(client1);
    	System.out.println(">>> Gravado cliente 1: "+client1);
		
    }
 
}
