package com.medical.calculator.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.calculator.model.MedicalSubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<MedicalSubCategory, Long> {

	List<MedicalSubCategory> findByCategoryId(long id);
}
