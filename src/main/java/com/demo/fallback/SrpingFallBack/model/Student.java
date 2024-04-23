package com.demo.fallback.SrpingFallBack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    private String id;
    private String studentName;
    private int age;
    private String address;
    private String className;
    private String collegeName;
}