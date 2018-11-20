package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.model.User;
import com.cloud.repository.SignUpRepository;


@Service
public class SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepository ;
	
	public void adduser(User user){
	//System.out.print(user);
		signUpRepository.save(user);
		}
	
	
//	public User findUserByEmail(String email)
	//{
		
	//	User user = signUpRepository.findUserByEmail(email);
	//	return user;
	//}
	
	
	

	//public User customlogin(String email ,String pwd) {
		
	//	User user = dbRepository.getUserInfo(username, password);
	//	return user;
	//}

}
