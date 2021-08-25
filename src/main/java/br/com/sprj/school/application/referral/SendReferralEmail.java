package br.com.sprj.school.application.referral;

import br.com.sprj.school.domain.student.Student;

public interface SendReferralEmail {

    void sendTo(Student referredStudent);

}
