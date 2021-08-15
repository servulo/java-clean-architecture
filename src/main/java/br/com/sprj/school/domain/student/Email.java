package br.com.sprj.school.domain.student;

public class Email {

    private String address;

    public Email(String address) {
	if ((address == null) || !address.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
	    	                                  
	    throw new IllegalArgumentException("Invalid e-mail");
	}
	this.address = address;
    }

    public String getAddress() {
	return address;
    }

}