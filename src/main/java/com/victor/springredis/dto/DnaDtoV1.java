package com.victor.springredis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class DnaDtoV1 {

    public static final String ID = "id";
    @JsonProperty(ID)
    private final Long id;
	
    public static final String DNA = "dna";
    @JsonProperty(DNA)
    private final String dna;
    
    public static final String IS_SIMIAN = "isSimian";
    @JsonProperty(IS_SIMIAN)
    private final Boolean isSimian;
	
}
