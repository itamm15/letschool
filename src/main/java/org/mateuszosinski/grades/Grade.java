package org.mateuszosinski.grades;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.enums.Grades;
import org.mateuszosinski.enums.Subjects;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;

public class Grade extends DatabaseObject {
    private static int numberOfGrades = 1;
    private final int gradeId;
    private Subjects subject;

    private Student student;
    private Teacher teacher;

    private Grades grade;

    public Grade(Subjects subject, Student student, Teacher teacher, Grades grade) {
        super("GRADE");
        this.subject = subject;
        this.student = student;
        this.teacher = teacher;
        this.grade = grade;

        this.gradeId = numberOfGrades;
        numberOfGrades++;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", subject=" + subject +
                ", databaseObjectId=" + getId() +
                ", studentId=" + student.getStudentId() +
                ", teacherId=" + teacher.getTeacherId() +
                '}';
    }
}
