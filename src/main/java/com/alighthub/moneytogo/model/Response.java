/**
 * 
 */
package com.alighthub.moneytogo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * @author Pallavi
 *
 */
@Entity
@Data
public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int responseid;
	private String responseMessage;	
	private String email;
	private int queryid; 
	

}
