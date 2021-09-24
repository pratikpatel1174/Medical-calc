package com.medical.calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medical_sub_category")
public class MedicalSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_category_id")
	private Long subCategoryId;
	@Column(name = "sub_category_name")
	private String subCategory;
	@Column(name = "sub_category_navigation")
	private String subCategoryNav;

	@Column(name = "category_id")
	private Long categoryId;

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryNav() {
		return subCategoryNav;
	}

	public void setSubCategoryNav(String subCategoryNav) {
		this.subCategoryNav = subCategoryNav;
	}

	@Override
	public String toString() {
		return "MedicalSubCategory [subCategoryId=" + subCategoryId + ", subCategory=" + subCategory
				+ ", subCategoryNav=" + subCategoryNav + ", categoryId=" + categoryId + "]";
	}

}
