package org.mateuszosinski.grades;

import org.mateuszosinski.databaseobject.DatabaseObject;

import javax.security.auth.Subject;

public class Grade extends DatabaseObject {
    private static int numberOfGrades = 1;
    private final int gradeId;
    private Subject subject;

    public Grade(Subject subject) {
        super("GRADE", numberOfGrades);
        this.subject = subject;

        this.gradeId = numberOfGrades;
        numberOfGrades++;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", subject=" + subject +
                '}';
    }
}
