package com.demo.fallback.SrpingFallBack.service;

import com.demo.fallback.SrpingFallBack.exceptions.MainframeException;
import com.demo.fallback.SrpingFallBack.model.CASASummary;
import com.demo.fallback.SrpingFallBack.model.CasaSummaryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasaSummaryMFService {

    public ResponseEntity<List<CASASummary>> getCasaSummaryDetails(CasaSummaryRequest casaSummaryRequest) throws Exception {

        CASASummary casaSummary = new CASASummary(123, "abc", 200, "MF");
        List<CASASummary> casaSummaryListResponse = new ArrayList<>();
        casaSummaryListResponse.add(casaSummary);
        throw new MainframeException();
        // return ResponseEntity.ok(casaSummaryListResponse);
    }

    public ResponseEntity<List<CASASummary>> getCasaSummaryDetailsData(CasaSummaryRequest casaSummaryRequest) throws Exception {

        CASASummary casaSummary = new CASASummary(123, "abc", 200, "MF");
        List<CASASummary> casaSummaryListResponse = new ArrayList<>();
        casaSummaryListResponse.add(casaSummary);
        //throw new MainframeException();
        return ResponseEntity.ok(casaSummaryListResponse);
    }
}
