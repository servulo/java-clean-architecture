package br.com.sprj.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import br.com.sprj.school.domain.student.SSN;
import br.com.sprj.school.domain.student.Student;
import br.com.sprj.school.domain.student.StudentNotFound;
import br.com.sprj.school.domain.student.StudentRepository;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> registered = new ArrayList<>();

    @Override
    public void register(Student student) {
	this.registered.add(student);

    }

    @Override
    public Student findBySSN(SSN ssn) {
	return this.registered.stream().filter(a -> a.getSsn().equals(ssn.getNumber())).findFirst()
		.orElseThrow(() -> new StudentNotFound(ssn));
    }

    @Override
    public List<Student> findAll() {
	return this.registered;
    }

}