package com.CMS.core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan servicePlan;
	private LocalDate lastSubscriptionPaidDate;
	private LocalDate regDate;

	// static id generator
	private static int idGenerator;

	static {

		idGenerator = 1;
	}

	public Customer(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan servicePlan, LocalDate lastSubscriptionPaidDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.servicePlan = servicePlan;
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate; //in realtime we use LocalDate.now()
		this.regDate = LocalDate.parse("2012-01-01");
		this.customerId = idGenerator;
		idGenerator++;
	}

	public Customer(String email) {
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(ServicePlan servicePlan) {
		this.servicePlan = servicePlan;
	}

	public static int getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(int idGenerator) {
		Customer.idGenerator = idGenerator;
	}

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	public void setLastSubscriptionPaidDate(LocalDate lastSubscriptionPaidDate) {
		this.lastSubscriptionPaidDate = lastSubscriptionPaidDate;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", Password= " + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob
				+ ", servicePlan=" + servicePlan + ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + " ]";
	}

	@Override
	public boolean equals(Object anotherObj) { // obj1.equals(obj2)

		if (anotherObj instanceof Customer)
			return this.email.equals(((Customer) anotherObj).email);

		return false;
	}

	@Override
	public int compareTo(Customer c) {
		return this.email.compareTo(c.email);

	}

}
