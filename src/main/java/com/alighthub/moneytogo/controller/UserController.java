package com.alighthub.moneytogo.controller;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Loan;
import com.alighthub.moneytogo.model.LoanManagement;
import com.alighthub.moneytogo.model.User;
import com.alighthub.moneytogo.service.ServiceInterf;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private JavaMailSender javaMailSender;	
	
	@Autowired
	private ServiceInterf s;  
  
	public static Logger logger = LogManager.getLogger(UserController.class);	
	
	 @PostMapping("/useradd")
	 public int addingUser(@RequestBody User user) {	  
	  logger.info("controller called");	  
	  try { 
		  	
		  	 SimpleMailMessage msg = new SimpleMailMessage(); 	  
			 msg.setTo(user.getEmail());			 
			 msg.setSubject("thank you for using our services"+"  "+user.getFirstname());
			 msg.setText("User Name is"+user.getLogin().getUsername());
			 msg.setText("your password is "+user.getLogin().getPassword());
			 msg.getSentDate(); 
			 String passUrl = "http://localhost:4200/";	
			 System.out.println("hey"); 
			 javaMailSender.send(msg);	  
	  
	     } 
	  catch (Exception e) 
	  {
		  e.printStackTrace(); 
	  } 
	  return s.addUser(user);	  
	  }	 
	 
	 
		@GetMapping("/getUseralldata")
		public List<User> getUsers()
		{
			
			return s.getAllUserData();
		}
		
		@GetMapping("getUser/{userid}")
		public User getUser(@PathVariable int userid)
		{
			return s.getSingleUser(userid);
		}		
		
		
		  @GetMapping("/{userid}")
		  public User getUserforLoan(@PathVariable int userid)
		  {
			 User u= s.getLoanUser(userid);
			 return u;
		  }		  
		
		  @PostMapping("/loanadd")
		  public User addLoan(@RequestBody User user)
		  {
		   System.out.println(user); 
		  return s.postLoanApplication(user);
		  }
		  
		  
	 
		  @GetMapping("/status/{userstatus}")
		  public List<User> getStatus(@PathVariable String userstatus)
		  {
			  List<User> us = s.getUserByStatus(userstatus);
			  return us;
		  }
		  
		  
		  
		  @GetMapping("/userloan/{empid}")
		  public List<User> getuserForLoan(@PathVariable int empid)
		  {
			  List<User> us = s.getUserForApplyingLoan(empid);
			  return us;
		  }
		  
		  
		  
	/*
	 * @GetMapping("/empupdating/{userid}") public User getUsertoEdit(@PathVariable
	 * int userid) { User u= s.getempAdded(userid); return u; }
	 */
		  
	/*
	 * @PostMapping("empupdating/empup") public User empadd(@RequestBody User user)
	 * { System.out.println(user); return s.employeeUp(user); }
	 */  
		  
		  @GetMapping("bb/{userid}")
		  public User getb(@PathVariable int userid)
		  {
			 User u= s.getbu(userid);
			 return u;
		  }	
		  
		  
		  
		  @GetMapping("/getuserlogin/{loginId}") 
		  public User getUserforProfile(@PathVariable int loginId) {
		  logger.info("getUserforProfile called");
		  	 
		  	 User a=s.getuserProfile(loginId);
		  	 System.out.println(a);
		  	 return a;
		  	 }
		 
		 
		@PostMapping("/employee/users/{empid}")
		public User getUserAdded(@RequestBody User user)
		{
			return s.letUserCreated(user);
		}
		  
	}
