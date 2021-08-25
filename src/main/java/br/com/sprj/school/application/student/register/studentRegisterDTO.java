package br.com.sprj.school.application.student.register;

import br.com.sprj.school.domain.student.Email;
import br.com.sprj.school.domain.student.SSN;
import br.com.sprj.school.domain.student.Student;

public class studentRegisterDTO {

    private String name;

    private String ssn;

    private String email;

    public studentRegisterDTO(String name, String ssn, String email) {
	this.name = name;
	this.ssn = ssn;
	this.email = email;
    }

    public Student createStudent() {
	return new Student(new SSN(ssn), name, new Email(email));
    }

}