package com.tweetapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.tweetapp.entity.UserRegistration;
import com.tweetapp.exception.UserNotFoundException;

/*
 * Repository for registering a user
 */
@Repository
public interface UserRegistrationRepository extends MongoRepository<UserRegistration, String>{
 public UserRegistration findByLoginId(String username);
 public UserRegistration findByLoginIdAndEmail(String username,String email);
public boolean existsByLoginIdAndPassword(String loginId, String password);
public boolean existsByLoginId(String loginId);
 
}
