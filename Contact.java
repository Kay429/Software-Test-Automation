package edu.snhu.kayleighkinsey;

public class Contact {
	
	// Fields //
	
	private final String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructor //
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		validateAll(id, firstName, lastName, phone, address);
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Accessors and Mutators //
	
	public String getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		validateName(firstName);
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		validateName(lastName);
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhone(String phone) {
		validatePhone(phone);
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setAddress(String address) {
		validateAddress(address);
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	// Field Validation //
	
	private void validateAll(String id, String firstName, String lastName, String phone, String address) {
		validateId(id);
		validateName(firstName);
		validateName(lastName);
		validatePhone(phone);
		validateAddress(address);
	}
	
	private void validateId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null.");
		}
		else if (id == "") {
			throw new IllegalArgumentException("id cannot be an empty string.");
		}
		else if (id.length() > 10) {
			throw new IllegalArgumentException("id cannot be more than 10 characters.");
		}
	}
	
	private void validateName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null.");
		}
		else if (name == "") {
			throw new IllegalArgumentException("name cannot be an empty string.");
		}
		else if (name.length() > 10) {
			throw new IllegalArgumentException("name cannot be more than 10 characters.");
		}
	}
	
	private void validatePhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("phone cannot be null.");
		}
		else if (phone.length() != 10) {
			throw new IllegalArgumentException("phone must be exactly 10 characters.");
		}
		else {
			// If phone isn't a number,
			// a NumberFormatException will be thrown
			Long.parseLong(phone);	
		}
	}
	
	private void validateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("address cannot be null.");
		}
		else if (address == "") {
			throw new IllegalArgumentException("address cannot be an empty string.");
		}
		else if (address.length() > 30) {
			throw new IllegalArgumentException("address cannot be more than 30 characters.");
		}
	}
	
}
