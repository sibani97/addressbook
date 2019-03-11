package com.bridgelabz.AddressBook;

import java.util.Comparator;

public class SortByName implements Comparator<AddressPerson> {
	public int compare(AddressPerson person1,AddressPerson person2)
	{
		if(person1.getFirstname().equals(person2.getFirstname()))
		return 0;
		else
		{
			if(person1.getFirstname().compareTo(person2.getLastname())>0)
			{
				return 1;
			}else {
				return -1;
			}
		}
	}
	

}
