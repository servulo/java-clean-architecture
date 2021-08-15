package br.com.sprj.school.domain.student;

public class Telephone {

    private String areaCode;
    private String number;

    public Telephone(String areaCode, String number) {

	if (areaCode == null || number == null) {
	    throw new IllegalArgumentException("Area Code and Phone Number must be provided!");
	}

	if (!areaCode.matches("\\d{3}")) {
	    throw new IllegalArgumentException("Invalid Area Code!");
	}

	if (!number.matches("\\d{7}")) {
	    throw new IllegalArgumentException("Invalid Phone Number!");
	}

	this.areaCode = areaCode;
	this.number = number;
    }

    public String getAreaCode() {
	return areaCode;
    }

    public String getNumber() {
	return number;
    }

}