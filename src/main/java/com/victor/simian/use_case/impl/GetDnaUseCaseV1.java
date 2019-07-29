package com.victor.simian.use_case.impl;

import com.victor.simian.repository.DnaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Transactional
public class GetDnaUseCaseV1 extends GetDnaUseCaseBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetDnaUseCaseV1.class);


    public GetDnaUseCaseV1(final DnaRepository dnaRepository) {
        super(LOGGER, dnaRepository);
    }
}
