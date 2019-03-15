package com.victor.springredis.businessimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.victor.springredis.business.ClientesBO;
import com.victor.springredis.model.Cliente;
import com.victor.springredis.model.Cliente.ClienteBuilder;
import com.victor.springredis.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientesBOImpl implements ClientesBO{

	@Autowired
	private final ClienteRepository clienteRepository;
	
	private ClienteBuilder clienteBuilder;
	
	private List<Cliente> listClients;
	
	public ClientesBOImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	@Cacheable(cacheNames = "spring-redis", key="{#nome}")
	public Cliente getCliente(String nome) {
		Cliente cliente =Cliente.builder().id(1L).nome(nome).endereco("BARUERI").build();
		log.debug("Retornou o cliente",cliente.getNome());
		return cliente;
	};
	
	@Override
	@Cacheable(cacheNames = "spring-redis")
	public List<Cliente> getClientes(){
		log.debug(">>> getClientes()");
		
		listClients = new ArrayList<>();
		
		List<Cliente>clientsRepository = this.clienteRepository.findAll();
		
		
		if (!CollectionUtils.isEmpty(clientsRepository)) {
			clientsRepository.stream().forEach(clientRepository -> {
				clienteBuilder = Cliente.builder();
				
				if (clientRepository != null) {
					if (!StringUtils.isEmpty(clientRepository.getId())) {
						clienteBuilder.id(clientRepository.getId());
					}
					if (!StringUtils.isEmpty(clientRepository.getNome())) {
						clienteBuilder.nome(clientRepository.getNome());
					}
					if (!StringUtils.isEmpty(clientRepository.getEndereco())) {
						clienteBuilder.endereco(clientRepository.getEndereco());
					}
					listClients.add(clienteBuilder.build());	
				}
				
			});
		}
		
		
		return listClients;
	}

	
	
}
