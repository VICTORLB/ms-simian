package com.victor.springredis.business;

import com.victor.springredis.dto.DnaDtoV1;
import com.victor.springredis.dto.DnaHumanSimianDtoV1;
import com.victor.springredis.dto.DnaResponse;
import com.victor.springredis.dto.StatsDtoV1;
import com.victor.springredis.model.Dna;

public interface DnaBO {

	public DnaResponse getDnas();
	
	public DnaDtoV1 addDna(DnaHumanSimianDtoV1 dnaRequest);
	
	public StatsDtoV1 getStats();
}
