package com.demo.fallback.SrpingFallBack.service;

import com.demo.fallback.SrpingFallBack.model.RefrigeratorItem;
import com.demo.fallback.SrpingFallBack.repository.RefrigeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    public RefrigeratorRepository repository;

    public RefrigeratorItem insertData(RefrigeratorItem refrigeratorItem) {

        return repository.insert(refrigeratorItem);
    }

    public List<RefrigeratorItem> getAllData() {
        return repository.findAll();
    }
}