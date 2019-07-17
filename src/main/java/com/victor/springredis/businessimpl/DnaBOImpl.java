package com.victor.springredis.businessimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victor.springredis.business.DnaBO;
import com.victor.springredis.model.Dna;
import com.victor.springredis.model.DnaHumanSimian;
import com.victor.springredis.repository.DnaRepository;
import com.victor.springredis.util.DnaUtil;

import dto.DnaDtoV1;
import dto.DnaResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DnaBOImpl implements DnaBO{
	
	private DnaRepository dnaRepository;
	
	public Dna getDna(String dna) {
	
		return null;
	}

	public DnaResponse getDnas() {
	
		final List<Dna> foundDnas= dnaRepository.findAll();
		
		if (foundDnas == null) {
            return DnaResponse.builder().build();
        }
		List<DnaDtoV1> lista = new ArrayList<>();
		for (Dna item : foundDnas) {
			lista.add(DnaDtoV1.builder().dna(item.getDna())
					.id(item.getId())
					.isSimian(item.getIsSimian())
					.build());
		}
		return DnaResponse.builder().dna(lista).build();
		
	}

	public Dna getDnaById(Long id) {
		
		return null;
	}

	public DnaDtoV1 addDna(DnaHumanSimian dnaRequest) {
		Dna dna = dnaRepository.saveAndFlush(Dna.builder()
				.dna(Arrays.toString(dnaRequest.getDna()))
				.isSimian(DnaUtil.isSimian(dnaRequest.getDna()))
				.build());
		
		return DnaDtoV1.builder()
				.dna(dna.getDna())
				.id(dna.getId())
				.isSimian(dna.getIsSimian()).build();
	}
	
}
