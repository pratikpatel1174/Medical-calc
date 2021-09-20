package com.medical.calculator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medical.calculator.dao.CategoryRepository;
import com.medical.calculator.dao.CustomerRepository;
import com.medical.calculator.model.Customer;
import com.medical.calculator.model.MedicalCategory;

@Controller
public class CustomerController {

	@Autowired 
	CustomerRepository repo;
	
	@Autowired 
	CategoryRepository categoryRepo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Customer> listCustomer = new ArrayList<Customer>();
		List<MedicalCategory> categoryList=(List<MedicalCategory>) categoryRepo.findAll();
		System.out.println(categoryList);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}		
}
