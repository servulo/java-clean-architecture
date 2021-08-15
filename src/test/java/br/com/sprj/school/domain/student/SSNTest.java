package br.com.sprj.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SSNTest {

    @Test
    void shouldNotCreateInvalidSSN() {
	assertThrows(IllegalArgumentException.class, ()-> new SSN(null));
	assertThrows(IllegalArgumentException.class, ()-> new SSN(""));
	assertThrows(IllegalArgumentException.class, ()-> new SSN("123456789"));
    }

    @Test
    void shouldCreateSSN() {
	String number = "136-68-2123";
	SSN ssn = new SSN(number);
	assertEquals(number, ssn.getNumber());
    }

}