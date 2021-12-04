package com.recruiter.devops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recruiter.devops.model.User;

public interface UserRepository extends MongoRepository<User, Long> {

}
