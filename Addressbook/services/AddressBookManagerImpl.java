package com.bridgelabz.Addressbook.services;

import java.io.File;
import java.io.IOException;

import com.bridgelabz.AddressBook.JsonUtility;

public class AddressBookManagerImpl implements AddressBookManager {

	@Override
	public void create() throws IOException {
		System.out.println("\n\t\t\tEnter the name of address book");
		String NewAddressBookName = JsonUtility.inputSingleString();
		File file = new File("/home/admin1/eclipse-workspace/AddressBook/" + NewAddressBookName + ".json");
		if(file.createNewFile())
		{
			System.out.println("\n\t\t\tFile is created!");
		} else {
			System.out.println("\n\t\t\tFile already exists.");
     }
	}
	
	public void read(String existingAddressBook) throws Exception {
		AddressBookImpl ab = new AddressBookImpl();
		ab.read(existingAddressBook);
}
	
	public void readAddress() {
		File f = new File("/home/admin1/eclipse-workspace/AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println("\n\t\t\t"+file.getName());
				count++;
			}
		}
		System.out.println("\n\t\t\tNumber of files: " + count);
}
	
	public boolean checkAddress(String existingAddressBook) {
		File f = new File("/home/admin1/eclipse-workspace/AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(existingAddressBook + ".json")) {
					count++;
					break;
				}
			}
		}
		if (count == 1)
			return true;
		else
			return false;
}
	
	

	@Override
	public void save(String file) {
		AddressBookImpl addressbookimpl=new AddressBookImpl();
		addressbookimpl.save(file);
		
	}

	@Override
	public void saveAs() {
		
		AddressBookImpl ab = new AddressBookImpl();
		ab.saveAs();
	}

	@Override
	public void close(String existingAddressBook) {
		AddressBookImpl ab = new AddressBookImpl();
		ab.close(existingAddressBook);
		
	}

}
