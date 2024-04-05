package com.demo.fallback.SrpingFallBack.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentDetails")
    @Retry(name = "retryApi", fallbackMethod = "getStudentDetailsSubDB")
    public String getStudentDetails() throws Exception {
        return studentService.getStudentMainFromMainDB();
    }


    public String getStudentDetailsSubDB(Exception ex) {
        return studentService.getStudentDFromAlternateDB();
    }
}
