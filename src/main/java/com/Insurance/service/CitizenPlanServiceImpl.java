package com.Insurance.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Insurance.binding.SearchCriteria;
import com.Insurance.entity.CitizenPlan;
import com.Insurance.repo.CitizenRepo;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService {
	
	@Autowired
	private CitizenRepo citizenRepo;

	@Override
	public List<String> getPlanNames() {
	
		return citizenRepo.getUniquePlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return citizenRepo.getUniquePlanStatus();
	}

	@Override
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria) {
		CitizenPlan entity = new CitizenPlan();
		if(StringUtils.isNotBlank(criteria.getPlanName()))
		{
			entity.setPlanName(criteria.getPlanName());
		}
		if(StringUtils.isNotBlank(criteria.getPlanStatus()))
		{
			entity.setPlanName(criteria.getPlanStatus());
		}
		if(StringUtils.isNotBlank(criteria.getGender()))
		{
			entity.setPlanName(criteria.getGender());
		}
		
		//QBE  (Query by Example)
		Example<CitizenPlan> of = Example.of(entity);
		return citizenRepo.findAll(of);
	}

	@Override
	public void generateExcel(HttpServletResponse response) throws IOException {

			List<CitizenPlan> info = citizenRepo.findAll();
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			HSSFSheet sheet = workbook.createSheet("Citizen Data");
			HSSFRow headerRow = sheet.createRow(0);
			
			headerRow.createCell(0).setCellValue("Name");
			headerRow.createCell(1).setCellValue("Gender");
			headerRow.createCell(2).setCellValue("Plan Name");
			headerRow.createCell(3).setCellValue("SSN");
			headerRow.createCell(4).setCellValue("Phone Number");

			int row = 1;
			
			for (CitizenPlan record : info) {
				HSSFRow dataRow = sheet.createRow(row);
				dataRow.createCell(0).setCellValue(record.getName());
				dataRow.createCell(1).setCellValue(record.getGender());
				dataRow.createCell(2).setCellValue(record.getPlanName());
				dataRow.createCell(3).setCellValue(record.getSsn());
				dataRow.createCell(4).setCellValue(record.getPhNo());
				
				row ++;
				
			}
			
			ServletOutputStream outputStream = response.getOutputStream();
			
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
	}
	
	
	public void generatePdf(HttpServletResponse response) {
		List<CitizenPlan> info = citizenRepo.findAll();
		 
	}

}
