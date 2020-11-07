/**
 * 
 */
package com.alighthub.moneytogo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.moneytogo.model.Query;
import com.alighthub.moneytogo.model.Response;
import com.alighthub.moneytogo.model.User;
import com.alighthub.moneytogo.service.ServiceInterf;

/**
 * @author Pallavi
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/query")
public class QueryController {
	
	
	@Autowired
    private JavaMailSender javaMailSender;	
	
	@Autowired
	private ServiceInterf s;  
  
	public static Logger logger = LogManager.getLogger(QueryController.class);	
	
	@GetMapping("/query/{userid}")
	public User userQuery(@PathVariable int userid)
	{
		return s.getUserQuery(userid);
		
	}
	
	 @PostMapping("/userqueryadd")
	 public User addingQuery(@RequestBody User user) {	  
	  logger.info("query controller called");	  
	 	  return s.getQuery(user);	  
	  }		 
	 
	 
	 /**** add from here****/
	 
	 @PostMapping("/user/queries/{userid}") 
	 public Query createQuery(@RequestBody Query query)
	 { 
		 return s.postQuery(query);
	  }
	 
		
		@GetMapping("/getQueryalldata")
		public List<Query> getQueryDetail(Query query)
		{			
			return s.letsGetqueriesDetail(query);
		}
		
		
		@GetMapping("/singlequery/{queryid}")
		public Query getSingleQuery(@PathVariable int queryid)
		{
			return s.letsgetsingleQuery(queryid);			
		}		
		
		 @PostMapping("/sendQueryMail") 
		 public Response SendQueryEmail(@RequestBody Response response)
		 { 
			 try {
				  SimpleMailMessage msg = new SimpleMailMessage();
				  System.out.println("here"+response.getEmail());
			        msg.setTo(response.getEmail());

			        msg.setSubject("Testing from Spring Boot");
			        msg.setText("Hello World \n Spring Boot Email"+response.getResponseMessage());

			        javaMailSender.send(msg);

				        } catch (Exception e) {
				            e.printStackTrace();
				      }
			return s.letSendEmailForQuery(response);
		 }	
		 
}
