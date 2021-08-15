package br.com.sprj.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sprj.school.domain.student.Email;
import br.com.sprj.school.domain.student.SSN;
import br.com.sprj.school.domain.student.Student;
import br.com.sprj.school.domain.student.StudentNotFound;
import br.com.sprj.school.domain.student.StudentRepository;
import br.com.sprj.school.domain.student.Telephone;

public class StudentRepositoryJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
	this.connection = connection;
    }

    @Override
    public void register(Student student) {
	try {
	    String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
	    PreparedStatement ps = connection.prepareStatement(sql);

	    ps.setString(1, student.getSsn());
	    ps.setString(2, student.getName());
	    ps.setString(3, student.getEmail());
	    ps.execute();

	    sql = "INSERT INTO TELEPHONE VALUES(?, ? )";

	    ps = connection.prepareStatement(sql);

	    for (Telephone telephone : student.getTelephones()) {
		ps.setString(1, telephone.getAreaCode());
		ps.setString(2, telephone.getNumber());
		ps.execute();
	    }

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public Student findBySSN(SSN ssn) {
	try {
	    String sql = "SELECT id, name, email FROM STUDENT WHERE ssn = ?";
	    PreparedStatement ps = connection.prepareStatement(sql);

	    ps.setString(1, ssn.getNumber());

	    ResultSet rs = ps.executeQuery();

	    boolean found = rs.next();
	    if (!found) {
		throw new StudentNotFound(ssn);
	    }

	    String name = rs.getString("name");
	    Email email = new Email(rs.getString("email"));
	    Student foundStudent = new Student(ssn, name, email);

	    Long id = rs.getLong("id");

	    sql = "SELECT areacode, number FROM TELEPHONE WHERE id = ?";

	    ps = connection.prepareStatement(sql);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();

	    while (rs.next()) {
		String number = rs.getString("number");
		String areaCode = rs.getString("areacode");
		foundStudent.addTelephone(areaCode, number);
	    }

	    return foundStudent;

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<Student> findAll() {
	try {
		String sql = "SELECT id, ssn, name, email FROM STUDENT";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> students = new ArrayList<>();
		while (rs.next()) {
			SSN ssn = new SSN(rs.getString("ssn"));
			String name = rs.getString("name");
			Email email = new Email(rs.getString("email"));
			Student student = new Student(ssn, name, email);
			Long id = rs.getLong("id");
			sql = "SELECT areacode, number FROM TELEPHONE WHERE student_id = ?";
			PreparedStatement psTelephone = connection.prepareStatement(sql);
			psTelephone.setLong(1, id);
			ResultSet rsTelephone = psTelephone.executeQuery();
			while (rsTelephone.next()) {
				String number = rsTelephone.getString("number");
				String areaCode = rsTelephone.getString("areaCode");
				student.addTelephone(areaCode, number);
			}
		
			students.add(student);
		}
		return students;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}	
    }

}