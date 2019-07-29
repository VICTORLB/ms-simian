package com.victor.simian.use_case.impl;

import com.victor.simian.business.DnaBO;
import com.victor.simian.repository.DnaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class GetDnaStatsUseCaseV1 extends GetDnaStatsUseCaseBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetDnaStatsUseCaseV1.class);

    public GetDnaStatsUseCaseV1(final DnaBO dnaBO) {
        super(LOGGER, dnaBO);
    }
}
