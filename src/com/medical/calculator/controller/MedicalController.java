package com.medical.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medical.calculator.dao.CategoryRepository;
import com.medical.calculator.dao.CustomerRepository;
import com.medical.calculator.dao.SubCategoryRepository;
import com.medical.calculator.model.MedicalCategory;

@Controller
public class MedicalController {

	@Autowired 
	CustomerRepository repo;
	
	@Autowired 
	CategoryRepository categoryRepo;
	
	@Autowired 
	SubCategoryRepository subCategoryRepo;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<MedicalCategory> categoryList=(List<MedicalCategory>) categoryRepo.findAll();
		System.out.println(categoryList);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("categoryList", categoryList);
		return mav;
	}		
}
