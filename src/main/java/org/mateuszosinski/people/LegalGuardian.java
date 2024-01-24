package org.mateuszosinski.people;

import org.mateuszosinski.enums.DegreeOfRelationship;

import java.time.LocalDate;

public class LegalGuardian extends Person {
    private static int numberOfLegalGuardian = 1;
    private final int legalGuardingId;
    private DegreeOfRelationship degreeOfRelationship;

    public LegalGuardian(String firstname, String lastname, String phoneNumber, LocalDate birthdate, DegreeOfRelationship degreeOfRelationship) {
        super(firstname, lastname, phoneNumber, birthdate);
        this.degreeOfRelationship = degreeOfRelationship;

        this.legalGuardingId = numberOfLegalGuardian;
        numberOfLegalGuardian++;
    }

    public DegreeOfRelationship getDegreeOfRelationship() {
        return degreeOfRelationship;
    }

    public void setDegreeOfRelationship(DegreeOfRelationship degreeOfRelationship) {
        this.degreeOfRelationship = degreeOfRelationship;
    }
}
