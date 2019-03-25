package com.journaldev.spring.controller;

import java.sql.Date;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.Employee2;
import com.c2t.annotation.basic.EmployeeList;

//import com.c2t.journaldev.spring.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	SessionFactory sf;
	
	Map<Integer,Employee> empData=new HashMap<Integer,Employee>();
	
	@RequestMapping(value="/rest/emp/dummy",method = RequestMethod.GET)
   public @ResponseBody Employee getDummyEmployee() {
	   
	 // Employee emp=new Employee();
	  // emp.setId(9999);
	  // emp.setName("Dummy");
	  // emp.setId(101l);
	//   emp.setFirstname("Ayushi");
	//   emp.setLastname("Chaube");
	   //emp.setBirthDate(new Date());
	 //  emp.setBirthDate(new Date(1996, 06, 23));
	 //  emp.setCellphone("8946895556");
	  // emp.setCreatedDate(new Date());
  // empData.put(9999,emp);
   

	Session session=sf.openSession();
    
  Employee emp=(Employee) session.get(Employee.class, 102l);

   
	return emp;
   
   }
	@RequestMapping(value="/rest/emp/insertEmployee",method=RequestMethod.GET)
	public @ResponseBody Employee2 insertEmployee() 
	{
		Session session=sf.openSession();
		session.beginTransaction();
		
		Employee2 emp=new Employee2("rahul","Sangle",new Date(1995/03/06),"983888432");
		session.save(emp);
		session.getTransaction().commit();
		return emp;
	}
	
	@RequestMapping(value="/rest/emp/list",method = RequestMethod.GET)
	   public @ResponseBody List<Employee> getAllDummyEmployees() {
		   
		Session session=sf.openSession();
		Query query= session.createQuery("from Employee");
		List<Employee> emp=query.list();
		
		//Employee employees.
		return emp;
	}
	
	@RequestMapping(value="/rest/emp/listEmployee",method = RequestMethod.GET)
	   public @ResponseBody EmployeeList getMyDummyEmployees() {
		   
		Session session=sf.openSession();
		Query query= session.createQuery("from Employee");
		List<Employee> emp=query.list();
		
		EmployeeList employeeList=new EmployeeList();
		employeeList.setEmployees(emp);
		//Employee employees.
		return employeeList;
	}
	
	
	@RequestMapping(value="/rest/emp/{id}",method = RequestMethod.GET)
	   public @ResponseBody Employee getEmployeesById(@PathVariable("id") int empid) {
		   
		Session session=sf.openSession();
		
		Employee emp=(Employee)session.get(Employee.class,new Long(empid));
		
		return emp;
	}
	
	
	@RequestMapping(value="/rest/delete/{id}",method = RequestMethod.GET)
	   public @ResponseBody String getDeleteEmployees(@PathVariable("id") int empid) {
		   
		Session session=sf.openSession();
		
		Employee emp=(Employee)session.get(Employee.class,new Long(empid));
		
		session.delete(emp);
		session.beginTransaction().commit();
		
		return "record deleted";
	}
	
}
