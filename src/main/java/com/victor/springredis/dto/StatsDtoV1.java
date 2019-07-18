package com.victor.springredis.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class StatsDtoV1 {

	public static final String COUNT_MUTANT_DNA = "count_mutant_dna";
    @JsonProperty(COUNT_MUTANT_DNA)
    private final Long countMutantDna;
	
    public static final String COUNT_HUMAN_DNA = "count_human_dna";
    @JsonProperty(COUNT_HUMAN_DNA)
    private final Long countHumanDna;
	
    public static final String RATIO = "ratio";
    @JsonProperty(RATIO)
    private final BigDecimal ratio;
		
	
}
