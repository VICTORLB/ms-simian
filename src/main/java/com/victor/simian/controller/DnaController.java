package com.victor.simian.controller;

import com.victor.simian.dto.*;
import com.victor.simian.use_case.GetDnaStatsUseCase;
import com.victor.simian.use_case.impl.GetDnaUseCaseBase;
import lombok.AllArgsConstructor;
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
import com.victor.simian.constants.SimianConstants;

import java.util.Optional;

@RestController
@RequestMapping(
produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_UTF8_VALUE
}
)
public class DnaController {

	private final DnaBO dnaBO;

	private final GetDnaUseCaseBase getDnaUseCaseBase;

	private final GetDnaStatsUseCase getDnaStatsUseCase;


	@Autowired
    public DnaController(final DnaBO dnaBO, final GetDnaUseCaseBase getDnaUseCaseBase, final GetDnaStatsUseCase getDnaStatsUseCase) {
        this.dnaBO = dnaBO;
		this.getDnaUseCaseBase = getDnaUseCaseBase;
		this.getDnaStatsUseCase= getDnaStatsUseCase;
    }
	
	@GetMapping(SimianConstants.URL_LIST)
	public ResponseEntity<DnaResponse> getList() {
		return ResponseEntity.ok().body(getDnaUseCaseBase.execute(Optional.of(DnaRequest.builder().build())));
	}

	@GetMapping(SimianConstants.URL_STATS)
	public ResponseEntity<StatsDtoV1> getStats() {
		return ResponseEntity.ok().body(getDnaStatsUseCase.execute(Optional.of(DnaRequest.builder().build())));
	}
	
	@PostMapping(value = SimianConstants.URL_SIMIAN)
	public ResponseEntity<DnaDtoV1> postDna(@RequestBody DnaHumanSimianDtoV1 dnaHumanSimian) throws Exception {
		
		DnaDtoV1 dnaResponse = dnaBO.addDna(dnaHumanSimian); 
		
		if (dnaResponse != null) {
			if (dnaResponse.getIsSimian() != null)
				return ResponseEntity.ok().body(dnaResponse);
			else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}
