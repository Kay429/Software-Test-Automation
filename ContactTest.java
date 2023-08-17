/**
 * 
 */
package edu.snhu.kayleighkinsey.tests;

import static org.junit.jupiter.api.Assertions.*;

import edu.snhu.kayleighkinsey.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ContactTest {
	
	  // Contact Id Tests //
	
		@Test
		void newContact5CharId() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getId(), "12345");
		}
		
		@Test
		void newContact1CharId() {
			Contact contact = new Contact("1", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getId(), "1");
		}
		
		@Test
		void newContact0CharId() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("", "Emily", "Smith", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContact9CharId() {
			Contact contact = new Contact("12345idnm", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getId(), "12345idnm");
		}
		
		@Test
		void newContact10CharId() {
			Contact contact = new Contact("12345idnum", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getId(), "12345idnum");
		}
		
		@Test
		void newContact11CharId() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("idistoolong", "Emily", "Smith", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContactNullId() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "Emily", "Smith", "5551239999", "100 Street Town");
			});
		}
		
		// Contact FirstName Tests //
	
		@Test
		void newContact5CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getFirstName(), "Emily");
		}
		
		@Test
		void newContact1CharFirstName() {
			Contact contact = new Contact("12345", "O", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getFirstName(), "O");
		}
		
		@Test
		void newContact0CharFirstName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "", "Smith", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContact9CharFirstName() {
			Contact contact = new Contact("12345", "OkLngName", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getFirstName(), "OkLngName");
		}
		
		@Test
		void newContact10CharFirstName() {
			Contact contact = new Contact("12345", "OkLongName", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getFirstName(), "OkLongName");
		}
		
		@Test
		void newContact11CharFirstName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "TooLongName", "Smith", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContactNullFirstName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", null, "Smith", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void setContact5CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setFirstName("Jonny");
			assertEquals(contact.getFirstName(), "Jonny");
		}
		
		@Test
		void setContact1CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setFirstName("O");
			assertEquals(contact.getFirstName(), "O");
		}
		
		@Test
		void setContact0CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setFirstName("");
			});
		}
		
		@Test
		void setContact9CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setFirstName("OkLngName");
			assertEquals(contact.getFirstName(), "OkLngName");
		}
		
		@Test
		void setContact10CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setFirstName("OkLongName");
			assertEquals(contact.getFirstName(), "OkLongName");
		}
		
		@Test
		void setContact11CharFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setFirstName("TooLongName");
			});
		}
		
		@Test
		void setContactNullFirstName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setFirstName(null);
			});
		}
		
		// Contact Last Name Test //
		
		@Test
		void newContact5CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getLastName(), "Smith");
		}
		
		@Test
		void newContact1CharLastName() {
			Contact contact = new Contact("12345", "Emily", "O", "5551239999", "100 Street Town");
			assertEquals(contact.getLastName(), "O");
		}
		
		@Test
		void newContact0CharLastName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContact9CharLastName() {
			Contact contact = new Contact("12345", "Emily", "OkLngName", "5551239999", "100 Street Town");
			assertEquals(contact.getLastName(), "OkLngName");
		}
		
		@Test
		void newContact10CharLastName() {
			Contact contact = new Contact("12345", "Emily", "OkLongName", "5551239999", "100 Street Town");
			assertEquals(contact.getLastName(), "OkLongName");
		}
		
		@Test
		void newContact11CharLastName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "TooLongName", "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void newContactNullLastName() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", null, "5551239999", "100 Street Town");
			});
		}
		
		@Test
		void setContact5CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setLastName("Brown");
			assertEquals(contact.getLastName(), "Brown");
		}
		
		@Test
		void setContact1CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setLastName("O");
			assertEquals(contact.getLastName(), "O");
		}
		
		@Test
		void setContact0CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setLastName("");
			});
		}
		
		@Test
		void setContact9CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setLastName("OkLngName");
			assertEquals(contact.getLastName(), "OkLngName");
		}
		
		@Test
		void setContact10CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setLastName("OkLongName");
			assertEquals(contact.getLastName(), "OkLongName");
		}
		
		@Test
		void setContact11CharLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setLastName("TooLongName");
			});
		}
		
		@Test
		void setContactNullLastName() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setLastName(null);
			});
		}
		
		// Contact Phone Test //
		
		@Test
		void newContact10CharPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getPhone(), "5551239999");
		}
		
		@Test
		void newContact9CharPhone() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", "555123123", "100 Street Town");
			});
		}
		
		@Test
		void newContact11CharPhone() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", "55512399990", "100 Street Town");
			});
		}

		@Test
		void newContactNullPhone() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", null, "100 Street Town");
			});
		}
		
		@Test
		void newContactNonIntegerPhone() {
			Assertions.assertThrows(NumberFormatException.class, () -> {
				new Contact("12345", "Emily", "Smith", "3321hello1", "100 Street Town");
			});
			Assertions.assertThrows(NumberFormatException.class, () -> {
				new Contact("12345", "Emily", "Smith", "3321h43211", "100 Street Town");
			});
		}
		
		@Test
		void setContact10CharPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setPhone("5559876543");
			assertEquals(contact.getPhone(), "5559876543");
		}
		
		@Test
		void setContact9CharPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone("555323123");
			});
		}
		
		@Test
		void setContact11CharPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone("55532312345");
			});
		}

		@Test
		void setContactNullPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setPhone(null);
			});
		}
		
		@Test
		void setContactNonIntegerPhone() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(NumberFormatException.class, () -> {
				contact.setPhone("3321hello1");
			});
			Assertions.assertThrows(NumberFormatException.class, () -> {
				contact.setPhone("3321h43211");
			});
		}
		
		// Contact Address Test //
		
		@Test
		void newContact15CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			assertEquals(contact.getAddress(), "100 Street Town");
		}
		
		@Test
		void newContact1CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "O");
			assertEquals(contact.getAddress(), "O");
		}
		
		@Test
		void newContact0CharAddress() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", "5551239999", "");
			});
		}
		
		@Test
		void newContact29CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "1234 West Lunar Avenue Europa");
			assertEquals(contact.getAddress(), "1234 West Lunar Avenue Europa");
		}
		
		@Test
		void newContact30CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "12345 West Lunar Avenue Europa");
			assertEquals(contact.getAddress(), "12345 West Lunar Avenue Europa");
		}
		
		@Test
		void newContact31CharAddress() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", "5551239999", "123456 West Lunar Avenue Europa");
			});
		}
		
		@Test
		void newContactNullAddress() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345", "Emily", "Smith", "5551239999", null);
			});
		}
		
		@Test
		void setContact15CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setAddress("444 MyRoad City");
			assertEquals(contact.getAddress(), "444 MyRoad City");
		}
		
		@Test
		void setContact1CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setAddress("O");
			assertEquals(contact.getAddress(), "O");
		}
		
		@Test
		void setContact0CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setAddress("");
			});
		}
		
		@Test
		void setContact29CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setAddress("1234 West Lunar Avenue Europa");
			assertEquals(contact.getAddress(), "1234 West Lunar Avenue Europa");
		}
		
		@Test
		void setContact30CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			contact.setAddress("12345 West Lunar Avenue Europa");
			assertEquals(contact.getAddress(), "12345 West Lunar Avenue Europa");
		}
		
		@Test
		void setContact31CharAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setAddress("123456 West Lunar Avenue Europa");
			});
		}
		
		@Test
		void setContactNullAddress() {
			Contact contact = new Contact("12345", "Emily", "Smith", "5551239999", "100 Street Town");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contact.setAddress(null);
			});
		}
		
}