package com.victor.simian.use_case;

import com.victor.simian.dto.DnaRequest;
import com.victor.simian.dto.StatsDtoV1;

import java.util.Optional;

public interface GetDnaStatsUseCase extends UseCase<StatsDtoV1, Optional<DnaRequest>> {

}
