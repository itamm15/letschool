package org.mateuszosinski.classroom;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.people.Student;

import java.util.ArrayList;

public class Classroom extends DatabaseObject {
    private static int numberOfClassrooms;
    private final int classroomId;
    private String name;
    private ArrayList<Student> students;

    public Classroom(ArrayList<Student> students, String name) {
        super("CLASSROOM");

        // VALIDATION
        if (name.isEmpty()) {
            throw new IllegalArgumentException ("The name can not be empty!");
        }

        // ASSIGNMENTS
        this.students = students;
        this.name = name;

        this.classroomId = numberOfClassrooms;
        numberOfClassrooms++;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }
}
