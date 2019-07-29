package com.victor.simian.business;

import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaHumanSimianDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

public interface DnaBO {

	DnaResponse getDnas();
	
	DnaDtoV1 addDna(DnaHumanSimianDtoV1 dnaRequest) throws Exception;
	
	StatsDtoV1 getStats();
}
