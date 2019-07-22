package com.victor.simian.businessimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victor.simian.business.DnaBO;
import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaHumanSimianDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;
import com.victor.simian.model.Dna;
import com.victor.simian.repository.DnaRepository;
import com.victor.simian.util.DnaUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DnaBOImpl implements DnaBO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DnaBOImpl.class);

	private static final String DNA_PREFIX = "[DNA-IDENTIFIER]";

	private DnaRepository dnaRepository;

	public DnaResponse getDnas() {
		LOGGER.info("{} Retrieve list of Dna", DNA_PREFIX);
		final List<Dna> foundDnas = dnaRepository.findAll();


		if (foundDnas == null) {
			LOGGER.info("{} List of Dna not found...", DNA_PREFIX);
			return DnaResponse.builder().build();
		}
		return DnaResponse.builder().dna(foundDnas.stream().map(
				item -> DnaDtoV1.builder().id(item.getId()).dna(item.getDna()).isSimian(item.getIsSimian()).build())
				.collect(Collectors.toList())).build();

	}

	public StatsDtoV1 getStats() {
		LOGGER.info("{} Stats of Dna", DNA_PREFIX);
		final List<Dna> foundDnas = dnaRepository.findAll();

		long count = 0L;
		for (Dna ignored : foundDnas) count++;
		Long totalDnas = count;

		Long totalSimian = foundDnas.stream()
				.filter(
						dnas ->
								dnas.getIsSimian().equals(Boolean.TRUE)
				).count();

		Long totalHuman = foundDnas.stream()
				.filter(
						dnas ->
								dnas.getIsSimian().equals(Boolean.FALSE)
				).count();


		BigDecimal ratio = BigDecimal.valueOf(totalSimian).divide(BigDecimal.valueOf(totalHuman), 2, RoundingMode.UP);


		LOGGER.info("{} count_mutant_dna [{}], count_human_dna[{}], ratio[{}], totalDnas[{}]",
				DNA_PREFIX,
				totalSimian,
				totalHuman,
				ratio,
				totalDnas
		);

		return StatsDtoV1.builder().countHumanDna(totalHuman).countMutantDna(totalSimian).ratio(ratio).build();

	}

	public DnaDtoV1 addDna(DnaHumanSimianDtoV1 dnaRequest) throws Exception {

		try {

			Dna dna = dnaRepository.findByDna(Arrays.toString(dnaRequest.getDna()));
			if (dna == null){
				Dna dnaSaved = dnaRepository.saveAndFlush(Dna.builder().dna(Arrays.toString(dnaRequest.getDna()))
						.isSimian(DnaUtil.isSimian(dnaRequest.getDna())).build());

				return DnaDtoV1.builder().dna(dnaSaved.getDna()).id(dnaSaved.getId()).isSimian(dnaSaved.getIsSimian()).build();
			}


		}catch (Exception ex){
			throw new Exception( ex.getMessage());
		}
		LOGGER.info("{} DNA [{}] already exists!", DNA_PREFIX, Arrays.toString(dnaRequest.getDna()));
		return DnaDtoV1.builder().build();

	}

}
