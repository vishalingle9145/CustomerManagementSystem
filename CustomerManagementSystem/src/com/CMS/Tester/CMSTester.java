package com.CMS.Tester;

import static com.CMS.validations.CustomerValidations.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.CMS.core.Customer;
import com.CMS.core.ServicePlan;
import com.CMS.customOrdering.SortByDOB;
import com.CMS.customOrdering.SortByDobAndLastName;
import com.CMS.validations.CustomerMethods;
import static com.CMS.utils.CMSUtils.populateCustomerList;
import static com.CMS.validations.CustomerMethods.*;

public class CMSTester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

//			List<Customer> customer = new ArrayList<>();
			List<Customer> customer = populateCustomerList();

			boolean exit = false;

			while (!exit) {
				System.out.println("\n1. SIGN UP 2. SIGN IN 3. Display All 4. Reset Password 5. Sort by Email \n"
						+ "6. Sort by DOB 7. Sort by DOB and LastName 8. (ADMIN) 3 Months Pending Subscr \n"
						+ "9. Remove Customers 6 Months Pending Subscr 10. UNSUBSCRIBE CUSTOMER 0. EXIT");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"firstName, lastName, email, password, registrationAmount, DateOfBirth, servicePlan, lastSubscriptionDate");

						Customer cust = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
								sc.next(), sc.next(), sc.next(), customer);

						customer.add(cust);
						System.out.println("Customer registered succssfully....!");
						System.out.println(LocalDate.now());

						break;

					case 2:
						System.out.println("Enter Email and Password");
						CustomerMethods custm = new CustomerMethods();
						authenticateUser(sc.next(), sc.next(), customer);

						System.out.println();
						break;

					case 3:
						System.out.println("All Customers: ");
						for (Customer c : customer)
							System.out.println(c);
						break;

					case 4:
						System.out.println("Enter Email, Old Password and New Password: ");

						resetPassword(sc.next(), sc.next(), sc.next(), customer);
						System.out.println("Password Updated....!");

						break;

					case 5:
						Collections.sort(customer);
						System.out.println("Data Sorted as per Emails...!");
						break;

					case 6:
						Collections.sort(customer, new SortByDOB());
						System.out.println("Data sorted by DateOfBirth....!");
						break;

					case 7:
						Collections.sort(customer, new SortByDobAndLastName());
						System.out.println("Data sorted by DOB and LastName...!");
						break;

					case 8:
						System.out.println("Customers who have 3 months pending subscription: ");
						for (Customer c : customer)
							if (Period.between(c.getLastSubscriptionPaidDate(), LocalDate.now()).toTotalMonths() >= 3) {
								System.out.println(c);
							}

						break;

					case 9:
						System.out.println("Remove Customers who have 6 months pending subscription: ");
						Iterator<Customer> it = customer.iterator();
						while (it.hasNext()) {
							Customer c1 = it.next();
							if (Period.between(c1.getLastSubscriptionPaidDate(), LocalDate.now())
									.toTotalMonths() >= 6) {
								System.out.println(c1);
								it.remove();

							}
						}
						System.out.println("Successfully removed...!");
						break;

					case 10:
						System.out.println("Enter Customer email to unsubscribe");
						removeCustomer(sc.next(), customer);
						
						break;
						
					case 0:
						exit = true;
						System.out.println("Thank You...!");
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}
	}

}
