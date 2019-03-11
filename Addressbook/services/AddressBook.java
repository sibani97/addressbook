package com.bridgelabz.Addressbook.services;

import java.util.List;

import com.bridgelabz.AddressBook.model.AddressPerson;

//import addressbook.model.AddressPerson;

public interface AddressBook {
	public List<AddressPerson> add();
	public void edit();
	public void remove() throws Exception;
	public void sortByName();
	public void sortByZip();
    public void printAll();

}
