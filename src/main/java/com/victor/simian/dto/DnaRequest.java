package com.victor.simian.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DnaRequest {

    public static final String ID = "id";
    @JsonProperty(ID)
    private final Long id = null;

}
