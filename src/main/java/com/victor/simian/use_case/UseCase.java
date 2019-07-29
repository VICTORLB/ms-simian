package com.victor.simian.use_case;


import javax.validation.constraints.NotNull;

public interface UseCase<Output, Input> {

    @NotNull Output execute(@NotNull Input input);
}
