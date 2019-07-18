package com.victor.springredis.businessimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victor.springredis.business.DnaBO;
import com.victor.springredis.dto.DnaDtoV1;
import com.victor.springredis.dto.DnaHumanSimianDtoV1;
import com.victor.springredis.dto.DnaResponse;
import com.victor.springredis.dto.StatsDtoV1;
import com.victor.springredis.model.Dna;
import com.victor.springredis.repository.DnaRepository;
import com.victor.springredis.util.DnaUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DnaBOImpl implements DnaBO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DnaBOImpl.class);
	
	private DnaRepository dnaRepository;
	
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
		
		/*
		//payment schema

		final var paymentsConditions = cartWebOrder.getPaymentSchema().getPaymentConditions().stream()
		        .map(
		                paymentConditions ->  CartWebPaymentsPaymentConditionsDtoV1.builder()
		                    .id(paymentConditions.getId())
		                        .name(paymentConditions.getName())
		                        .paymentMethodCode(paymentConditions.getPaymentMethodCode())
		                        .installments(paymentConditions.getInstallments())
		                .build()
		        ).collect(Collectors.toList());
		*/
		
		final List<DnaDtoV1> listaStream = 
				foundDnas.stream()
					.map(item -> 
					DnaDtoV1.builder().id(item.getId())
					.dna(item.getDna()).isSimian(item.getIsSimian()).
				)
		
		return DnaResponse.builder().dna(lista).build();
		
	}


	public StatsDtoV1 getStats() {
	
		final List<Dna> foundDnas= dnaRepository.findAll();

		Long totalDnas = foundDnas.stream().count();
		Long totalSimian = foundDnas.stream().filter(dnas -> dnas.getIsSimian().equals(Boolean.TRUE)).count();
		Long totalHuman = foundDnas.stream().filter(dnas -> dnas.getIsSimian().equals(Boolean.FALSE)).count();
		BigDecimal ratio = BigDecimal.valueOf(totalSimian).divide(BigDecimal.valueOf(totalHuman));
		LOGGER.info("count_mutant_dna [{}], count_human_dna[{}], ratio[{}], totalDnas[{}]", totalSimian, totalHuman, ratio, totalDnas);
		
		return StatsDtoV1.builder().countHumanDna(totalHuman)
				.countMutantDna(totalSimian)
				.ratio(ratio).build();
				
		
	}
	
	public DnaDtoV1 addDna(DnaHumanSimianDtoV1 dnaRequest) {
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
