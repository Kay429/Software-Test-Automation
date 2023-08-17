package edu.snhu.kayleighkinsey;

import java.util.ArrayList;

public class ContactService {
	
	// Fields //
	private ArrayList<Contact> contactList = new ArrayList<Contact>();

	// ArrayList Management Methods //
	
	public void createNewContact(String id, String firstName, String lastName, String phone, String address) {
		// Check to see if id is already taken
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				throw new IllegalArgumentException("id " + id + " is already in use");
			}	
			i += 1;
		}
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		contactList.add(newContact);
	}
	
	public String deleteContact(String id) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				contactList.remove(i);
				return "successful deletion";
			}
			i += 1;
		}
		return "contact not in contactList";
	}
	
	// Update Contact Information Methods //
	
	public String updateContactFirstName(String id, String name) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				contactList.get(i).setFirstName(name);
				return "successful firstName update";
			}
			i += 1;
		}
		return "contact not in contactList";
	}
	
	public String updateContactLastName(String id, String name) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				contactList.get(i).setLastName(name);
				return "successful lastName update";
			}
			i += 1;
		}
		return "contact not in contactList";
	}
	
	public String updateContactPhone(String id, String phone) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				contactList.get(i).setPhone(phone);
				return "successful phone update";
			}
			i += 1;
		}
		return "contact not in contactList";
	}
	
	public String updateContactAddress(String id, String address) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				contactList.get(i).setAddress(address);
				return "successful address update";
			}
			i += 1;
		}
		return "contact not in contactList";
	}
	
	public Contact getContact(String id) {
		int i = 0;
		while (i < contactList.size()) {
			if (contactList.get(i).getId() == id) {
				return contactList.get(i);
			}
			i += 1;
		}
		return null;
	}
}