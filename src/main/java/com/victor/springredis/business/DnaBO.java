package com.victor.springredis.business;

import com.victor.springredis.model.Dna;
import com.victor.springredis.model.DnaHumanSimian;

import dto.DnaDtoV1;
import dto.DnaResponse;

public interface DnaBO {

	public Dna getDna(String dna);
	
	public DnaResponse getDnas();
	
	public Dna getDnaById(Long id);
	
	public DnaDtoV1 addDna(DnaHumanSimian dnaRequest);
}
