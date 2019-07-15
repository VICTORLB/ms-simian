package com.victor.springredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.springredis.model.Dna;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {

	Dna findByDna(String dna);
	
}
