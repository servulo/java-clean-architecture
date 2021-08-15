package br.com.sprj.school.domain.student;

public class SSN {

    private String number;

    public SSN(String number) {
	if ((number == null) || !number.matches("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$")) {
	    throw new IllegalArgumentException("Invalid SSN");
	}
	this.number = number;
    }

    public String getNumber() {
	return number;
    }

}