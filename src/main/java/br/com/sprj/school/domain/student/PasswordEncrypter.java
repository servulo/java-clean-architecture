package br.com.sprj.school.domain.student;

public interface PasswordEncrypter {

    String encryptPassword(String password);

    boolean validPassword(String encryptedPassword, String password);

}
