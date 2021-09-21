package com.medical.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medical.calculator.dao.CategoryRepository;
import com.medical.calculator.dao.CustomerRepository;
import com.medical.calculator.dao.SubCategoryRepository;
import com.medical.calculator.model.Customer;
import com.medical.calculator.model.MedicalCategory;
import com.medical.calculator.model.MedicalSubCategory;

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
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		//customerService.save(customer);
		return "redirect:/";
	}
	
	@RequestMapping("/getSubCategory")
	public ModelAndView getSubCategory(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("subCategory");
		System.out.println("id ::::"+id);
		List<MedicalSubCategory> subCategoryList= subCategoryRepo.findByCategoryId(id);
		System.out.println(subCategoryList);
		
		mav.addObject("subCategoryList", subCategoryList);	
		return mav;
	}		
}
