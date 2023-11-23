package com.example.demo.User;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	List<User> findAllByStatus(Status status);
}
