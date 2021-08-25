package br.com.sprj.school.application.student.register;

import br.com.sprj.school.domain.student.Student;
import br.com.sprj.school.domain.student.StudentRepository;

public class StudentRegister {

    private final StudentRepository studentRepository;

    public StudentRegister(StudentRepository studentRepository) {
	this.studentRepository = studentRepository;
    }

    public void register(studentRegisterDTO data) {
	Student newStudent = data.createStudent();
	studentRepository.register(newStudent);
    }

}