package com.bridgelab.EmployeePay;

import java.io.File;
import java.sql.DriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.mysql.cj.jdbc.Driver;

public class EmplyeePayRollService {
	
	private static final String url = "jdbc:mysql://localhost:3306/payroll_service";
	private static final String userName = "root";
	private static final String password = "tempyml@13";

	public void checkDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con;
			try {
				con = DriverManager.getConnection(url, userName, password);
				System.out.println("connected to database" + con);
				listDrivers();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
	}
}	
	
	
