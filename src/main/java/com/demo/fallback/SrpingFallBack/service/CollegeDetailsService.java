package com.demo.fallback.SrpingFallBack.service;

import com.demo.fallback.SrpingFallBack.model.CollegeDetails;
import com.demo.fallback.SrpingFallBack.model.Student;
import com.demo.fallback.SrpingFallBack.repository.CollegeDetailsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.BSONObject;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

@Service
public class CollegeDetailsService {

    @Autowired
    private CollegeDetailsRepository collegeDetailsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public CollegeDetails createCollegeData(@RequestBody CollegeDetails collegeDetails) {

        return collegeDetailsRepository.save(collegeDetails);
    }

    public List<CollegeDetails> getAllCollegesData() {


        return collegeDetailsRepository.findAll();
    }

    public void deleteCompleteData() {
        collegeDetailsRepository.deleteAll();
    }

    public void addStudentsToCollege(Student student, String collegeName) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(student);


        BSONObject bson = BasicDBObject.parse(jsonData);
        DBObject listItem = new BasicDBObject("students", bson);
        Bson updateQuery = new BasicDBObject("$push", listItem);

        Bson filterDataCollegeName = eq("collegeName", collegeName);
        Bson filterDataStudentName = eq("students.studentName", student.getStudentName());
        Bson combinedFilter = Filters.and(filterDataCollegeName, filterDataStudentName);

        UpdateOptions options = new UpdateOptions()
                .arrayFilters(List.of(eq("ele.studentName", student.getStudentName()))).upsert(true);

        Bson update = set("students.$[ele]", bson);
        mongoTemplate.getCollection("collegeDetails").updateOne(filterDataCollegeName, update, options);
    }
}