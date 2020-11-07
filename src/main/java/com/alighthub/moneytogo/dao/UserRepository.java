/**
 * 
 */
package com.alighthub.moneytogo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alighthub.moneytogo.model.User;

/**
 * @author Pallavi
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByuserid(int userid);
	
	public User findByLoginLoginId(int loginId);
	
	public List<User> findByuserstatus(String userstatus);
	
	public List<User> findByEmployeeEmpid(int empid);

	/**
	 * @param userid
	 * @return
	 */
	//public User findOne(int userid);
}
