package com.demo.fallback.SrpingFallBack.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDetails {

    @Id
    private String id;
    private String collegeName;
    private String principalName;
    private String cityName;
    private List<Student> students;
}