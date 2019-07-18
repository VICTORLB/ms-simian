package com.victor.springredis.dto;

import com.victor.springredis.model.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DnaHumanSimianDtoV1 extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6763851089994196681L;
	private String[] dna;
	
}
