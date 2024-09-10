package com.Insurance.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Insurance.binding.SearchCriteria;
import com.Insurance.entity.CitizenPlan;
import com.Insurance.service.CitizenPlanService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenPlanController {
	
	@Autowired
	private CitizenPlanService citizenPlanService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<String> planName = citizenPlanService.getPlanNames();
		List<String> planStatus= citizenPlanService.getPlanStatus();
		 
		
		model.addAttribute("planNameList",planName);
		model.addAttribute("planStatusList",planStatus);
		
		model.addAttribute("search", new SearchCriteria());
		
		return "index";
	}
	
	private void formInit(Model model) {
		List<String> planName = citizenPlanService.getPlanNames();
		List<String> planStatus= citizenPlanService.getPlanStatus();
		 
		
		model.addAttribute("planNameList",planName);
		model.addAttribute("planStatusList",planStatus);
		
	}
	
	@PostMapping("/filter-data")
	public String handleSearchMapping(@ModelAttribute("search") SearchCriteria criteria, Model model) {
		System.out.println(criteria);
		List<CitizenPlan> info=citizenPlanService.searchCitizens(criteria);
		
		model.addAttribute("citizens",info);
		
		formInit(model);
		
		return "index";
	}
	
	@GetMapping("/excel")
	public void downloadExcelSheet(HttpServletResponse response) throws IOException{
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		
		String headerValue = "attachment;filename=data.xls";
		response.addHeader(headerKey, headerValue);
		citizenPlanService.generateExcel(response);
	}

}
