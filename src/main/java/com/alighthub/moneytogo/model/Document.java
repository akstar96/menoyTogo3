package com.alighthub.moneytogo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Document_details")
@Data public class Document {

	@Id
	private int  documentid;
	private String documenttype;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_document_id", nullable = false)
    private User user;
	
}
