package com.bridgelabz.AddressBook.AddressBook;

import java.io.IOException;
import java.util.*;

public class MultipleAddressBook {
	public static Scanner sc = new Scanner(System.in);

	// to perform different operations on contacts
	public static void choice(int choice, AddressBookMain object) {
		switch (choice) {
		case 1:
			object.insertContact(); // add a new contact into addressbook
			break;

		case 2:
			object.edit(); // edit existing contact
			break;

		case 3:
			object.delete(); // delete the preferred contact
			break;

		case 4:
			object.display(); // display desired contact
			break;

		case 5:
			object.display_addressbook(); // display whole addressbook
			break;
		default:
			System.out.println("Please enter a valid number");
			break;
		}

	}

	public static void main(String[] args) throws IOException {
		// dictionary for mapping different address book with key
		HashMap<String, AddressBookMain> multipleAddressBook = new HashMap<String, AddressBookMain>();
		AddressBookMain object = new AddressBookMain(); // first addressbook

		String addressBookName = "firstBook";
		multipleAddressBook.put(addressBookName, object); // put the first addressbook into dictionary
		boolean flag = true;
		while (flag == true) // it repeats till the user wants to end
		{
			// options for different actions
			System.out.println("Enter your choice\n" + "1.add contact\n" + "2.edit contact\n" + "3.Delete contact\n"
					+ "4.Display contact\n" + "5.Display addressbook\n" + "6.Create another address book\n"
					+ "7.Display all adressBook\n" + "8.Search for city or state\n" + "9.view person by state\n"
					+ "10.view person by city\n" + "11.Sort list by Name,city,state or zip\n" + "12.Add to file\n"
					+ "13.read from file\n" + "14.exit");

			int choice = sc.nextInt();
			sc.nextLine();
			if (choice == 6) // to create a new address book
			{
				System.out.println("Enter the name of AddressBook to create");
				addressBookName = sc.nextLine();
				AddressBookMain object1 = new AddressBookMain(); // a new addressbook object is created
				multipleAddressBook.put(addressBookName, object1);
			} else if (choice == 7) {
				for (Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet()) {
					System.out.println(entry.getKey());
				}
			} else if (choice == 8) {
				System.out.println("Enter the name of city or state");
				String place = sc.next();
				System.out.println("Persons whose state or city is " + place);
				for (Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet()) {
					AddressBookMain object1 = entry.getValue();
					object1.search(place);
				}
			} else if (choice == 9) {
				for (Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet()) {
					AddressBookMain object1 = entry.getValue();
					System.out.println("Addressbook:" + entry.getKey());
					object1.viewPersonByState();
				}

			} else if (choice == 10) {
				for (Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet()) {
					AddressBookMain object1 = entry.getValue();
					System.out.println("Addressbook:" + entry.getKey());
					object1.viewPersonByCity();
				}
			} else if (choice == 11) {
				System.out.println("sort By 1.Name 2.city 3.state 4.zip");
				int option = sc.nextInt();
				for (Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet()) {
					AddressBookMain object1 = entry.getValue();
					System.out.println("Addressbook:" + entry.getKey());
					object1.sortPersonByNameCityStateZip(option);
				}
			} else if (choice == 12) {
				System.out.println("Enter the addressbook which you want to add into file!!");
				String AddressBook = sc.next();
				multipleAddressBook.get(AddressBook).writeFile(AddressBook);
			} else if (choice == 13) {
				System.out.println("Enter the addressbook which you waant to read");
				String AddressBook = sc.next();
				multipleAddressBook.get(AddressBook).readFile(AddressBook);
			} else if (choice == 14) // to exist from the program
				flag = false;
			else {
				System.out.println("Enter the Name of addressbook");
				addressBookName = sc.nextLine();
				try {
					choice(choice, multipleAddressBook.get(addressBookName)); // to perform required operation on
																				// desired addressbook
				} catch (Exception e) {
					System.out.println("Address book not found...create it first");

				}
			}
		}
	}
}
