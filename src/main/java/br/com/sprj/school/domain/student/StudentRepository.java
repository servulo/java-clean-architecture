package br.com.sprj.school.domain.student;

import java.util.List;

public interface StudentRepository {

    void register(Student student);

    Student findBySSN(SSN ssn);

    List<Student> findAll();

}