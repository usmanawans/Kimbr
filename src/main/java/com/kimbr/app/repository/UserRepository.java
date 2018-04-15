package com.kimbr.app.repository;

import com.kimbr.app.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract interface UserRepository extends MongoRepository<User, String> {



}
