package com.medical.calculator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.calculator.model.MedicalSubCategory;

@Repository
public interface SubCategoryRepository extends CrudRepository<MedicalSubCategory, Long> {

}
