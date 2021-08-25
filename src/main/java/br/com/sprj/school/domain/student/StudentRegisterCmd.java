package br.com.sprj.school.domain.student;

import br.com.sprj.school.application.student.register.StudentRegister;
import br.com.sprj.school.application.student.register.studentRegisterDTO;
import br.com.sprj.school.infra.student.StudentRepositoryInMemory;

public class StudentRegisterCmd {

    public static void main(String[] args) {

	String name = "S�rvulo Pires da Rocha J�nior";
	String ssn = "004-78-0249";
	String email = "servulo.jr@gmail.com";

	StudentRegister register = new StudentRegister(new StudentRepositoryInMemory());
	register.register(new studentRegisterDTO(name, ssn, email));

    }

}
