package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.model.Company;
import com.cloud.model.User;
import com.cloud.service.AmazonClientService;
import com.cloud.service.CompanyService;
import com.cloud.service.SignUpService;
import com.cloud.controller.IdTokenVerifierAndParser;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

@Controller
public class HomeController {
	
	
	@Autowired
	private AmazonClientService amazonClientService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	HomeController(AmazonClientService amazonClientService) {
		this.amazonClientService = amazonClientService;
	}
	
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/companyPage")
	public String companyPage()
	{
		return "companyPage";
	}
	
	//@Author Saylee *************
	@GetMapping("/loginPage")
	public String loginPage()
	{
		return"loginPage";
	}
	
	@GetMapping("/userSignup")
	public String userSignup()
	{
		return"userSignup";
	}
	
	@RequestMapping(value = "/glogin", method = RequestMethod.GET)
	public String googlePage(){
		return"googlePage";
	}
	
	
	
	@RequestMapping(value = "/glogin", method = RequestMethod.POST)
	public String validatewithgoogle(@RequestParam("id_token") String id_token,ModelMap model, HttpSession session) {
		
		String email="";
		String name ="";
		try {
	            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(id_token);
	            
	             name = (String) payLoad.get("name");
	            email = payLoad.getEmail();
	           // System.out.println("User name: " + name);
	          //  System.out.println("User email: " + email);
	           session.setAttribute("userName", name);
	            session.setAttribute("id_token", id_token);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		User user = new User();
		user.setUseremailid(email);
		user.setUserfirstname(name);
		
		//.setRole("user");
		if (user == null) {
			model.addAttribute("loginError", "Sorry, user is not validated properly");
			return "redirect:/loginPage";
		}
		signUpService.adduser(user);
	    session.setAttribute("loggedUser", user);
		return "redirect:/companyPage";
	}

	
	
	@PostMapping("/adduser")
	public String adduser(@RequestParam("fname")String fname, @RequestParam("lname")String lname,
			@RequestParam("email")String email, @RequestParam("pwd")String pwd,  HttpSession session ){
		
		User user =new User();
		user.setUserfirstname(fname);
		user.setUserlastname(lname);
		user.setUseremailid(email);
		user.setUserpassword(pwd);
		
		signUpService.adduser(user);
		session.setAttribute("loggedUser", user);
		return "redirect:/loginPage";
	}
	
	/*	
	@PostMapping("/customlogin")
	public String customlogin(@RequestParam("email")String email, @RequestParam("pwd")String pwd, ModelMap model, HttpSession session){
		
		User user = new User();
		//user.setUseremailid(email);
		//user.setUserpassword(pwd);
		user= signUpService.customlogin(email,pwd);
		if (user == null) {
			model.addAttribute("loginError", "Sorry, user is not present please sign up");
			//return "redirect:/login";
		}
		session.setAttribute("loggedUser", user);
		
		
		return "redirect:/companyPage";
	}
	
	*/
	//**********************************
	

	
	@PostMapping("/addCompany")
	public String addCompany(@RequestParam("email") String email,
			@RequestParam("pwd") String pwd, @RequestParam("cname") String cname)
	{
		Company comp = new Company();
		comp.setCompName(cname);
		comp.setCompUsername(email);
		comp.setCompPassword(pwd);
		
		companyService.addCompany(comp);
		
		return "redirect:/companyPage";
		
	}
	
	
	@PostMapping("/uploadFiletoS3")
	public String uploadFiletoS3(@RequestPart(value = "file") MultipartFile file) {
	
		
		this.amazonClientService.uploadFiletoS3(file);
		return "redirect:/home";
	}
	

}                    
