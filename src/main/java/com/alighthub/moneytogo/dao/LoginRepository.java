package com.alighthub.moneytogo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alighthub.moneytogo.model.Employee;
import com.alighthub.moneytogo.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
    public Login findByUsernameAndPassword(String username, String password);


	

}
