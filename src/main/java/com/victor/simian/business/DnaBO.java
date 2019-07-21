package com.victor.simian.business;

import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaHumanSimianDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;

public interface DnaBO {

	public DnaResponse getDnas();
	
	public DnaDtoV1 addDna(DnaHumanSimianDtoV1 dnaRequest);
	
	public StatsDtoV1 getStats();
}
