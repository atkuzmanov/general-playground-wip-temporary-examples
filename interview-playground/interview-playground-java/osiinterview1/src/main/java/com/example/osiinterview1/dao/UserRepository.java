package com.example.osiinterview1.dao;

import com.example.osiinterview1.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}