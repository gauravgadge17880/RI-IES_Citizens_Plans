package com.Insurance.service;

import java.io.IOException;
import java.util.List;

import com.Insurance.binding.SearchCriteria;
import com.Insurance.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria);
	public void generateExcel(HttpServletResponse response)throws IOException;
	public void generatePdf(HttpServletResponse response)throws IOException;


}
