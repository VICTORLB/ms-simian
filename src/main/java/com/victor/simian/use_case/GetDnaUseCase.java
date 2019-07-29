package com.victor.simian.use_case;

import com.victor.simian.dto.DnaRequest;
import com.victor.simian.dto.DnaResponse;

import java.util.Optional;

public interface GetDnaUseCase extends UseCase<DnaResponse, Optional<DnaRequest>>{

}
