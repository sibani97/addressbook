package com.bridgelabz.AddressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

//import org.codehaus.jackson.JsonGenerationException;

public class AddressBookImpl implements AddressBook{
	public static List<AddressPerson> list = new ArrayList<AddressPerson>();
	ObjectMapper mapper = new ObjectMapper();
	JsonUtility utility=new JsonUtility();

	@Override
	public List<AddressPerson> add() {
		list.add(addUser());
		for (AddressPerson P : list) {
			System.out.println(P.toString());
		}
return list;
		
		
	}
	static int count = 0;

	@Override
	public void edit() {
		System.out.println("\n\t\t\tEnter first name");
		String firstName = JsonUtility.inputString();
		for (AddressPerson P : list) {
			if (firstName.equals(P.getFirstname())) {
				count++;
				System.out.println("\n\t\t\tData found\n");
				System.out.println("\t\t\t1. To edit Address\n" + "\t\t\t2. To edit Phone Number\n");
				int editChoice = JsonUtility.inputInteger();
				switch (editChoice) {
				case 1:
					editAddressPhone(P, 1);
					break;
				case 2:
					editAddressPhone(P, 2);
					break;
				default:
					System.out.println("\t\t\tSomething went wrong\n" + "\t\t\tTry again later");
				}
			} 
		}
		if(count==0)
System.out.println("\n\t\t\tData not found");
		
	}

	@Override
	public void remove() throws Exception {
		System.out.println("\n\t\t\tEnter first name whose data is to be removed");
		String firstName = JsonUtility.inputString();
		int count = 0;
		List<AddressPerson> toRemove = new ArrayList<>();
		for (AddressPerson P : list) {
			if (firstName.equals(P.getFirstname())) {
				System.out.println("\n\t\t\tData found\n\n\t\t\tData Removed");
				toRemove.add(P);
				count++;
			}
		}
		list.removeAll(toRemove);
		if (count == 0)
System.out.println("\n\t\t\tSorry, no such data found");
		
	}

	@Override
	public void sortByName() {
		Collections.sort(list, new SortByName());
		for (AddressPerson person : list) {
			System.out.println(person.toString());
}
		
	}

	@Override
	public void sortByZip() {
		Collections.sort(list, new SortByZip());
		for (AddressPerson person : list) {
			System.out.println(person.toString());
}
		
	}

	@Override
	public void printAll() {
		for (AddressPerson P : list) {
			System.out.println(P.toString());
}
		
	}
	private AddressPerson addUser() {
		AddressPerson person = new AddressPerson();
		Address address = new Address();
		System.out.println("\n\t\t\tEnter First Name");
		person.setFirstname(JsonUtility.inputString());
		System.out.println(person.getFirstname());
		System.out.println("\n\t\t\tEnter Last Name");
		person.setLastname(JsonUtility.inputString());
		System.out.println("\n\t\t\tEnter city");
		address.setCity(JsonUtility.inputString());
		System.out.println("\n\t\t\tEnter State");
		address.setState(JsonUtility.inputString());
		System.out.println("\n\t\t\tEnter ZipCode");
		address.setZip(JsonUtility.inputLong());
		System.out.println("\n\t\t\tEnter Phone Number");
		person.setPhonenumber(JsonUtility.inputString());
		
		person.setAddress(address);
		return person;
}
	private void editAddressPhone(AddressPerson P, int i) {
		switch (i) {
		case 1:
			System.out.println("\n\t\t\tEnter the state");
			P.address.setState(JsonUtility.inputString());
			System.out.println("\n\t\t\tEnter the city");
			P.address.setCity(JsonUtility.inputString());
			System.out.println("\n\t\t\tEnter the ZipCode");
			P.address.setZip(JsonUtility.inputLong());
			System.out.println("\n\t\t\tNew Address updated");
			break;
		case 2:
			System.out.println("\n\t\t\tEnter the new Phone Number");
			String phoneNumber = JsonUtility.inputString();
			P.setPhonenumber(phoneNumber);
			System.out.println("\n\t\t\tNew Phone Number updated ");
			break;
		}
}
	public void save(String file) {
		try {
			mapper.writeValue(new File("AddressBook/" + file + ".json"), list);
			System.out.println("\n\t\t\tSaved");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	public void read(String existingAddressBook) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("AddressBook/" + existingAddressBook + ".json"));
			String arrayToJson;
			if ((arrayToJson = reader.readLine()) != null) {
				TypeReference<ArrayList<AddressPerson>> type = new TypeReference<ArrayList<AddressPerson>>() {
				};
				list = objectMapper.readValue(arrayToJson, type);
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	public void close(String existingAddressBook) {
		list.clear();
}
	public void saveAs() {
		System.out.println("\n\t\t\tEnter the name of the new file");
		String fileNameNew = JsonUtility.inputString();
		save(fileNameNew);
		System.out.println("\n\t\t\tData saved in new file");
}
	
	

}
