package com.wipro.mc.resource;

//@XmlRootElement
public class Employee {
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empEmail=" + empEmail
				+ ", empSalary=" + empSalary + "]";
	}
	private int empId;
	private String empName;
	private int empAge;
	private String empEmail;
	private float empSalary;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, int empAge, String empEmail, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empEmail = empEmail;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

}
