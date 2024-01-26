package org.mateuszosinski.grades.grade;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.enums.Grades;
import org.mateuszosinski.enums.Subjects;
import org.mateuszosinski.grades.Grade;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.student.methods.showStudents;
import static org.mateuszosinski.people.teacher.methods.showTeachers;

public class methods {
    public static void showGrades(ArrayList<DatabaseObject> database) {
        int gradesCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Grade) {
                System.out.println(databaseObject.toString());
                gradesCount++;
            }
        }

        if (gradesCount == 0) {
            System.out.println("There are no grades!");
        }
    }

    /*
     STEPS:
     1. Select subject,
     2. Select grade,
     3. Select teacher,
     4. Select student
     */
    public static void createGrade(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select a subject by name");
            for (Subjects subject : Subjects.values()) {
                System.out.println(subject + " ");
            }

            String subjectInput = scanner.nextLine();
            Subjects selectedSubject = Subjects.valueOf(subjectInput.toUpperCase());

            System.out.println("Select a grade by name");
            for (Grades grade : Grades.values()) {
                System.out.println(grade + " ");
            }

            String gradeInput = scanner.nextLine();
            Grades selectedGrade = Grades.valueOf(gradeInput.toUpperCase());

            System.out.println("Select teacher by DatabaseObjectId");
            showTeachers(database);

            int pickedDatabaseTeacherObject = scanner.nextInt();
            DatabaseObject teacherDatabaseObject = database.get(pickedDatabaseTeacherObject - 1);
            if(!(teacherDatabaseObject instanceof Teacher))  throw new IllegalAccessException("It is not a teacher!");

            System.out.println("Select student by DatabaseObjectId");
            showStudents(database);

            int pickedDatabaseStudentObject = scanner.nextInt();
            DatabaseObject studentDatabaseObject = database.get(pickedDatabaseStudentObject - 1);
            if(!(studentDatabaseObject instanceof Student))  throw new IllegalAccessException("It is not a student!");

            Student student = (Student) studentDatabaseObject;
            Teacher teacher = (Teacher) teacherDatabaseObject;

            Grade grade = new Grade(selectedSubject, student, teacher, selectedGrade);
            System.out.println("Grade created successfully!");
            database.add(grade);
        } catch (Exception exception) {
            System.out.println("Could not create grade!" + exception);
        }
    }
    public static void deleteGrade(ArrayList<DatabaseObject> database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a grade by databaseObject");
        showGrades(database);
        try {
            int pickedDatabaseObject = scanner.nextInt();
            DatabaseObject grade = database.get(pickedDatabaseObject - 1);
            if(grade instanceof Grade) {
                // remove grade from database
                database.remove(grade);

                // remove grade for student and teacher
                Grade gradeObject = (Grade) grade;
                gradeObject = null;

                System.out.println("The grade has been deleted! Here is updated structure of students:\n");
                showGrades(database);
            } else {
                throw new IllegalAccessException("It is not a grade!");
            }
        } catch (Exception exception) {
            System.out.println("Could not delete grade!" + exception);
        }
    }
}
