package com.demo.fallback.SrpingFallBack.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CasaSummaryRequest {

    private String accountNumber;
    private String prodCode;
    private String targetSystem;

}
