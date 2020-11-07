package com.alighthub.moneytogo.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.LoanManagement;
import com.alighthub.moneytogo.model.User;
import com.alighthub.moneytogo.service.ServiceInterf;


/**
 * @author Pallavi
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
    private JavaMailSender javaMailSender;	
	
	
	@Autowired
	private ServiceInterf s;    
	public static Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@PostMapping("/empadd")
	public int addingUser(@RequestBody Employee employee)
	{
		
		logger.info("controller called");
	
try {
	SimpleMailMessage msg = new SimpleMailMessage();
        	  // StringBuilder htmlBuilder = new StringBuilder();
        	  		

               msg.setTo(employee.getEmail());

               msg.setSubject("thank you for using our services"+"  "+employee.getEmpfirstname());
               msg.setText("User Name is"+employee.getLogin().getUsername());
               msg.setText("your password is "+employee.getLogin().getPassword());
               msg.getSentDate();
               String passUrl = "http://localhost:4200/";

   			
            //   htmlBuilder.append("<a herf='http://localhost:9997/changePassword<?=email?>'>change password</a>");
               msg.setText("click here to visit our site :"+passUrl);
               System.out.println("hey");
               
              
          

        } catch (Exception e) {
            e.printStackTrace();
        } 
		return s.addEmployee(employee);
	
		
	}
	
	
	@GetMapping("/getemployeealldata/{type}")
	public List<Employee> getEmployees(@PathVariable String type)
	{
		
		return s.getAllEmployeeData(type);
	}
	
	

@GetMapping("/{id}") 
public Employee getADmin(@PathVariable int id) {
logger.info("getAdmin called");
	 
	 System.out.println("Id selected  :"+id);
	 Employee a=s.getAdmin(id);
	 System.out.println(a);
	 return a;
	 }
	 
	 
		@DeleteMapping("/{empid}")
	    public List<Employee> deleting(@PathVariable int empid)
	    {
	   	 return s.deleteEmployee(empid);
	    }
		
		
		
	
	  @GetMapping("/up/{empid}") public Employee getUser(@PathVariable int empid) {
	  return s.getEdit(empid); }
	 
		
		@PutMapping("/up")
		public List<Employee> updating(@RequestBody Employee user)
		{
			return s.updating(user);
			
		}
		
		@GetMapping("/count")
		public long getCount()
		{
			return s.countEmployee();
		}
		
		
		@PostMapping("/addloanmaster")
		public int addingLoanMaster(@RequestBody LoanManagement loanm)
		{
			logger.info("loan master called");
			return s.addLoanMaster(loanm);
			}
		
		
		@GetMapping("/getAllLoanProduct")
		public List<LoanManagement> getloanProduct()
		{
			
			return s.getLoanPro();
		}
		
		@GetMapping("getLoantype/{loanmanagementid}")
		public LoanManagement getSingleType(@PathVariable int loanmanagementid)
		{
			return s.getSingleLoanType(loanmanagementid);
		}

		
		@GetMapping("/getEmp/{empid}")
		public Employee getEmp(@PathVariable int empid)
		{
			return s.getSingleEmp(empid);
		}
		
	
		
		 @GetMapping("bb/{empid}")
		  public Employee getb(@PathVariable int empid)
		  {
			 Employee u= s.getbb(empid);
			 return u;
		  }	
		 
		 
		 
		 @PostMapping("/bb")
		  public Employee empget(@RequestBody Employee emp)
		  {
		   System.out.println(emp); 
		  return s.eUp(emp);
		  }		
		 
		 
		 
		 
		 /***** loan management*****/
		 
		 @GetMapping("/loanmanagement/{loanmanagementid}")
		 public LoanManagement getLoanmanagementMasterId(@PathVariable int loanmanagementid) {
			  return s.getEdittedLoanMaster(loanmanagementid); }
			 
				
				@PutMapping("/updatingLoanMaster")
				public List<LoanManagement> updatingLoanMaster(@RequestBody LoanManagement loanMaster)
				{
					return s.updatingloanmaster(loanMaster);
					
				}
		 
				

				@DeleteMapping("loanMaster/{loanmanagementid}")
			    public List<LoanManagement> deletingLoanMaster(@PathVariable int loanmanagementid)
			    {
			   	 return s.getDeletedLaonMaster(loanmanagementid);
			    }
		 
				
				
				/******user********/
				
				@GetMapping("/getusersalldata")
				public List<User> getusers(User user)
				{
					
					return s.letsGetUsersDetail(user);
				}
				
				 @GetMapping("/getSingleUser/{userid}")
				  public User giveMeSingleUser(@PathVariable int userid)
				  {
					 User u= s.letsGetsingleUser(userid);
					 return u;
				  }	
				  
				
		 

}
