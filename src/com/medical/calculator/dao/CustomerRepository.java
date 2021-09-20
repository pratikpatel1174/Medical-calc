package com.medical.calculator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.calculator.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	
}
