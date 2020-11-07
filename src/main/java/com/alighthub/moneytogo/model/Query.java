package com.alighthub.moneytogo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "query_details")
@Data
public class Query implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int queryid;

	private String querysubject;
	private String query;
	private String querystatus;
	private transient int userid;

	 @ManyToOne	
	  @JoinColumn(name = "userid")
	 private User user;
	 

}
