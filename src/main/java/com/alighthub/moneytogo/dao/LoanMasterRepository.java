/**
 * 
 */
package com.alighthub.moneytogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alighthub.moneytogo.model.LoanManagement;

/**
 * @author Pallavi
 *
 */
public interface LoanMasterRepository extends JpaRepository<LoanManagement, Integer> {

	public LoanManagement findByloanmanagementid(int loanmanagementid);
}
