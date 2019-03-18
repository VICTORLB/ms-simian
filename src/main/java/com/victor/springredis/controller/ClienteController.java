package com.victor.springredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springredis.business.ClientesBO;
import com.victor.springredis.model.Cliente;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/clientes",
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}
)
public class ClienteController {

	@Autowired
	private final ClientesBO clientesBO; 
	
	private final String CLIENTE_URI = "clientes/";
	
	public ClienteController(ClientesBO clientesBO) {
		this.clientesBO = clientesBO;
	}

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<Cliente>> getList() {
		log.debug("> > > ClienteController.list() < < <");
		List<Cliente> list = clientesBO.getClientes();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}

	
}
