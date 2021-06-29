package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		AddressBookService contact = new AddressBookService();
		
		while (true) {
			System.out.println("Please choose from below choices .");
			System.out.println(" 1 Add Contact "
					+ "\n 2 Edit Contact "
					+"\n 3 Delete Contact "
					+ "\n 4 Display Contact "
					+ "\n 5 Quit ");
			int userChoice = scanner.nextInt();
			switch (userChoice) 
			{
				case 1:
					System.out.println("Enter How many numbers You want to Add ::");
					int size = scanner.nextInt();
					for (int i = 0; i < size; i++) {
						contact.addContact();
					}			
					break;
				case 2:
					System.out.println("Enter the Email");
					String email = scanner.next();
					boolean updated = contact.editContact(email);	
					if(updated)
					{
						System.out.println("Contact Updated.");
					}
					else
					{
						System.out.println("Contact not found");
					}
					break;
				case 3:
					System.out.println("Enter the Email Address");
					String emailToDelete = scanner.next();
					 boolean status = contact.deleteContact(emailToDelete);
					 if(status)
						{
							System.out.println("Contact Deleted Successfully");
						}
						else
						{
							System.out.println("Contact not found");
						}
					 break;
				case 4:	
					contact.diaplayContacts();
					break;
				default:
					System.out.println("You just Quit");
					System.exit(0);
			}
			
		}
	}

}
