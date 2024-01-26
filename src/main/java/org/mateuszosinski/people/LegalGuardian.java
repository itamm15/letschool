package org.mateuszosinski.people;

import org.mateuszosinski.enums.DegreeOfRelationships;

import java.time.LocalDate;

public class LegalGuardian extends Person implements PrintableInformation {
    private static int numberOfLegalGuardian = 1;
    private final int legalGuardingId;
    private DegreeOfRelationships degreeOfRelationship;

    public LegalGuardian(String firstname, String lastname, String phoneNumber, LocalDate birthdate, DegreeOfRelationships degreeOfRelationship) {
        super(firstname, lastname, phoneNumber, birthdate);
        this.degreeOfRelationship = degreeOfRelationship;

        this.legalGuardingId = numberOfLegalGuardian;
        numberOfLegalGuardian++;
    }

    public DegreeOfRelationships getDegreeOfRelationship() {
        return degreeOfRelationship;
    }

    public void setDegreeOfRelationship(DegreeOfRelationships degreeOfRelationship) {
        this.degreeOfRelationship = degreeOfRelationship;
    }

    @Override
    public String toString() {
        return "LegalGuardian{" +
                "legalGuardingId=" + legalGuardingId +
                ", degreeOfRelationship=" + degreeOfRelationship +
                '}';
    }

    @Override
    public String basicPersonInformation() {
        return "Legal guard: \n " +
                "fullname: " + getFirstname() + " " + getLastname() +
                "\nlegalGuardianId: " + legalGuardingId
                ;
    }

    @Override
    public String getContactDetails() {
        return "Legal Guardian " + getFirstname() + " " + getLastname() + " phone number is " + getPhoneNumber();
    }
}
