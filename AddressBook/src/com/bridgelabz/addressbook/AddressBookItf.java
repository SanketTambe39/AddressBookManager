package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookItf {

	private int index = 0;
	Contact[] contacts = new Contact[7];
	public Contact addContact()
	{
		Scanner scanner = new Scanner(System.in);
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
		return contact;
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
