package com.alighthub.moneytogo.service;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Loan;
import com.alighthub.moneytogo.model.LoanManagement;
import com.alighthub.moneytogo.model.Login;
import com.alighthub.moneytogo.model.Query;
import com.alighthub.moneytogo.model.Response;
import com.alighthub.moneytogo.model.User;

public interface ServiceInterf {

	//int insertData(User user);
	//User forgotPass(String email);
	//User changePass(String password);	List<User> getAllData(String uname, String pass);
	Login loginCheck(String username, String password);
	//List<User> admincheck(String username, String password);
	Employee getAdmin(int id);	
	int addUser(User user);	
	int addEmployee(Employee employee);
	List<Employee> getAllEmployeeData(String type);
	List<Employee> deleteEmployee(int empid);
	Employee getEdit(int empid);
	public List<Employee> updating(Employee emp);
	
	long countEmployee();
	
	int addLoanMaster(LoanManagement loanmanage);
	
	List<LoanManagement> getLoanPro();	
	
	List<User> getAllUserData();
	
	User getSingleUser(int userid);
	/**
	 * @param loanmanagementid
	 * @return
	 */
	LoanManagement getSingleLoanType(int loanmanagementid);
	
	
	/**
	 * @param userid
	 * @return
	 */
	User postLoanApplication(User user);
	/**
	 * @param userid
	 * @return
	 */
	User getLoanUser(int userid);
	
	List<User> getUserByStatus(String userstatus);
	
	Employee getSingleEmp(int empid);
	/**
	 * @param userid
	 * @return
	 */
//	Employee getempAdded(int userid);
	/**
	 * @param user
	 * @return
	 */
	User employeeUp(User user);
	/**
	 * @param empid
	 * @return
	 */
//	Employee getEmp(int empid);
	/**
	 * @param user
	 * @return
	 */
//	User employeeadding(User user);
	/**
	 * @param empid
	 * @return
	 */
	Employee getbb(int empid);
	/**
	 * @param emp
	 * @return
	 */
	Employee eUp(Employee emp);
	/**
	 * @param userid
	 * @return
	 */
	User getbu(int userid);
	/**
	 * @param userid
	 * @return
	 */
	User getUserQuery(int userid);
	/**
	 * @param query
	 * @return
	 */
	User getQuery(User user);
	/**
	 * @param loginId
	 * @return
	 */
	User getuserProfile(int loginId);
	/**
	 * @param userid
	 * @param query
	 * @return
	 */
	Query postQuery(Query query);
	/**
	 * @param loanmanagementid
	 * @return
	 */
	LoanManagement getEdittedLoanMaster(int loanmanagementid);
	/**
	 * @param loanMaster
	 * @return
	 */
	List<LoanManagement> updatingloanmaster(LoanManagement loanMaster);
	/**
	 * @param loanmanagementid
	 * @return
	 */
	List<LoanManagement> getDeletedLaonMaster(int loanmanagementid);
	/**
	 * @param user
	 * @return
	 */
	User letUserCreated(User user);
	/**
	 * @return
	 */
	List<User> letsGetUsersDetail(User user);
	/**
	 * @param userid
	 * @return
	 */
	User letsGetsingleUser(int userid);
	/**
	 * @param query
	 * @return
	 */
	List<Query> letsGetqueriesDetail(Query query);
	/**
	 * @param queryid
	 * @return
	 */
	Query letsgetsingleQuery(int queryid);
	/**
	 * @param email
	 * @return
	 */
	public Response letSendEmailForQuery(Response response);
	/**
	 * @param empid
	 * @return
	 */
	List<User> getUserForApplyingLoan(int empid);
	
	

}
