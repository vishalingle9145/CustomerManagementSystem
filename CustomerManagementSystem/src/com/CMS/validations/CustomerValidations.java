package com.CMS.validations;

import java.time.LocalDate;
import java.util.List;

import com.CMS.CustomException.InvalidInputException;
import com.CMS.core.Customer;
import com.CMS.core.ServicePlan;

public class CustomerValidations {
	
	public static void parseAndValidateEmail(String email, List<Customer> list) throws InvalidInputException
	{
		Customer c = new Customer(email);
		if(list.contains(c))
		{
			throw new InvalidInputException("Duplicate email entered...!");
		}
	}
	
//	add a method to parse and validate service plan
	public static ServicePlan parseAndValidatePlan(String plan)
	{
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
//	add a method to validate registration amount with the plan
	public static void validatePlanAmount(ServicePlan plan, double regAmount)throws InvalidInputException
	{
		if(plan.getPlanCost()!=regAmount)
		{
			throw new InvalidInputException("Please enter valid amount!!");
		}
	}
	
//	Email validation
	public static void validateEmail(String email, List<Customer> custList) throws InvalidInputException
	{
		//regex
		String pattern = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if(!email.matches(pattern))
			throw new InvalidInputException("Invalid Email...Try again!!!");
	}
	
//	date validation
	
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password, double registrationAmount,
			String dob, String servicePlan, String lastSubscriptionPaidDate, List<Customer> list) throws InvalidInputException
	{
		parseAndValidateEmail(email, list);
		validateEmail(email, list);
		ServicePlan validatePlan = parseAndValidatePlan(servicePlan);
		validatePlanAmount(validatePlan, registrationAmount);

		return new Customer(firstName, lastName, email, password, registrationAmount, LocalDate.parse(dob), validatePlan, LocalDate.parse(lastSubscriptionPaidDate));
		
	}
 

}
