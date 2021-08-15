package br.com.sprj.school.domain.student;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameSsnEmail(String name, String ssn, String email) {
	this.student = new Student(new SSN(ssn), name, new Email(email));
	return this;
    }

    public StudentFactory withTelephone(String areaCode, String number) {
	this.student.addTelephone(areaCode, number);
	return this;
    }

    public Student create() {
	return this.student;
    }

}