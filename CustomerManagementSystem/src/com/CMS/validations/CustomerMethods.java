package com.CMS.validations;

import java.util.List;

import com.CMS.CustomException.InvalidInputException;
import com.CMS.core.Customer;

public class CustomerMethods {

//	authenticate email and password
	public static void authenticateUser(String email, String password, List<Customer> cust)
			throws InvalidInputException {
		Customer c = new Customer(email);

		int index = cust.indexOf(c);

		if (index != -1) {
			c = cust.get(index);

			if (c.getPassword().equals(password)) {
				System.out.println("Login successful...!");
				System.out.println("WELCOME: " + email);
			} else {
				throw new InvalidInputException("Incorect password...! Please Try Again!!!");
			}

		} else {
			throw new InvalidInputException("Invalid Email...! Please Try Again!!!");
		}

	}

//	reset password
	public static void resetPassword(String email, String password, String newPassword, List<Customer> cust)
			throws InvalidInputException {

		Customer c = new Customer(email);

		int index = cust.indexOf(c);

		if (index != -1) {
			c = cust.get(index);

			if (c.getPassword().equals(password)) {
				c.setPassword(newPassword);
			} else {
				throw new InvalidInputException("Incorect Old Password");
			}

		} else {
			throw new InvalidInputException("Invalid Email...!");
		}

	}

//	remove customer
	public static void removeCustomer(String email, List<Customer> cust) throws InvalidInputException {
		Customer c = new Customer(email);

		int index = cust.indexOf(c);

		if (index != -1) {
			c = cust.get(index);

			if (c.getEmail().equals(email)) {
				cust.remove(index);
				System.out.println("User Removed: " + email);
			}

		} else {
			throw new InvalidInputException("User not Found....!!!");
		}

	}
}
