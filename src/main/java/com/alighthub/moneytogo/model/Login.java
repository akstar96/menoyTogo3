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
@Table(name = "Login_details")
@Data public class Login{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	private String username;
	private String password;
	private String type;	
	
}
