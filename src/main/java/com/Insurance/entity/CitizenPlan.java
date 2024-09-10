package com.Insurance.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private Integer phNo;
	
	private String gender;
	
	private Integer ssn;
	
	private String planName;
	
	private String planStatus;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate planStartDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate planEndDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate updateDate;

	public CitizenPlan(String name, String email, Integer phNo, String gender, Integer ssn, String planName,
			String planStatus, LocalDate planStartDate, LocalDate planEndDate) {
		super();
		this.name = name;
		this.email = email;
		this.phNo = phNo;
		this.gender = gender;
		this.ssn = ssn;
		this.planName = planName;
		this.planStatus = planStatus;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
	}

	public CitizenPlan() {
		super();
	}

	
	
	
	
	

}
