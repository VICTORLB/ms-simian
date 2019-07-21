package com.victor.simian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.simian.model.Dna;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {

	Dna findByDna(String dna);
	
}
