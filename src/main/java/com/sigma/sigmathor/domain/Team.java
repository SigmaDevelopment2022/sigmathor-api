package com.sigma.sigmathor.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Team {
    private long code;
    private String name;
}
