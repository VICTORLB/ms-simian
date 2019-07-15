package com.victor.springredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.springredis.business.ClientesBO;
import com.victor.springredis.business.DnaBO;
import com.victor.springredis.model.Cliente;
import com.victor.springredis.model.Dna;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/dna",
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE},
consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}
)
public class DnaController {

	@Autowired
	private final DnaBO dnaBO;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<Dna>> getList() {
		log.debug("> > > DnaController.list() < < <");
		List<Dna> list = dnaBO.getDnas();
		return new ResponseEntity<List<Dna>>(list, HttpStatus.OK);
	}

//	 @GetMapping("/{id}")
//	 @ResponseBody
//	 public ResponseEntity<Cliente> getEmployeeById(@PathVariable(value = "id") Long clientId)
//	   throws ResourceNotFoundException {
//	  Cliente cliente = clientesBO.getClientById(clientId);
//	  return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
//
//	 }
	
}
