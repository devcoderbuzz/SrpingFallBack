package com.demo.fallback.SrpingFallBack.controller;


import com.demo.fallback.SrpingFallBack.model.RefrigeratorItem;
import com.demo.fallback.SrpingFallBack.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoController {

    @Autowired
    public MongoService mongoService;

    @PostMapping("/createData")
    public ResponseEntity<RefrigeratorItem> insertData(@RequestBody RefrigeratorItem refrigeratorItem) {

        RefrigeratorItem refrigeratorItem1 = mongoService.insertData(refrigeratorItem);
        return ResponseEntity.ok(refrigeratorItem1);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<RefrigeratorItem>> getAllData() {
        List<RefrigeratorItem> allData = mongoService.getAllData();
        return ResponseEntity.ok(allData);
    }
}