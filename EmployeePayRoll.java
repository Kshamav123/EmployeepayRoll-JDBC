package com.bridgelab.EmployeePay;

import java.time.LocalDate;

public class EmployeePayRoll {
	int empId;
	String empName;
	String gender;
	double salary;
	LocalDate startDate;
	
	public EmployeePayRoll(int empId, String empName, String gender, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
	}

	public EmployeePayRoll(int empId, String empName, String gender, double salary,LocalDate startDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
		this.startDate = startDate;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "EmployeePayRoll [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", salary=" + salary
				+ ", startDate=" + startDate + "]";
	}
	
	
}
