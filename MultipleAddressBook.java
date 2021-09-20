package com.bridgelabz.AddressBook.AddressBook;
import java.util.*; 

public class MultipleAddressBook 
{  
	public static Scanner sc=new Scanner(System.in);

	//to perform different operations on contacts
	public static void choice(int choice,AddressBookMain object)     
	{											
		switch(choice)
		{
		case 1:	object.insertContact();			//add a new contact into addressbook
		break;

		case 2:object.edit();					//edit existing contact							
		break;

		case 3: object.delete();				//delete the preferred contact
		break;

		case 4: object.display();				//display desired contact
		break;

		case 5:object.display_addressbook();	//display whole addressbook
		break;	
		}		

	}

	public static void main(String[] args) 
	{
		//dictionary for mapping different address book with key 
		HashMap<String,AddressBookMain>  multipleAddressBook = new HashMap<String, AddressBookMain>();  
		AddressBookMain object=new AddressBookMain();  //first addressbook

		String addressBookName = "firstBook";
		multipleAddressBook.put(addressBookName, object);			//put the first addressbook into dictionary
		boolean flag = true;
		while(flag == true) //it repeats till the user wants to end
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Delete "
					+ "contact\n4.Display contact\n5.Display addressbook\n"
					+ "6.Create another address book\n7.Display all adressBook\n8.Search for city or state\\n9.exit"); //options for different actions
			int choice=sc.nextInt();
			sc.nextLine();
			if(choice==6)  //to create a new address book
			{
				System.out.println("Enter the name of AddressBook to create");
				addressBookName = sc.nextLine();
				AddressBookMain object1=new AddressBookMain();  // a new addressbook object is created 
				multipleAddressBook.put(addressBookName, object1);	
			}
			else if(choice==7)
			{
			    for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
			    {
			        System.out.println(entry.getKey());
			    }
			}
			else if(choice==8)
			{
			    System.out.println("Enter the name of city or state");
			    String place=sc.next();
			    System.out.println("Persons whose state or city is "+place);
			    for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
			    {
			        AddressBookMain object1=entry.getValue();
			        object1.search(place);
			    }
			      
			}
			else if(choice==9)				//to exist from the program
				flag = false;
			else
			{
				System.out.println("Enter the Name of addressbook");
				addressBookName=sc.nextLine();
				try {
					choice(choice,multipleAddressBook.get(addressBookName));   //to perform required operation on desired addressbook
				}catch(Exception e) {
					System.out.println("Address book not found...create it first");

				}
			}		
		}
	}	
}
