package br.com.sprj.school.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.sprj.school.domain.student.PasswordEncrypter;

public class PasswordEncrypterMD5 implements PasswordEncrypter {

    @Override
    public String encryptPassword(String password) {
	try {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] bytes = md.digest();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < bytes.length; i++) {
		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	} catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException("");
	}

    }

    @Override
    public boolean validPassword(String encryptedPassword, String password) {
	return encryptedPassword.equals(encryptPassword(password));
    }

}
