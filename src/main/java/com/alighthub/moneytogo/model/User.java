package com.alighthub.moneytogo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User_details")
@Data public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	private String firstname;
	private String lastname;
	
	private String currentaddress;
	private String permanentaddress;

	private Long mobileno;
	
	private Date birthdate;
	
    private String email;
    private  int pincode;
    
    private String pancard;
    
    private Long aadharcard;
    
    private Date usersince;
    
    private String userstatus;
    
    private transient int empid;
	
    @OneToOne(cascade = CascadeType.ALL)
	private Login login;  
	
	  
		
		  @OneToOne(cascade = CascadeType.ALL)
			private Feedback feedback;
	
	  @OneToOne(cascade = CascadeType.ALL) 
	  private Loan loan;
	  
		@OneToOne(cascade = CascadeType.ALL)
		private LoanManagement loanmanagement;
		
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "user_employee_id", nullable = false) private Employee
	 * employee;
	 */
	 
	/*
	 * @OneToMany(targetEntity = Query.class,cascade = CascadeType.ALL) private
	 * List<Query> queries = new ArrayList<Query>();
	 */
	
	@ManyToOne
	@JoinColumn(name="Employee_id")
	private Employee employee;
	
	
	
		
	
	

}
