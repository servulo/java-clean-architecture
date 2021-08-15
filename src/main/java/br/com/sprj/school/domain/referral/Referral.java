package br.com.sprj.school.domain.referral;

import java.time.LocalDateTime;

import br.com.sprj.school.domain.student.Student;

public class Referral {

    private Student referred;
    private Student wasReferredBy;
    private LocalDateTime referralDate;

    public Referral(Student referred, Student wasReferredBy) {
	this.referred = referred;
	this.wasReferredBy = wasReferredBy;
	this.referralDate = LocalDateTime.now();
    }

    public Student getReferred() {
	return referred;
    }

    public Student getWasReferredBy() {
	return wasReferredBy;
    }

    public LocalDateTime getReferralDate() {
	return referralDate;
    }

}
