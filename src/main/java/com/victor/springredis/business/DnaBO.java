package com.victor.springredis.business;

import java.util.List;

import com.victor.springredis.model.Cliente;
import com.victor.springredis.model.Dna;

public interface DnaBO {

	public Dna getDna(String dna);
	
	public List<Dna> getDnas();
	
	public Dna getDnaById(Long id);
}
