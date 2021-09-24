package com.medical.calculator.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medical.calculator.constant.CommonConstant;
import com.medical.calculator.dao.CategoryRepository;
import com.medical.calculator.dao.CustomerRepository;
import com.medical.calculator.dao.SubCategoryRepository;
import com.medical.calculator.model.CommonSubCategoryModel;
import com.medical.calculator.model.Customer;
import com.medical.calculator.model.MedicalCategory;
import com.medical.calculator.model.MedicalSubCategory;
import com.medical.calculator.util.FormulaUtil;

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
		List<MedicalCategory> categoryList = (List<MedicalCategory>) categoryRepo.findAll();
		System.out.println(categoryList);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("categoryList", categoryList);
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// customerService.save(customer);
		return "redirect:/";
	}

	@RequestMapping("/getSubCategory")
	public ModelAndView getSubCategory(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("subCategory");
		System.out.println("id ::::" + id);
		List<MedicalSubCategory> subCategoryList = subCategoryRepo.findByCategoryId(id);
		System.out.println(subCategoryList);

		mav.addObject("subCategoryList", subCategoryList);
		return mav;
	}

	@RequestMapping(value = "/subCategoryNav/{subCategoryId}", method = RequestMethod.GET)
	public ModelAndView Controller(@PathVariable("subCategoryId") Long subCategoryId) {
		System.out.println("subCategoryId " + subCategoryId);
		ModelAndView modelAndView = new ModelAndView("error");
		Optional<MedicalSubCategory> medicatCategoryOptional = subCategoryRepo.findById(subCategoryId);

		if (medicatCategoryOptional.isPresent()) {
			MedicalSubCategory medicalSubCategory = medicatCategoryOptional.get();
			if (CommonConstant.FALSE_POSITIVE_RATE.equalsIgnoreCase(medicalSubCategory.getSubCategory())) {
				String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+",
						"-");
				medicalSubCategory.setSubCategoryNav(subCategoryNavigation);
				subCategoryRepo.save(medicalSubCategory);
				System.out.println("subCategoryNavigation " + subCategoryNavigation);

				modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
				modelAndView.addObject("isSubCategoryResult", false);
				modelAndView.addObject("medicalSubCategory", medicalSubCategory);
				CommonSubCategoryModel commonSubCategoryModel = new CommonSubCategoryModel();
				modelAndView.addObject("subCatForm", commonSubCategoryModel);
				return modelAndView;
			}
			if(CommonConstant.FALSE_NEGATIVE_RATE.equalsIgnoreCase(medicalSubCategory.getSubCategory())) {
				String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+",
						"-");
				medicalSubCategory.setSubCategoryNav(subCategoryNavigation);
				subCategoryRepo.save(medicalSubCategory);
				System.out.println("subCategoryNavigation " + subCategoryNavigation);

				modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
				modelAndView.addObject("isSubCategoryResult", false);
				modelAndView.addObject("medicalSubCategory", medicalSubCategory);
				CommonSubCategoryModel commonSubCategoryModel = new CommonSubCategoryModel();
				modelAndView.addObject("subCatForm", commonSubCategoryModel);
				//return modelAndView;
			}
			if(CommonConstant.PREVALENCE_RATE.equalsIgnoreCase(medicalSubCategory.getSubCategory())) {
				String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+",
						"-");
				medicalSubCategory.setSubCategoryNav(subCategoryNavigation);
				subCategoryRepo.save(medicalSubCategory);
				System.out.println("subCategoryNavigation " + subCategoryNavigation);

				modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
				modelAndView.addObject("isSubCategoryResult", false);
				modelAndView.addObject("medicalSubCategory", medicalSubCategory);
				CommonSubCategoryModel commonSubCategoryModel = new CommonSubCategoryModel();
				modelAndView.addObject("subCatForm", commonSubCategoryModel);
				//return modelAndView;
			}
			if(CommonConstant.INCIDENCE_RATE.equalsIgnoreCase(medicalSubCategory.getSubCategory())) {
				String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+",
						"-");
				medicalSubCategory.setSubCategoryNav(subCategoryNavigation);
				subCategoryRepo.save(medicalSubCategory);
				System.out.println("subCategoryNavigation " + subCategoryNavigation);

				modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
				modelAndView.addObject("isSubCategoryResult", false);
				modelAndView.addObject("medicalSubCategory", medicalSubCategory);
				CommonSubCategoryModel commonSubCategoryModel = new CommonSubCategoryModel();
				modelAndView.addObject("subCatForm", commonSubCategoryModel);
				//return modelAndView;
			}
		}

		return modelAndView;
	}

	@RequestMapping(value = "/calculateFormula", method = RequestMethod.POST)
	public ModelAndView processRegistration(
			@ModelAttribute("subCatForm") CommonSubCategoryModel commonSubCategoryModel) {
		System.out.println("calling.... Calculate Formula");
		System.out.println("commonSubCategoryModel " + commonSubCategoryModel);
		Optional<MedicalSubCategory> medicatCategoryOptional = subCategoryRepo
				.findById(commonSubCategoryModel.getSubCategoryId());

		if (medicatCategoryOptional.isPresent()) {
			MedicalSubCategory medicalSubCategory = medicatCategoryOptional.get();
			String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+", "-");

			ModelAndView modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
			Map<String, BigDecimal> resultMap = FormulaUtil.getFalsePositiveRate(commonSubCategoryModel.getParam1(),
					commonSubCategoryModel.getParam2());

			System.out.println("falsePositiveRateResultMap " + resultMap);
			modelAndView.addObject("isSubCategoryResult", true);
			modelAndView.addObject("resultMap", resultMap);

			return modelAndView;
		}

		return null;
	}
	
	@RequestMapping(value = "/falseNegative", method = RequestMethod.POST)
	public ModelAndView falseNegative(
			@ModelAttribute("subCatForm") CommonSubCategoryModel commonSubCategoryModel) {
		System.out.println("calling.... Calculate Formula");
		System.out.println("commonSubCategoryModel " + commonSubCategoryModel);
		Optional<MedicalSubCategory> medicatCategoryOptional = subCategoryRepo
				.findById(commonSubCategoryModel.getSubCategoryId());

		if (medicatCategoryOptional.isPresent()) {
			MedicalSubCategory medicalSubCategory = medicatCategoryOptional.get();
			String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+", "-");

			ModelAndView modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
			Map<String, BigDecimal> resultMap = FormulaUtil.getFalseNegativeRate(commonSubCategoryModel.getParam1(),
					commonSubCategoryModel.getParam2());

			System.out.println("falseNegativeRateResultMap " + resultMap);
			modelAndView.addObject("isSubCategoryResult", true);
			modelAndView.addObject("resultMap", resultMap);

			return modelAndView;
		}
		

		return null;
	}
	@RequestMapping(value = "/prevalenceRate", method = RequestMethod.POST)
	public ModelAndView prevalenceRate(
			@ModelAttribute("subCatForm") CommonSubCategoryModel commonSubCategoryModel) {
		System.out.println("calling.... Calculate Formula");
		System.out.println("commonSubCategoryModel " + commonSubCategoryModel);
		Optional<MedicalSubCategory> medicatCategoryOptional = subCategoryRepo
				.findById(commonSubCategoryModel.getSubCategoryId());

		if (medicatCategoryOptional.isPresent()) {
			MedicalSubCategory medicalSubCategory = medicatCategoryOptional.get();
			String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+", "-");

			ModelAndView modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
			Map<String, BigDecimal> resultMap = FormulaUtil.getPrevelanceRate(commonSubCategoryModel.getParam1(),
					commonSubCategoryModel.getParam2());

			System.out.println("falseNegativeRateResultMap " + resultMap);
			modelAndView.addObject("isSubCategoryResult", true);
			modelAndView.addObject("resultMap", resultMap);

			return modelAndView;
		}
		

		return null;
	}
	
	@RequestMapping(value = "/incidenceRate", method = RequestMethod.POST)
	public ModelAndView incidenceRate(
			@ModelAttribute("subCatForm") CommonSubCategoryModel commonSubCategoryModel) {
		System.out.println("calling.... Calculate Formula");
		System.out.println("commonSubCategoryModel " + commonSubCategoryModel);
		Optional<MedicalSubCategory> medicatCategoryOptional = subCategoryRepo
				.findById(commonSubCategoryModel.getSubCategoryId());

		if (medicatCategoryOptional.isPresent()) {
			MedicalSubCategory medicalSubCategory = medicatCategoryOptional.get();
			String subCategoryNavigation = medicalSubCategory.getSubCategory().toLowerCase().replaceAll("\\s+", "-");

			ModelAndView modelAndView = new ModelAndView("sub-categories/" + subCategoryNavigation);
			Long valueofParam3;
			if(commonSubCategoryModel.getParam3_drop() == 1){valueofParam3 = commonSubCategoryModel.getParam3();}
			else {valueofParam3=commonSubCategoryModel.getParam3_drop();}
			if(valueofParam3 != null) {
			Map<String, BigDecimal> resultMap = FormulaUtil.getIncidenceRate(commonSubCategoryModel.getParam1(),
					commonSubCategoryModel.getParam2(),valueofParam3);
			
			System.out.println("falseNegativeRateResultMap " + resultMap);
			modelAndView.addObject("isSubCategoryResult", true);
			modelAndView.addObject("resultMap", resultMap);
			}else {
				System.out.println("Handle Error !!!!!!!!!!!!!!!!!!!!!!!");
			}
			return modelAndView;
		}
		

		return null;
	}


}
