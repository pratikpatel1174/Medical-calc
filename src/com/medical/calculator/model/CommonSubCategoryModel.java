package com.medical.calculator.model;

public class CommonSubCategoryModel {

	private Long param1;
	private String param1_drop;
	private Long param2;
	private String param2_drop;
	private Long param3_drop;
	private Long param3;
	private Long subCategoryId;
	private String subCategoryName;

	public Long getParam1() {
		return param1;
	}

	public void setParam1(Long param1) {
		this.param1 = param1;
	}

	public String getParam1_drop() {
		return param1_drop;
	}

	public void setParam1_drop(String param1_drop) {
		this.param1_drop = param1_drop;
	}

	public Long getParam2() {
		return param2;
	}

	public void setParam2(Long param2) {
		this.param2 = param2;
	}

	public String getParam2_drop() {
		return param2_drop;
	}

	public void setParam2_drop(String param2_drop) {
		this.param2_drop = param2_drop;
	}

	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Long getParam3_drop() {
		return param3_drop;
	}

	public void setParam3_drop(Long param3_drop) {
		this.param3_drop = param3_drop;
	}

	public Long getParam3() {
		return param3;
	}

	public void setParam3(Long param3) {
		this.param3 = param3;
	}

	@Override
	public String toString() {
		return "CommonSubCategoryModel [param1=" + param1 + ", param1_drop=" + param1_drop + ", param2=" + param2
				+ ", param2_drop=" + param2_drop + ", param3_drop=" + param3_drop + ", param3=" + param3
				+ ", subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + "]";
	}

	

}
