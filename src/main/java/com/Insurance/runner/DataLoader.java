package com.Insurance.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Insurance.entity.CitizenPlan;
import com.Insurance.repo.CitizenRepo;

@Component
public class DataLoader implements ApplicationRunner{
	
	
	// when applcation is start the run method execute code only onces
	@Autowired
	private CitizenRepo citizenRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		citizenRepo.deleteAll();
		
	CitizenPlan c1 = new CitizenPlan("gaurav","gauravgadge@gmail.com",956587458,"Male",5484,"health","approved",LocalDate.now(),LocalDate.now().plusMonths(6));

		CitizenPlan c2 = new CitizenPlan("Harshal", "harshal@gmail.com", 546845856,"Male", 56548,"lifeInsurance",
				"Denied", LocalDate.now(), LocalDate.now().plusMonths(6));
			
		CitizenPlan c3 = new CitizenPlan("krishu", "krishu@gmail.com", 546845856,"Fe-Male", 56548,"baby Insurance",
				"approved", LocalDate.now(), LocalDate.now().plusMonths(6));
			
	
		CitizenPlan c4 = new CitizenPlan("sai", "sai@gmail.com", 546845856,"Male", 56548,"Auto Insurance",
				"Denied", LocalDate.now(), LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c5 = new CitizenPlan("Gajanan", "Gajanan@gmail.com", 546845856,"Male", 56548,"Life Insurance",
				"approved", LocalDate.now(), LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c6 = new CitizenPlan("Durga", "Durga@gmail.com", 546845856,"Fe-Male", 56548,"Auto Insurance",
				"approved", LocalDate.now(), LocalDate.now().plusMonths(6));
		
		
	
	List<CitizenPlan> reports = Arrays.asList(c1,c2,c3,c4,c5,c6);
		citizenRepo.saveAll(reports);
	}
	
	

}
