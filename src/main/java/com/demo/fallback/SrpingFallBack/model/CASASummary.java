package com.demo.fallback.SrpingFallBack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CASASummary {

    private int accountNum;
    private String accountName;
    private int accountBalance;
    private String dataSource;
}
