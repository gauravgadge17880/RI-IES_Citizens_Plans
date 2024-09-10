package com.Insurance.binding;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	
	private String planName;
	
	private String planStatus;
	
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate planeStartDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate PlaneEndDate;
	

}
