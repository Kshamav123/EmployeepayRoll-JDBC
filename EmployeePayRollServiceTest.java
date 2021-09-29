package com.bridgelab.EmployeePay;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayRollServiceTest {
	
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.checkDatabaseConnection();
	}


}

