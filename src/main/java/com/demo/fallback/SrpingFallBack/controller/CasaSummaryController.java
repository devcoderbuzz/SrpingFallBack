package com.demo.fallback.SrpingFallBack.controller;

import com.demo.fallback.SrpingFallBack.exceptions.CBException;
import com.demo.fallback.SrpingFallBack.exceptions.MainframeException;
import com.demo.fallback.SrpingFallBack.model.CASASummary;
import com.demo.fallback.SrpingFallBack.model.CasaSummaryRequest;
import com.demo.fallback.SrpingFallBack.service.CBCasaSummaryService;
import com.demo.fallback.SrpingFallBack.service.CasaSummaryMFService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CasaSummaryController {

    @Autowired
    public CasaSummaryMFService casaSummaryMFService;

    @Autowired
    public CBCasaSummaryService cbCasaSummaryService;


    @PostMapping("/getCasaSummary")
    @Retry(name = "retryApi", fallbackMethod = "getMFCasaSummaryDetailsFallBack")

    public ResponseEntity<List<CASASummary>> getCasaSummaryDetailsList(@RequestBody CasaSummaryRequest casaSummaryRequest) throws Exception {

        if ("MF".equals(casaSummaryRequest.getTargetSystem())) {

            return casaSummaryMFService.getCasaSummaryDetails(casaSummaryRequest);
        } else {
            return cbCasaSummaryService.getCasaSummaryDetails(casaSummaryRequest);
        }
    }


    public ResponseEntity<List<CASASummary>> getMFCasaSummaryDetailsFallBack(CasaSummaryRequest casaSummaryRequest, MainframeException ex) throws Exception {
        System.out.println(" in MF fail, call CB service");
        return cbCasaSummaryService.getCasaSummaryDetailsData(casaSummaryRequest);
    }


    public ResponseEntity<List<CASASummary>> getMFCasaSummaryDetailsFallBack(CasaSummaryRequest casaSummaryRequest, CBException ex) throws Exception {
        System.out.println(" in CB fail, call MF service");
        return casaSummaryMFService.getCasaSummaryDetailsData(casaSummaryRequest);
    }


}
