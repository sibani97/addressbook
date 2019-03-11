package com.bridgelabz.AddressBook;

import java.util.List;

public interface AddressBook {
	public List<AddressPerson> add();
	public void edit();
	public void remove() throws Exception;
	public void sortByName();
	public void sortByZip();
    public void printAll();

}
