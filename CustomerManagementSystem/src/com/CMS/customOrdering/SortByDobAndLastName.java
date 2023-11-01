package com.CMS.customOrdering;

import java.util.Comparator;

import com.CMS.core.Customer;

public class SortByDobAndLastName implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		if(o1.getDob().equals(o2.getDob()))
		{
		return o1.getLastName().compareToIgnoreCase(o2.getLastName());
		}
		else
		{
			return o1.getDob().compareTo(o2.getDob());
		}
	}

	
	
}
