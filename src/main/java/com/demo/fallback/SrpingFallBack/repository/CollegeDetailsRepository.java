package com.demo.fallback.SrpingFallBack.repository;


import com.demo.fallback.SrpingFallBack.model.CollegeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "fridge", path = "fridge")
public interface CollegeDetailsRepository extends MongoRepository<CollegeDetails, String> {
}