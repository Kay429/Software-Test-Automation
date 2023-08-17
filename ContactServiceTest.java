package edu.snhu.kayleighkinsey.tests;

import static org.junit.jupiter.api.Assertions.*;

import edu.snhu.kayleighkinsey.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

class ContactServiceTest {
	
	static ContactService contactService = new ContactService();
	
	@BeforeEach
	void setup() {
		contactService.createNewContact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
		contactService.createNewContact("67890", "Darius", "Hello", "5554313456", "612 Rainbow Street, Place");
		contactService.createNewContact("88888", "Jeff", "Huntington", "5550308383", "305 Lordly Lane, Cityland");
	}
	@AfterEach
	void teardown() {
		// These are the contact ids I will be using in the tests
		contactService.deleteContact("12345");
		contactService.deleteContact("67890");
		contactService.deleteContact("88888");
		contactService.deleteContact("56565");
	}
	
	// Adding New Contacts Test //
	
	@Test
	// This test makes sure the setup() function properly adds the contacts
	void ensureSetupWorks() {
		Contact contact = contactService.getContact("12345");
		assertEquals(contact.getId(), "12345");
		assertEquals(contact.getFirstName(), "Emily");
		assertEquals(contact.getLastName(), "Smith");
		assertEquals(contact.getPhone(), "5551239999");
		assertEquals(contact.getAddress(), "100 Street Town");
		
		contact = contactService.getContact("67890");
		assertEquals(contact.getId(), "67890");
		assertEquals(contact.getFirstName(), "Darius");
		assertEquals(contact.getLastName(), "Hello");
		assertEquals(contact.getPhone(), "5554313456");
		assertEquals(contact.getAddress(), "612 Rainbow Street, Place");
		
		contact = contactService.getContact("88888");
		assertEquals(contact.getId(), "88888");
		assertEquals(contact.getFirstName(), "Jeff");
		assertEquals(contact.getLastName(), "Huntington");
		assertEquals(contact.getPhone(), "5550308383");
		assertEquals(contact.getAddress(), "305 Lordly Lane, Cityland");
	}
	
	@Test
	void addNewContactUniqueId() {
		contactService.createNewContact("56565", "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		Contact contact = contactService.getContact("56565");
		assertEquals(contact.getId(), "56565");
		assertEquals(contact.getFirstName(), "Jeremy");
		assertEquals(contact.getLastName(), "Am");
		assertEquals(contact.getPhone(), "5556088010");
		assertEquals(contact.getAddress(), "333 Dark Shady Alley");
	}
	
	@Test
	// The Contact I just created should be gone due to teardown()
	void ensureTeardownWorks() {
		assertNull(contactService.getContact("56565"));
	}

	@Test
	void addNewContactTakenId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("12345", "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("88888", "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		});
	}
	
	@Test
	void addNewContactInvalidId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("12345678901", "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("", "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact(null, "Jeremy", "Am", "5556088010", "333 Dark Shady Alley");
		});
	}
	
	@Test
	void addNewContactInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Thisisaverylongname", "Am", "5556088010", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", null, "Am", "5556088010", "333 Dark Shady Alley");
		});
	}
	
	@Test
	void addNewContactInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Lord of the Shadows", "5556088010", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", null, "5556088010", "333 Dark Shady Alley");
		});
	}

	@Test
	void addNewContactInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Am", "555", "333 Dark Shady Alley");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Am", null, "333 Dark Shady Alley");
		});
		Assertions.assertThrows(NumberFormatException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Am", "1234Hello1", "333 Dark Shady Alley");
		});
	}
	
	@Test
	void addNewContactInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Am", "5556088010", "123456 NorthSouth Andromeda Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.createNewContact("56565", "Jeremy", "Am", "5556088010", null);
		});
	}
	
	// Deleting Contacts Test //
	
	@Test
	void delete1Contact() {
		assertEquals(contactService.deleteContact("12345"), "successful deletion");
		assertNull(contactService.getContact("12345"));
	}
	
	@Test
	void deleteAllContacts() {
		assertEquals(contactService.deleteContact("12345"), "successful deletion");
		assertEquals(contactService.deleteContact("67890"), "successful deletion");
		assertEquals(contactService.deleteContact("88888"), "successful deletion");
		assertNull(contactService.getContact("12345"));
		assertNull(contactService.getContact("67890"));
		assertNull(contactService.getContact("88888"));
	}
	
	@Test
	void deleteNonexistingContact() {
		assertEquals(contactService.deleteContact("56565"), "contact not in contactList");
	}
	
	// Update Fields Test //
	
	@Test
	void updateContactFirstName() {
		assertEquals(contactService.getContact("88888").getFirstName(), "Jeff");
		assertEquals(contactService.updateContactFirstName("88888", "Jonny"), "successful firstName update");
		assertEquals(contactService.getContact("88888").getFirstName(), "Jonny");
	}
	
	@Test
	void updateContactLastName() {
		assertEquals(contactService.getContact("88888").getLastName(), "Huntington");
		assertEquals(contactService.updateContactLastName("88888", "Brown"), "successful lastName update");
		assertEquals(contactService.getContact("88888").getLastName(), "Brown");
	}
	
	@Test
	void updateContactPhone() {
		assertEquals(contactService.getContact("88888").getPhone(), "5550308383");
		assertEquals(contactService.updateContactPhone("88888", "5559876543"), "successful phone update");
		assertEquals(contactService.getContact("88888").getPhone(), "5559876543");
	}
	
	@Test
	void updateContactAddress() {
		assertEquals(contactService.getContact("88888").getAddress(), "305 Lordly Lane, Cityland");
		assertEquals(contactService.updateContactAddress("88888", "444 MyRoad City"), "successful address update");
		assertEquals(contactService.getContact("88888").getAddress(), "444 MyRoad City");
	}
	
	@Test
	void updateContactInvalidFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("88888", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("88888", "TooLongName");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("88888", null);
		});
	}
	
	@Test
	void updateContactInvalidLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("88888", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("88888", "TooLongName");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("88888", null);
		});
	}
	
	@Test
	void updateContactInvalidPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("88888", "555323123");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("88888", "55532312345");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("88888", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("88888", "1234Hello1");
		});
	}
	
	@Test
	void updateContactInvalidAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("88888", "");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("88888", "123456 West Lunar Avenue Europa");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("88888", null);
		});
	}
	
	@Test
	void updateNonexistingContactFirstName() {
		assertEquals(contactService.updateContactFirstName("565656", "Jonny"), "contact not in contactList");
	}
	
	@Test
	void updateNonexistingContactLastName() {
		assertEquals(contactService.updateContactLastName("565656", "Brown"), "contact not in contactList");
	}
	
	@Test
	void updateNonexistingContactPhone() {
		assertEquals(contactService.updateContactPhone("565656", "5550308383"), "contact not in contactList");
	}
	
	@Test
	void updateNonexistingContactAddress() {
		assertEquals(contactService.updateContactAddress("565656", "444 MyRoad City"), "contact not in contactList");
	}
}
