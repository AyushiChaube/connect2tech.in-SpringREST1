package com.c2t.annotation.basic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EMPLOYEE_TABLE")
@XmlRootElement(name="Employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Employee {


	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name="last_name")
	private String lastname;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "cell_phone")
	private String cellphone;

	public Employee() {

	}

	public Employee(String firstname, String lastname, Date birthdate, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.cellphone = phone;

	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String toString() {

		return "firstname=" + firstname + ", lastname=" + lastname + ", id" + id;

	}
	
	

}
