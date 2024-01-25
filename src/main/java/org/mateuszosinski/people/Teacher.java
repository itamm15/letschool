package org.mateuszosinski.people;

import org.mateuszosinski.enums.Subjects;

import java.time.LocalDate;
import java.util.List;

public class Teacher extends Person {
    private static int numberOfTeachers = 1;
    private final int teacherId;

    private LocalDate enrollmentDate;
    private List<Subjects> subjects;
    private float salary;

    public Teacher(String firstname, String lastname, String phoneNumber, LocalDate birthdate, List<Subjects> subjects, Float salary, LocalDate enrollmentDate) {
        super(firstname, lastname, phoneNumber, birthdate);

        // VALIDATION
        if (enrollmentDate.isBefore(birthdate)) {
            throw new IllegalArgumentException(("Enrollment date can not be before birthdate!"));
        }

        if (salary < 0) {
            throw new IllegalArgumentException("The salary can not be lower than 0!");
        }

        // ASSIGNMENTS
        this.enrollmentDate = enrollmentDate;
        this.subjects = subjects;
        this.salary = salary;

        this.teacherId = numberOfTeachers;
        numberOfTeachers++;
    }

    public Teacher(String firstname, String lastname, String phoneNumber, LocalDate birthdate, LocalDate enrollmentDate, float salary) {
        super(firstname, lastname, phoneNumber, birthdate);

        // VALIDATION
        if (enrollmentDate.isBefore(birthdate)) {
            throw new IllegalArgumentException(("Enrollment date can not be before birthdate!"));
        }

        if (salary < 0) {
            throw new IllegalArgumentException("The salary can not be lower than 0!");
        }

        // ASSIGNMENTS
        this.enrollmentDate = enrollmentDate;
        this.salary = salary;

        this.teacherId = numberOfTeachers;
        numberOfTeachers++;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        if(salary > 0){
            this.salary = salary;
        } else {
            System.out.println("The salary can not be lower than 0!");
        }
    }

    public static int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", fullname=" + getFirstname() + " " + getLastname() +
                ", enrollmentDate=" + enrollmentDate +
                ", subjects=" + subjects +
                ", salary=" + salary +
                ", databaseObjectId = " + getId() +
                '}';
    }
}
