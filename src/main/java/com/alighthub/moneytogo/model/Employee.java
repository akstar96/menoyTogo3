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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Employee_details")
@Data
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String empfirstname;
	private String emplastname;
	private String currentaddress;
	private String permanentaddress;
	private Long mobileno;
	private Date birthdate;
	private String email;
	private int pincode;
	private String pancard;
	private Long aadharcard;
	private Date sincedate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 private AccountManagement accountmanagement;
	
	/*
	 * @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "userEmp_fId",referencedColumnName = "empid") private
	 * List<User> user = new ArrayList<User>();
	 */
	
	  
	   
	  
	 
}
