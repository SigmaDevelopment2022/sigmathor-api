package com.sigma.sigmathor.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long code;
    private String name;
    private String city;
    private Team team;
    private Goal goalToday;
    private Goal goalMonth;
    private Sell soldToday;
    private Sell soldMonth;
    private Balance creditLimit;
    private Balance creditLast;
}
