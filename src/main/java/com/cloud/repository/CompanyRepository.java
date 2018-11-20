package com.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cloud.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{

}
