package br.com.sprj.school.infra.student.referral;

import br.com.sprj.school.application.referral.SendReferralEmail;
import br.com.sprj.school.domain.student.Student;

public class SendReferralEmailJavaMail implements SendReferralEmail {

    @Override
    public void sendTo(Student referredStudent) {

	// send email logic using Java Mail

    }

}