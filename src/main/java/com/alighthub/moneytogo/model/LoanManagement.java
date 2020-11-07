package com.alighthub.moneytogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LoanManagement_master")
@Data
public class LoanManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanmanagementid;
	
	private String loantype;
	private float loaninterest;
	private long loanrangemin;
	private long loanrangemax;	


}
