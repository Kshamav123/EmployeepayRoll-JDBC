package com.bridgelab.EmployeePay;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayRollServiceTest {
	
	/**
	 * test case to check database connected or not
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() throws ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.checkDatabaseConnection();
	}
	/**
	 * test cases to test data retrieval from database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() throws ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.selectData();
	}
	
	/**
	 * test case to update the salary
	 * 
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalary() throws EmployeePayRollException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		boolean result = employeePayrollService.updateSalary();
		Assert.assertTrue(result);

	}
	
	/**
	 * test case to update the salary using prepared statement
	 * 
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateSalaryUsingPreparedStatement() throws EmployeePayRollException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		boolean result = employeePayrollService.updateSalaryPrepared();
		Assert.assertTrue(result);

}
	
	/**
	 * test case to retrieve the employee by name using prepared statement
	 * 
	 * @throws EmployeePayrollException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingPreparedStatement()
			throws EmployeePayRollException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		boolean result = employeePayrollService.retrievePrepared("Teresa");
		Assert.assertTrue(result);

	}
	/**
	 * test case to retrieve the employee by date
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnEmployeeDetailsUsingBasedOndate()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.retrieveDate();

	}
	
	/**
	 * test case to sum of salary
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnSumofEmployeeSalary()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.sum();

	}
	
	/**
	 * test case to average of salary
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnAverageofEmployeeSalary()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.average();

	}
	
	/**
	 * test case to minimum of salary
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnMinofEmployeeSalary()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.minimum();

	}
	
	/**
	 * test case to max of salary
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnMaxofEmployeeSalary()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.maximum();

	}
	
	/**
	 * test case to count of salary
	 * 
	 * @throws EmployeePayrollException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldReturnCountofEmployeeSalary()
			throws EmployeePayRollException, ClassNotFoundException, SQLException {
		EmplyeePayRollService employeePayrollService = new EmplyeePayRollService();
		employeePayrollService.count();

	}
	
}

