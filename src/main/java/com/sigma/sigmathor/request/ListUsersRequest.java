package com.sigma.sigmathor.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListUsersRequest {
    private String todayDate;
    private String initialDate;
    private String finalDate;
}
