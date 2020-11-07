package com.alighthub.moneytogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.alighthub.moneytogo.model.Employee;

@Repository
public interface ComponentRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByLoginLoginId(int id);

}
