package com.victor.springredis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.victor.springredis.constants.DnaConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = DnaConstants.DNA, uniqueConstraints = {
	      @UniqueConstraint(columnNames = "dna", name = "uniqueDnaConstraint")}
	)
public class Dna extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4241591921865446727L;

	@Id
    @GeneratedValue
	private Long id;

	@NotNull 
	private String dna;
    
    private Boolean isSimian;


	
}
