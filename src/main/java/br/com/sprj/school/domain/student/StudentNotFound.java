package br.com.sprj.school.domain.student;

public class StudentNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StudentNotFound(SSN ssn) {
	super("Student not found - SSN: " + ssn.getNumber());
    }

}