package com.emp.dto;

public class EmployeeDTO {
    public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(String phone, String address, String department) {
		super();
		this.phone = phone;
		this.address = address;
		this.department = department;
		
	}
	private String phone;
    private String address;
    private String department;
    
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
	
	@Override
	public String toString() {
		return "EmployeeDTO [phone=" + phone + ", address=" + address + ", department=" + department+"]";
	}

    // Getters and Setters
}

