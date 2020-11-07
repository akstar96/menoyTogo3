/**
 * 
 */
package com.alighthub.moneytogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alighthub.moneytogo.model.Loan;

/**
 * @author Pallavi
 *
 */
public interface LoanRepository extends JpaRepository<Loan,Integer> {

	

}
