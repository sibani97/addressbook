package com.bridgelabz.AddressBook;

import java.util.Comparator;

public class SortByZip implements Comparator<AddressPerson> {

	@Override
	public int compare(AddressPerson person1, AddressPerson person2) {
		if(person1.address.getZip()==person2.address.getZip())
		
		return 0;
		else {
			if(person1.address.getZip()>person2.address.getZip())
			{
				return 1;
			}else {
				return -1;
			}
		}
	}
	
	

}
