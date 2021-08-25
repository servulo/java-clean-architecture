package br.com.sprj.school.domain.student;

import br.com.sprj.school.application.student.register.StudentRegister;
import br.com.sprj.school.application.student.register.studentRegisterDTO;
import br.com.sprj.school.infra.student.StudentRepositoryInMemory;

public class StudentRegisterCmd {

    public static void main(String[] args) {

	String name = "Sérvulo Pires da Rocha Júnior";
	String ssn = "004-78-0249";
	String email = "servulo.jr@gmail.com";

	StudentRegister register = new StudentRegister(new StudentRepositoryInMemory());
	register.register(new studentRegisterDTO(name, ssn, email));

    }

}
