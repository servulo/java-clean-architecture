package br.com.sprj.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void shouldNotCreateInvalidEmail() {
	assertThrows(IllegalArgumentException.class, () -> new Email(null));
	assertThrows(IllegalArgumentException.class, () -> new Email(""));
	assertThrows(IllegalArgumentException.class, () -> new Email("invalidEmail"));
    }

    @Test
    void shouldCreateEmail() {
	String address = "servulo@gmail.com";
	Email email = new Email(address);
	assertEquals(address, email.getAddress());
    }

}