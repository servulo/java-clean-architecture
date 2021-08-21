package br.com.sprj.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private SSN ssn;
    private String name;
    private Email email;
    private List<Telephone> telephones = new ArrayList<Telephone>();
    private String password;

    public Student(SSN ssn, String name, Email email) {
	this.ssn = ssn;
	this.name = name;
	this.email = email;
    }

    public void addTelephone(String areaCode, String number) {
	this.telephones.add(new Telephone(areaCode, number));
    }

    public String getSsn() {
	return ssn.getNumber();
    }

    public String getName() {
	return name;
    }

    public String getEmail() {
	return email.getAddress();
    }

    public List<Telephone> getTelephones() {
	return telephones;
    }

}