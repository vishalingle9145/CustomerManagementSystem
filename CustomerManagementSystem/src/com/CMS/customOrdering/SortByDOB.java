package com.CMS.customOrdering;

import java.util.Comparator;

import com.CMS.core.Customer;

public class SortByDOB implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return o1.getDob().compareTo(o2.getDob());
	
	}

}
