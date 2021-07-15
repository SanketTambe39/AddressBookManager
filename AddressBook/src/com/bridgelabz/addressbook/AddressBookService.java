package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookService {

	HashMap<String, LinkedList<Contact>> addressBooks = new HashMap<>();
	LinkedList<Contact> allContacts = new LinkedList<Contact>();
	Scanner scanner = new Scanner(System.in);

	/**
	 * Method to add contacts
	 */
	public Contact addContact() {
		Contact contact = new Contact();
		System.out.println("Enter First Name");
		contact.setFirstname(scanner.next());
		System.out.println("Enter Last Name");
		contact.setLastname(scanner.next());
		System.out.println("Enter City");
		contact.setCity(scanner.next());
		System.out.println("Enter State");
		contact.setState(scanner.next());
		System.out.println("Enter Pincode");
		contact.setZipcode(scanner.nextInt());
		System.out.println("Enter Phone Number");
		contact.setPhonenumber(scanner.next());
		System.out.println("Enter Email");
		contact.setEmail(scanner.next());
		System.out.println("Enter Book name to which you have to add contact");
		String bookName = scanner.next();

		// checking book already exist
		if (addressBooks.containsKey(bookName)) {
			// if exist then add contact to list
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			contactList.add(contact);
			addressBooks.put(bookName, contactList);
			System.out.println("New Contact Added Sucessfully");
		} else {
			// creating a new book and list
			allContacts.add(contact);
			addressBooks.put(bookName, allContacts);
			System.out.println("New book created and Contact Added Sucessfully");
		}

		return contact;
	}

	/**
	 * Method to Edit contact using unique phoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean editContact(String phoneNumber) {
		for (Contact contact : allContacts) {
			if (contact.getPhonenumber() == phoneNumber) {
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
				contact.setFirstname(firstName);
				contact.setLastname(lastName);
				contact.setCity(city);
				contact.setState(state);
				contact.setState(zip);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	/**
	 * Method to Delete contact using unique phoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean deleteContact(String phoneNumber) {

		for (Contact contact : allContacts) {
			if (contact.getPhonenumber() == phoneNumber) {
				allContacts.remove(contact);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	/**
	 * Method to Display the Contact Details
	 */
	public void displayContacts() {
		for (Contact contact : allContacts) {
			System.out.println(contact);
		}
	}

	/**
	 * Method to check the status of operation whether it is done properly or not
	 * 
	 * @param status
	 * @return
	 */
	private static boolean operationStatus(boolean status) {
		if (status) {
			System.out.println("Contact Updated Successfully");
		} else {
			System.out.println("Contact not found");
		}
		return status;
	}
	
	//check Duplicate using name
		private void addContactToExsistingBook(Contact contact, String bookName, LinkedList<Contact> contactList)
		{
			boolean isAlreadyExsist = false;
			for (Contact searchContact : contactList) 
			{
				if (searchContact.getFirstname().equals(contact.getFirstname()))
				{
					isAlreadyExsist = true;
					break;
				}
			}
			if( !(isAlreadyExsist) )
			{
				contactList.add(contact);				
				addressBooks.put(bookName, contactList);
				System.out.println("New Contact Added Sucessfully");
			}
			else
			{
				System.out.println("Contact already exsist");
			}
		}

		//method to search multiple person in city and state
		public void searchPerson(String searchKey)
		{
			for (String bookName : addressBooks.keySet())
			{
				LinkedList<Contact> contactList  =  addressBooks.get(bookName);
				for (Contact contact : contactList) 
				{
					if (contact.getCity().equals(searchKey) ||  contact.getState().equals(searchKey) )
					{
						System.out.println(contact.getFirstname() + ""+ contact.getLastname());

					}
				}
			}
		}
		// method to view person in addressbook
		public void viewPerson(String viewKey) 
		{		
			for (String bookName : addressBooks.keySet())
			{
				LinkedList<Contact> contactList  =  addressBooks.get(bookName);
				for (Contact contact : contactList) 
				{
					if (contact.getCity().equals(viewKey) ||  contact.getState().equals(viewKey) )
					{
						System.out.println(contact);

					}
				}
			}
			
		}
}
