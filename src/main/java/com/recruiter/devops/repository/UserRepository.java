package com.recruiter.devops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.recruiter.devops.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
