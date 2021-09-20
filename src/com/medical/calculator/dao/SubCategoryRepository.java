package com.medical.calculator.dao;

import org.springframework.data.repository.CrudRepository;

import com.medical.calculator.model.MedicalSubCategory;

public interface SubCategoryRepository extends CrudRepository<MedicalSubCategory, Long> {

}
