package com.victor.simian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.simian.business.DnaBO;
import com.victor.simian.constants.DnaConstants;
import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaHumanSimianDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value =DnaConstants.URL_API+DnaConstants.URL_SIMIAN,
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
		return new ResponseEntity<>(dnaBO.getDnas(), HttpStatus.OK);
	}

	@GetMapping(DnaConstants.URL_STATS)
	public ResponseEntity<StatsDtoV1> getStats() {
		return new ResponseEntity<>(dnaBO.getStats(), HttpStatus.OK);
	}
	
	@PostMapping	
	public ResponseEntity<DnaDtoV1> postDna(@RequestBody DnaHumanSimianDtoV1 dnaHumanSimian) {
		
		DnaDtoV1 dnaResponse = dnaBO.addDna(dnaHumanSimian); 
		
		if (dnaResponse != null) {
			if (dnaResponse.getIsSimian())
				return ResponseEntity.ok().body(dnaResponse);
			else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}
