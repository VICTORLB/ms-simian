package com.victor.springredis.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8761515058345417223L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Length(min=2, max=30,message="O tamanho do nome deve ser entre {min} e {max} caracteres")
	private String nome;

    @NotNull
    @Length(min=2, max=300,message="O tamanho do endereço deve ser entre {min} e {max} caracteres")
	private String endereco;

	
}
