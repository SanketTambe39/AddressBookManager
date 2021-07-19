package com.bridgelabz.addressbook;

import java.util.Comparator;
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
			addContactToExsistingBook(contact, bookName, contactList);
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
	public void displayContacts(LinkedList<Contact> contactList) {
		addressBooks.entrySet().stream()
		.map(books->books.getKey())
		.map(bookNames->{
			System.out.println(bookNames); 
			return addressBooks.get(bookNames); 
		})
		.forEach(contactInBook->System.out.println(contactInBook));
	}

	public void displayContact() {
		for (String bookName : addressBooks.keySet()) {
			System.out.println(bookName);
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			displayContacts(contactList);
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

	// check Duplicate using name
	private void addContactToExsistingBook(Contact contact, String bookName, LinkedList<Contact> contactList) {
		boolean isAlreadyExsist = contactList.stream()
				.anyMatch(contactsInlist->contactsInlist.getFirstname()==contact.getFirstname());
		if (!(isAlreadyExsist)) {
			contactList.add(contact);
			addressBooks.put(bookName, contactList);
			System.out.println("New Contact Added Sucessfully");
		} else {
			System.out.println("Contact already exsist");
		}
	}

	// method to search multiple person in city and state
	public int searchPerson(String searchKey) {
		int count = 0;
		for (String bookName : addressBooks.keySet()) {
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			contactList.stream()
			.filter(n->n.getState()==searchKey || n.getCity() == searchKey)
			.forEach(n->System.out.println(n.getFirstname()+" "+n.getLastname()));
		}
		return count; 
	}

	// method to view person in address book
	public void viewPerson(String viewKey) {
		for (String bookName : addressBooks.keySet()) {
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			contactList.stream()
			.filter(contact->contact.getState()==viewKey || contact.getCity() == viewKey)
			.forEach(contact->System.out.println(contact));
		}
	}
	//method to sort contacts based on person name
		public void sortContacts()
		{
			for (String bookName : addressBooks.keySet())
			{
				LinkedList<Contact> contatct = addressBooks.get(bookName);
			 	contatct.stream().sorted(Comparator.comparing(Contact::getFirstname)).forEach(n->System.out.println(n));
			}
		}
		//method to sort by city state or zip
		public void sortBY(int sortByWhich)
		{
			switch (sortByWhich)
			{
			case 1:
				for (String bookName : addressBooks.keySet())
				{
					LinkedList<Contact> contatct = addressBooks.get(bookName);
				 	contatct.stream().sorted(Comparator.comparing(Contact::getCity)).forEach(n->System.out.println(n));
				}
				break;
			case 2:
				for (String bookName : addressBooks.keySet())
				{
					LinkedList<Contact> contatct = addressBooks.get(bookName);
					contatct.stream().sorted(Comparator.comparing(Contact::getState)).forEach(n->System.out.println(n));
				}
				break;
			case 3:				
				for (String bookName : addressBooks.keySet())
				{
					LinkedList<Contact> contatct = addressBooks.get(bookName);
					contatct.stream().sorted(Comparator.comparing(Contact::getZipcode)).forEach(n->System.out.println(n));
				}
				break;
			default:
				System.out.println("Invalid Inout");
				break;
			}

		}
}
