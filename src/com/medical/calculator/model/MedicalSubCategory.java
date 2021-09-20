package com.medical.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medical_sub_category")
public class MedicalSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_category_id")
	private Long subCategoryId;
	@Column(name = "sub_category_name")
	private String subCategory;

	@Column(name = "category_id")
	private Long categoryId;
}
