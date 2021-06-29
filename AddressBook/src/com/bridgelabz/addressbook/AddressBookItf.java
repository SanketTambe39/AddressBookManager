package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookItf {

	private int index = 0;
	Contact[] contacts = new Contact[20];
	Scanner scanner = new Scanner(System.in);
	public void addContact()
	{
		System.out.println("Enter First Name");
		String firstName = scanner.next();
		
		System.out.println("Enter last Name");
		String lastName = scanner.next();
		
		System.out.println("Enter City");
		String city = scanner.next();
		
		System.out.println("Enter State");
		String state = scanner.next();
		
		System.out.println("Enter zip");
		int zip = scanner.nextInt();
		
		System.out.println("Enter Phone Number");
		String phoneNumber = scanner.next();
		
		System.out.println("Enter Email");
		String email = scanner.next();
		Contact contact = new Contact( firstName, lastName, city, state, zip, phoneNumber, email);
		contacts[index++]= contact;
	}
	
	public boolean editContact(String email)
	{
		for (int i = 0; i < contacts.length; i++) 
		{
			if(contacts[i] != null && contacts[i].getEmail().equalsIgnoreCase(email)) 
			{
				System.out.println("Enter First Name");
				String firstName = scanner.next();
				
				System.out.println("Enter last Name");
				String lastName = scanner.next();
			
				System.out.println("Enter City");
				String city = scanner.next();
				
				System.out.println("Enter State");
				String state = scanner.next();
				
				System.out.println("Enter zip");
				String zip = scanner.next();
				
				contacts[i].setFirstname(firstName);
				contacts[i].setLastname(lastName);
				contacts[i].setCity(city);
				contacts[i].setState(state);
				contacts[i].setState(zip);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteContact(String email) {

		for (int i = 0; i < contacts.length; i++) 
		{
			if(contacts[i] != null && contacts[i].getEmail().equalsIgnoreCase(email) )
			{ 
				for (int j=i; j < contacts.length-2 ; j++)
				{					
					contacts[j] = contacts[j+1];
				}
				return true;
			}

		}
		return false;
	}


	
	public void diaplayContacts() {
		for (int i = 0; i < contacts.length; i++) {
			if(contacts[i] != null) 
			{
				System.out.println(contacts[i]);
			}
		}
	} 
	
}
