package com.example.tempmon.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.tempmon.dao.Temperature;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Temperature, Integer> {

}
