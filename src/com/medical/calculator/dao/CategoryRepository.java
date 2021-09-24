package com.medical.calculator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.calculator.model.Customer;
import com.medical.calculator.model.MedicalCategory;

@Repository
public interface CategoryRepository extends CrudRepository<MedicalCategory, Long> {

}
