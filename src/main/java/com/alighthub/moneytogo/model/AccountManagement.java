package com.alighthub.moneytogo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Accountmanagement_details")
@Data public class AccountManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountmanagementid;
	private String status;/*1:activate, 0 : deactivate; -1 :delete*/
	
	
	
	
	
	
	
	
	
	
	

}
