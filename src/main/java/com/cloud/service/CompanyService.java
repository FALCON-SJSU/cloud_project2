package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.model.Company;
import com.cloud.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository  companyRepository;
	
	public void addCompany(Company comp)
	{
		//System.out.println("Hey I'm in the service layer");
	//	System.out.print(comp);
		companyRepository.save(comp);
	}
	
	
	

}
