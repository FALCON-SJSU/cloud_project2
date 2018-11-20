package com.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cloud.model.User;

@Repository
public interface SignUpRepository extends JpaRepository<User,Integer> {

	
}
