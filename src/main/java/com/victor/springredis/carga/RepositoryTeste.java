package com.victor.springredis.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.victor.springredis.model.Dna;
import com.victor.springredis.repository.DnaRepository;


@Component
public class RepositoryTeste implements ApplicationRunner 
{

	private static final long ID_DNA_1 = 11l;
	private static final long ID_DNA_2 = 22l;
	
	@Autowired
    private DnaRepository dnaRepository;
	
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

    	System.out.println(">>> Iniciando carga de dados de DNA...");
    	Dna dna1 = Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build();
    	Dna dna2 = Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACTG]").isSimian(true).build();
    	
    	dnaRepository.saveAndFlush(dna1);
	System.out.println(">>> Gravado dna 1: "+dna1);

	dnaRepository.saveAndFlush(dna2);
    	System.out.println(">>> Gravado dna 2: "+dna2);
		
    }
 
}
