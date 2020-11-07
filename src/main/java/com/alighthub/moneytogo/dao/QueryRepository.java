/**
 * 
 */
package com.alighthub.moneytogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alighthub.moneytogo.model.Query;
import com.alighthub.moneytogo.model.User;

/**
 * @author Pallavi
 *
 */
public interface QueryRepository extends JpaRepository<Query, Integer> {
	
	public Query findByqueryid(int queryid);
	 

}
