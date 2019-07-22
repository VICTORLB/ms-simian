package com.victor.simian.carga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.victor.simian.model.Dna;
import com.victor.simian.repository.DnaRepository;


@Component
public class RepositoryTeste implements ApplicationRunner 
{

	@Autowired
    private DnaRepository dnaRepository;

	public RepositoryTeste(DnaRepository dnaRepository) {
		this.dnaRepository = dnaRepository;
	}

	@Override
    public void run(ApplicationArguments applicationArguments) {

    	System.out.println(">>> Iniciando carga de dados de DNA...");
    	List<Dna> listDna = new ArrayList<>();
    	listDna.add(Dna.builder().dna("[AATGGA, TCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, ACAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, CCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, GCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TACTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TCCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TGCTGT, ACGCTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGGTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGTTG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGATG, CTCGTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGCTG, CTCCTT, TGTCGG]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCAA]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCAT]").isSimian(false).build());
    	listDna.add(Dna.builder().dna("[AAGAGA, TCAAGC, TTCTGT, ACGCTG, CTCGTT, TGTCCG]").isSimian(false).build());
    	
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACTG]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACTA]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACTC]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACTT]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACGT]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACAT]").isSimian(true).build());
    	listDna.add(Dna.builder().dna("[CTGAGA, CTATGC, TATTGT, AGATGG, CCCCTA, TCACCT]").isSimian(true).build());


    	dnaRepository.saveAll(listDna);
    	dnaRepository.flush();
    	
			
    }
 
}
