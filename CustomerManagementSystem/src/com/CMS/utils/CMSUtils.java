package com.CMS.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.CMS.core.Customer;
import com.CMS.core.ServicePlan;

public class CMSUtils {
//add a static method to populate customer list
	public static List<Customer> populateCustomerList() {
		/*
		 * String firstName, String lastName, String email, String password, double
		 * regAmount, LocalDate dob, ServicePlan plan
		 */
		List<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer("Rama", "Kadam", "rama@gmail.com", "rama@123", 2000, LocalDate.parse("1990-01-01"),
				ServicePlan.GOLD, LocalDate.parse("2023-04-01")));
		customers.add(new Customer("Kiran", "Khare", "kiran@gmail.com", "kiran@123", 1000, LocalDate.parse("1995-01-01"),
				ServicePlan.SILVER, LocalDate.parse("2023-08-01")));
		customers.add(new Customer("Mihir", "ajabe", "mihir@gmail.com", "mihir@123", 2000, LocalDate.parse("1990-01-01"),
				ServicePlan.GOLD, LocalDate.parse("2023-05-01")));
		customers.add(new Customer("Rakesh", "Malik", "rakesh@gmail.com", "rakesh@123", 10000, LocalDate.parse("1994-09-21"),
				ServicePlan.PLATINUM, LocalDate.parse("2023-09-01")));
		customers.add(new Customer("Riya", "Pathak", "riya@gmail.com", "riya@123", 5000, LocalDate.parse("1996-12-31"),
				ServicePlan.DIAMOND, LocalDate.parse("2023-07-01")));
		return customers;
	}
}
