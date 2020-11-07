/**
 * 
 */
package com.alighthub.moneytogo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Login;
import com.alighthub.moneytogo.model.User;

/**
 * @author Pallavi
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByempid(int empid);
	
	public List<Employee> findByLoginType(String type);
	
	
 

	

}
