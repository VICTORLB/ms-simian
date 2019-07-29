package com.victor.simian.use_case.impl;

import com.victor.simian.dto.DnaDtoV1;
import com.victor.simian.dto.DnaResponse;
import com.victor.simian.model.Dna;
import com.victor.simian.repository.DnaRepository;
import com.victor.simian.use_case.GetDnaUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class GetDnaUseCaseBase implements GetDnaUseCase {

    private final Logger LOGGER;

    private static final String DNA_PREFIX = "[DNA-IDENTIFIER]";

    private final DnaRepository dnaRepository;

    @Override
    public DnaResponse execute(@NotNull DnaResponse dnaResponse){

        final List<Dna> foundDnas = dnaRepository.findAll();


        if (foundDnas == null) {
            LOGGER.info("{} List of Dna not found...", DNA_PREFIX);
            return DnaResponse.builder().build();
        }
        return DnaResponse.builder().dna(foundDnas.stream().map(
                item -> DnaDtoV1.builder().id(item.getId()).dna(item.getDna()).isSimian(item.getIsSimian()).build())
                .collect(Collectors.toList())).build();

    }

}
