package com.bridgelab.EmployeePay;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class EmplyeePayRollService {

	private static final String url = "jdbc:mysql://localhost:3306/payroll_service";
	private static final String userName = "root";
	private static final String password = "tempyml@13";

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = null;
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connected to database" + connection);
		return connection;

	}

	/**
	 * method to establish connection with employee payroll database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void checkDatabaseConnection() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		listDrivers();

	}

	/**
	 * method to list the drivers
	 */
	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}

	/**
	 * method to select data from the database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void selectData() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getDouble(4) + " " + resultSet.getDate(5));
		}

	}

	/**
	 * to update the salary
	 * 
	 * @return
	 * @throws EmployeePayRollException
	 */
	public boolean updateSalary() throws EmployeePayRollException {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update employee_payroll set salary=300000 where name='Teresa'");
			if (result > 0) {
				System.out.println("updated");
				success = true;
			}
		} catch (ClassNotFoundException e) {
			throw new EmployeePayRollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayRollException("sql exception");
		}

		return success;

	}

	/**
	 * updating salary using prepared statement
	 */
	public boolean updateSalaryPrepared() throws EmployeePayRollException {

		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee_payroll set salary=? where name=?");
			preparedStatement.setDouble(1, 300000);
			preparedStatement.setString(2, "Teresa");
			System.out.println("Updated prepared statement");
			success = true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayRollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayRollException("sql exception");
		}

		return success;

	}

	/**
	 * method to retrieve employee data based on name
	 * 
	 * @param name
	 * @return
	 * @throws EmployeePayrollException
	 */
	public boolean retrievePrepared(String name) throws EmployeePayRollException {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee_payroll where name=?");
			preparedStatement.setString(1, name);
			success = true;
		} catch (ClassNotFoundException e) {
			throw new EmployeePayRollException("class not found");
		} catch (SQLException e) {
			throw new EmployeePayRollException("sql exception");
		}

		return success;

	}

public void retrieveDate() throws ClassNotFoundException, SQLException {
	Connection connection = getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("select * from employee_payroll where start BETWEEN CAST('2018-03-13' AS DATE) AND DATE(NOW())");
	while (resultSet.next()) {
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
				+ resultSet.getDouble(4) + " " + resultSet.getDate(5));
//		System.out.println("Data retrived");
	}
	System.out.println("Data retrieved");
}
/**
 * method to retrieve average salary
 * 
 * @throws EmployeePayrollException
 */
public void average() throws EmployeePayRollException {
	Connection connection;
	try {
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select avg(salary) from employee_payroll where gender='F' group by gender");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " ");

		}
	} catch (ClassNotFoundException e) {
		throw new EmployeePayRollException("class not found");
	} catch (SQLException e) {
		throw new EmployeePayRollException("sql exception");
	}

}

/**
 * method to retrieve minimum salary
 * 
 * @throws EmployeePayrollException
 */
public void minimum() throws EmployeePayRollException {
	Connection connection;
	try {
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select min(salary) from employee_payroll where gender='F' group by gender");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " ");

		}
		System.out.println("min");
	} catch (ClassNotFoundException e) {
		throw new EmployeePayRollException("class not found");
	} catch (SQLException e) {
		throw new EmployeePayRollException("sql exception");
	}

}

/**
 * method to retrieve maximum salary
 * 
 * @throws EmployeePayrollException
 */
public void maximum() throws EmployeePayRollException {
	Connection connection;
	try {
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select max(salary) from employee_payroll where gender='F' group by gender");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " ");

		}
		System.out.println("max");
	} catch (ClassNotFoundException e) {
		throw new EmployeePayRollException("class not found");
	} catch (SQLException e) {
		throw new EmployeePayRollException("sql exception");
	}

}

/**
 * method to count employees
 * 
 * @throws EmployeePayrollException
 */
public void count() throws EmployeePayRollException {
	Connection connection;
	try {
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select count(salary) from employee_payroll group by gender");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " ");

		}
		System.out.println("count");
	} catch (ClassNotFoundException e) {
		throw new EmployeePayRollException("class not found");
	} catch (SQLException e) {
		throw new EmployeePayRollException("sql exception");
	}

}
/**
 * method to retrieve sum of salary
 * 
 * @throws EmployeePayrollException
 */
public void sum() throws EmployeePayRollException {
	Connection connection;
	try {
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select sum(salary) from employee_payroll where gender='F' group by gender");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " ");

		}
		System.out.println("count");
	} catch (ClassNotFoundException e) {
		throw new EmployeePayRollException("class not found");
	} catch (SQLException e) {
		throw new EmployeePayRollException("sql exception");
	}

}
}
