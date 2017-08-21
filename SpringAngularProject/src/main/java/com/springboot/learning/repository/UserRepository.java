package com.springboot.learning.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.springboot.learning.model.User;

public interface UserRepository extends CrudRepository<User, Serializable> {

}
