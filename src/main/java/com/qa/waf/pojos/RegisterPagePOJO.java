package com.qa.waf.pojos;

public class RegisterPagePOJO {

	// private variables
	// parameterised constructors to initialize the variables with data
	// getter setter methods
	// to String method

	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String password;

	public RegisterPagePOJO(String firstName, String lastName, String email, String telephone, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.password = password;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterPagePOJO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", telephone=" + telephone + ", password=" + password + "]";
	}
	
	
	

}
