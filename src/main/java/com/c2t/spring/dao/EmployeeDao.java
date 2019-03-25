package com.c2t.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;

@Repository
public interface EmployeeDao {
public List<Employee> getAllDummyEmployees();
public EmployeeList getMyDummyEmployees();
public Employee getEmployeesById(Long empid);
public String getDeleteEmployees(Long empid);


}
