package com.demo.fallback.SrpingFallBack.controller;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String getStudentMainFromMainDB() throws Exception {


        throw new Exception();

    }

    public String getStudentDFromAlternateDB() {
        return "hello from sub DB";
    }
}
