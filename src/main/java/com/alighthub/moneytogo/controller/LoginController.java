package com.alighthub.moneytogo.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Login;
import com.alighthub.moneytogo.service.ServiceInterf;


@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {	
	
	@Autowired
	private ServiceInterf s;  	
  
	public static Logger logger = LogManager.getLogger(LoginController.class);	
	
	
	
	 @GetMapping("/logincheck/{username}/{password}") 
	 public Login  loggingUser(@PathVariable String username,@PathVariable String password) 
	 {
	 logger.info("logincheck called");
	 
	 System.out.println("   Username :"+username+" Password : "+password);
	 Login lu=s.loginCheck(username, password);
	 return lu;
	 }
	
	
	/*
	 * @GetMapping("/notToUseMe/{username}/{password}") public List<User>
	 * foolLogging(@PathVariable String username,@PathVariable String password) {
	 * System.out.println("   Username :"+username+" Password : "+password);
	 * List<User> lu=s.admincheck(username, password); return lu; }
	 */
	
	
	
	 

	
}
