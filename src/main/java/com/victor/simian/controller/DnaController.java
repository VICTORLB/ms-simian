package com.victor.simian.controller;

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
import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaHumanSimianDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;

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

	@Autowired
    public DnaController(final DnaBO dnaBO, final GetDnaUseCaseBase getDnaUseCaseBase) {
        this.dnaBO = dnaBO;
		this.getDnaUseCaseBase = getDnaUseCaseBase;
    }
	
	@GetMapping(SimianConstants.URL_LIST)
	public ResponseEntity<DnaResponse> getList() {
		return ResponseEntity.ok().body(getDnaUseCaseBase.execute(null));
	}

	@GetMapping(SimianConstants.URL_STATS)
	public ResponseEntity<StatsDtoV1> getStats() {

		return new ResponseEntity<>(dnaBO.getStats(), HttpStatus.OK);
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
