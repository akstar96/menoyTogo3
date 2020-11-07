package com.alighthub.moneytogo.service;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.alighthub.moneytogo.dao.ComponentRepository;
import com.alighthub.moneytogo.dao.EmployeeRepository;
import com.alighthub.moneytogo.dao.LoanMasterRepository;
import com.alighthub.moneytogo.dao.LoanRepository;
import com.alighthub.moneytogo.dao.LoginRepository;
import com.alighthub.moneytogo.dao.QueryRepository;
import com.alighthub.moneytogo.dao.ResponseRepository;
import com.alighthub.moneytogo.dao.UserRepository;
import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Loan;
import com.alighthub.moneytogo.model.LoanManagement;
import com.alighthub.moneytogo.model.Login;
import com.alighthub.moneytogo.model.Query;
import com.alighthub.moneytogo.model.Response;
import com.alighthub.moneytogo.model.User;

@Service
public class ServiceImpl implements ServiceInterf{
	
	//@Autowired
	//private DaoInterf d;
	
	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private LoginRepository lr;
	
    @Autowired
    private ComponentRepository cr;
    
    @Autowired
    private UserRepository ur;
    
    @Autowired
    private LoanMasterRepository lmr;
    
    @Autowired
    private LoanRepository loanrepo;
    
    @Autowired
    private QueryRepository qr;
    
    @Autowired
    private ResponseRepository rr;
    
    

	@Override
	public int addEmployee(Employee employee) {
		Employee u=er.save(employee); 
		return  u.getEmpid();
	}
	
	
	
	  @Override 
	  public int addUser(User user) {
		  User u=ur.save(user);
		  return u.getUserid(); 
		  }
	 
	/*
	 * @Override public User forgotPass(String email) { User u =
	 * d.findByEmail(email); return u; }
	 */ 
	
	  @Override
	  public Login loginCheck(String username, String password)
	  {
	  System.out.println("in service");
	  Login l= lr.findByUsernameAndPassword(username, password);
	  System.out.println("in service"+l);
	  return l;
	  }
	 
	  
	/* @Override public List<User> admincheck(String username, String password) {
	 * System.out.println("in service"); List<User> ll= d.findAll();
	 * System.out.println("in service"+ll); return ll; }
	 */

	
	  @Override
	  public Employee getAdmin(int id)
	  {
		  Employee a=cr.findByLoginLoginId(id); 
		  return a; }



	@Override
	public List<Employee> getAllEmployeeData(String type) {
		 List<Employee> empl= er.findByLoginType(type);
		 return empl;
	}



	@Override
	public List<Employee> deleteEmployee(int empid) {
		er.deleteById(empid);		
		lr.deleteById(empid);
		return er.findAll();
	}



	@Override
	public Employee getEdit(int empid) {
		Employee e = er.findById(empid).get();
		return e;
	}



	@Override
	public List<Employee> updating(Employee emp) {
		er.save(emp);
		 List<Employee> empl= er.findAll();
		 return empl;
	}



	@Override
	public long countEmployee() {
		// TODO Auto-generated method stub
		long employee =  er.count();
		 return employee;
	}



	@Override
	public int addLoanMaster(LoanManagement loanmanage) {
		  LoanManagement lm=lmr.save(loanmanage);
		  return lm.getLoanmanagementid();
	}



	@Override
	public List<LoanManagement> getLoanPro() {
		List<LoanManagement> lmp = lmr.findAll();
		return lmp;
	}



	@Override
	public List<User> getAllUserData() {
		List<User> user = ur.findAll();
		
		return user;
	}



	@Override
	public User getSingleUser(int userid) {
		User u = ur.findByuserid(userid);
		return u;
	}



	@Override
	public LoanManagement getSingleLoanType(int loanmanagementid) {
		LoanManagement lm = lmr.findByloanmanagementid(loanmanagementid);
		return lm;
	}



	/*
	 * @Override public User postLoanApplication(User user) {
	 * System.out.println(user);
	 * //System.out.println("check here"+user.getUserid()); user =
	 * ur.findByuserid(user.getUserid()); ur.save(user); return user; }
	 */

	

	@Override
	public User getLoanUser(int userid)
	{
		System.out.println(userid);
		User u = ur.findByuserid(userid);
		ur.save(u);
		return u;
	}


	
	
	 @Override 
	 public User postLoanApplication(User user)
	 {
	 ur.save(user);
	 
	 return user;
	 
	 
	 }



	@Override
	public List<User> getUserByStatus(String userstatus) {
		List<User> ust = ur.findByuserstatus(userstatus);
		return ust;
	}



	@Override
	public Employee getSingleEmp(int empid) {
Employee empl= er.findByempid(empid);
return empl;
	}



	/*
	 * @Override public User getempAdded(int userid) { System.out.println(userid);
	 * User u = ur.findByuserid(userid); ur.save(u); return u; }
	 * 
	 */

	@Override
	public User employeeUp(User user) {
		ur.save(user);
		return user;
	}



	@Override
	public Employee getbb(int empid) {
		Employee e = er.findByempid(empid);
		return e;
	}



	@Override
	public Employee eUp(Employee emp) {
er.save(emp);
return emp;
	}



	@Override
	public User getbu(int userid) {
		User uu = ur.findByuserid(userid);
		return uu;
	}



	@Override
	public User getUserQuery(int userid) {
		User uu = ur.findByuserid(userid);
		return uu;
	}



	@Override
	public User getQuery(User user) {
		ur.save(user);
		return user;
	}



	@Override
	public User getuserProfile(int loginId) {
		User usr = ur.findByLoginLoginId(loginId);
		return usr;
	}



	@Override
	public Query postQuery( Query query) {
	//	query.setUser(ur.findById(query.getUserid()));
		
		query.setUser(ur.findByuserid(query.getUserid()));
		return qr.save(query);
	}


	
		

	@Override
	public LoanManagement getEdittedLoanMaster(int loanmanagementid) {
		LoanManagement lm =lmr.findByloanmanagementid(loanmanagementid);
		return lm;
	}



	@Override
	public List<LoanManagement> updatingloanmaster(LoanManagement loanMaster) {
		lmr.save(loanMaster);
		List<LoanManagement> loanMasterList = lmr.findAll();
		return loanMasterList;
	}


	@Override
	public List<LoanManagement> getDeletedLaonMaster(int loanmanagementid) {
		lmr.deleteById(loanmanagementid);
		return lmr.findAll();
	}



	@Override
	public User letUserCreated(User user) {
		
		user.setEmployee(er.findByempid(user.getEmpid()));
return ur.save(user);
	}



	@Override
	public List<User> letsGetUsersDetail(User user) {
		List<User> users = ur.findAll();
		return users;
	}



	@Override
	public User letsGetsingleUser(int userid) {
User user = ur.findByuserid(userid)	;
return user;
	}



	@Override
	public List<Query> letsGetqueriesDetail(Query query) {
		List<Query> queries = qr.findAll();
		return queries;
	}



	@Override
	public Query letsgetsingleQuery(int queryid) {
		Query query = qr.findByqueryid(queryid);
		return query;
	}



	@Override
	public Response letSendEmailForQuery(Response response) {
		return rr.save(response);				
	}



	@Override
	public List<User> getUserForApplyingLoan(int empid) {
		List<User> usr =ur.findByEmployeeEmpid(empid);
		return usr;
	}

}
