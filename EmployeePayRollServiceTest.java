package com.bridgelab.EmployeePay;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayRollServiceTest {
	
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() throws ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.checkDatabaseConnection();
	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() throws ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.selectData();
	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalary() throws EmployeePayRollException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		boolean result = employeePayrollService.updateSalary();
		Assert.assertTrue(result);

	}
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalaryUsingPreparedStatement() throws EmployeePayRollException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		boolean result = employeePayrollService.updateSalaryPrepared();
		Assert.assertTrue(result);

}
}

