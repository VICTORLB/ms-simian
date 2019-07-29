package com.victor.simian.use_case.impl;

import com.victor.simian.business.DnaBO;
import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.dto.StatsDtoV1;
import com.victor.simian.model.Dna;
import com.victor.simian.repository.DnaRepository;
import com.victor.simian.use_case.GetDnaStatsUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class GetDnaStatsUseCaseBase implements GetDnaStatsUseCase {

    private final Logger LOGGER;

    private static final String DNA_PREFIX = "[DNA-IDENTIFIER]";

    private final DnaBO dnaBO;

    @Override
    public StatsDtoV1 execute(StatsDtoV1 statsDtoV1){

        final StatsDtoV1 statsDtoV11 = dnaBO.getStats();

        LOGGER.info("{} Stats of Dna by UseCase " , DNA_PREFIX);
        if (statsDtoV11 == null) {
            LOGGER.info("{} List of Dna not found...", DNA_PREFIX);
            return StatsDtoV1.builder().build();
        }
        return statsDtoV11;

    }


}
