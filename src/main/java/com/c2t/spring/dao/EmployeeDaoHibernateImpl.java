package com.c2t.spring.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeList;

public class EmployeeDaoHibernateImpl implements EmployeeDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Employee> getAllDummyEmployees() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Query query=session.createQuery("from employee");
		List<Employee> list= query.list();
		
		return list;
	}

	@Override
	public EmployeeList getMyDummyEmployees() {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		Query query= session.createQuery("from Employee");
		List<Employee> emp=query.list();
		
		EmployeeList employeeList=new EmployeeList();
		employeeList.setEmployees(emp);
		
		return employeeList;
		
		
		
	}

@Override
	public Employee getEmployeesById(Long empid) {
		// TODO Auto-generated method stub
       Session session=sf.openSession();
		
		Employee emp=(Employee)session.get(Employee.class, empid);
		
		return emp;
		
	}

	@Override
	public String getDeleteEmployees(Long empid) {
		// TODO Auto-generated method stub
		Session session=sf.openSession();
		
		Employee emp=(Employee)session.get(Employee.class,new Long(empid));
		
		session.delete(emp);
		session.beginTransaction().commit();
		
		return "record deleted";
		
		
	}

	
	
	
}
