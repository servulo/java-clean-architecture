package br.com.sprj.school.domain.student;

public class RegisterStudent {

    public static void main(String[] args) {

	String name = "Servulo Pires da Rocha Junior";
	SSN ssn = new SSN("");
	Email email = new Email("servulo.jr@gmail.com");

	Student student = new Student(ssn, name, email);

    }

}
