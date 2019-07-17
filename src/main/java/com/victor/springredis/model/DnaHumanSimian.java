package com.victor.springredis.model;

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
public class DnaHumanSimian extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6763851089994196681L;
	private String[] dna;
	
}
