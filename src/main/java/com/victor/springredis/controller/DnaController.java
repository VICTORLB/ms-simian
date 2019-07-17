package com.victor.springredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.springredis.business.DnaBO;
import com.victor.springredis.constants.DnaConstants;
import com.victor.springredis.model.DnaHumanSimian;

import dto.DnaDtoV1;
import dto.DnaResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = DnaConstants.URL_SIMIAN,
produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_UTF8_VALUE
}
)
public class DnaController {

	private final DnaBO dnaBO;

	@Autowired
    public DnaController(final DnaBO dnaBO) {
        this.dnaBO = dnaBO;
    }
	
	@GetMapping
	public ResponseEntity<DnaResponse> getList() {
		log.info("> > > DnaController.list() < < <");
		return new ResponseEntity<>(dnaBO.getDnas(), HttpStatus.OK);
	}

	@PostMapping	
	public ResponseEntity<DnaDtoV1> postDna(@RequestBody DnaHumanSimian dnaHumanSimian) {
		
		DnaDtoV1 dnaResponse = dnaBO.addDna(dnaHumanSimian); 
		
		if (dnaResponse != null) {
			return ResponseEntity.ok().body(dnaResponse);
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}
