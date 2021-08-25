package br.com.sprj.school.application.student.register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.sprj.school.domain.student.SSN;
import br.com.sprj.school.domain.student.Student;
import br.com.sprj.school.infra.student.StudentRepositoryInMemory;

class StudentRegisterTest {

    @Test
    void studentShouldBePersisted() {

	StudentRepositoryInMemory studentRepository = new StudentRepositoryInMemory();
	StudentRegister useCase = new StudentRegister(studentRepository);

	String name = "S�rvulo Pires da Rocha J�nior";
	String ssn = "004-78-0249";
	String email = "servulo.jr@gmail.com";

	studentRegisterDTO studentData = new studentRegisterDTO(name, ssn, email);

	useCase.register(studentData);

	Student findBySsn = studentRepository.findBySSN(new SSN(ssn));

	assertEquals(name, findBySsn.getName());
	assertEquals(ssn, findBySsn.getSsn());
	assertEquals(email, findBySsn.getEmail());
	
    }
}
