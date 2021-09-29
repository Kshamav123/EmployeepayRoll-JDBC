package com.bridgelab.EmployeePay;

public class EmployeePayRollException extends Exception{
	 String message;

	public EmployeePayRollException(String message) {
		super();
		this.message = message;
	}
	 
}
