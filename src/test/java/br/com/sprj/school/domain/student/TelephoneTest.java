package br.com.sprj.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TelephoneTest {

    @Test
    void shouldNotCreateTelephoneWithInvalidAreaCode() {
	assertThrows(IllegalArgumentException.class, () -> new Telephone(null, "1234567"));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("", "1234567"));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("1", "1234567"));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("1234", "1234567"));
    }

    @Test
    void shouldNotCreateTelephoneWithInvalidNumber() {
	assertThrows(IllegalArgumentException.class, () -> new Telephone("111", null));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("111", ""));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("111", "123456"));
	assertThrows(IllegalArgumentException.class, () -> new Telephone("111", "12345678"));
    }

    @Test
    void shouldCreateTelephone() {
	String areaCode = "111";
	String number = "1234567";
	Telephone telephone = new Telephone(areaCode, number);
	assertEquals(areaCode, telephone.getAreaCode());
	assertEquals(number, telephone.getNumber());
    }

}