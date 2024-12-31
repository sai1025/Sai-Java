package com.emp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String e_name;
	
	@Column(unique =true)
	private String email;
	
	private String phone;
	
	private String address;
	private String department;
	public Employee(int id, String e_name, String email, String phone, String address, String department,
			String designation, String dateOfJoining, String gender, String imageUrl, String password) {
		super();
		this.id = id;
		this.e_name = e_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.department = department;
		this.designation = designation;
		this.dateOfJoining = dateOfJoining;
		this.gender = gender;
		this.imageUrl = imageUrl;
		this.password = password;
	}
	private String designation;
	private String dateOfJoining;
	private String gender;
	private String imageUrl;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", e_name=" + e_name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", department=" + department + ", designation=" + designation + ", dateOfJoining="
				+ dateOfJoining + ", gender=" + gender + ", imageUrl=" + imageUrl + ", password=" + password + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	  
	   


}
