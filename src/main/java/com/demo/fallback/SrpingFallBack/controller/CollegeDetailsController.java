package com.demo.fallback.SrpingFallBack.controller;

import com.demo.fallback.SrpingFallBack.model.CollegeDetails;
import com.demo.fallback.SrpingFallBack.model.Student;
import com.demo.fallback.SrpingFallBack.service.CollegeDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollegeDetailsController {

    @Autowired
    private CollegeDetailsService collegeDetailsService;

    @PostMapping("/college/createCollege")
    public ResponseEntity<CollegeDetails> insertData(@RequestBody CollegeDetails collegeDetails) {

        CollegeDetails collegeData = collegeDetailsService.createCollegeData(collegeDetails);
        return ResponseEntity.ok(collegeDetails);
    }

    @GetMapping("/college/deleteAllData")
    public ResponseEntity deleteCompleteData() {

        collegeDetailsService.deleteCompleteData();
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/college/getAllColleges")
    public ResponseEntity<List<CollegeDetails>> getAllColleges() {
        List<CollegeDetails> allCollegesData = collegeDetailsService.getAllCollegesData();
        return ResponseEntity.ok(allCollegesData);
    }

    @PostMapping("/college/addStudent")
    public ResponseEntity createStudentDetails(@RequestBody Student student) throws JsonProcessingException {
        collegeDetailsService.addStudentsToCollege(student, student.getCollegeName());
        return ResponseEntity.ok("Success");
    }
}