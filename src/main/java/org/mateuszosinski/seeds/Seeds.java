package org.mateuszosinski.seeds;

import org.mateuszosinski.classrooms.Classroom;
import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.enums.DegreeOfRelationships;
import org.mateuszosinski.enums.Grades;
import org.mateuszosinski.enums.Subjects;
import org.mateuszosinski.grades.Grade;
import org.mateuszosinski.people.LegalGuardian;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;

public class Seeds {
    public static void run(ArrayList<DatabaseObject> database) {
        System.out.println("STARTING SEEDING PROCESS!");
        // STUDENTS
        Student student1 = new Student("Piotrosz", "Mosiński","987654321", LocalDate.of(2005, 10, 3), LocalDate.of(2010, 10, 10));
        Student student2 = new Student("Piotr", "Sosińskimo","123123123", LocalDate.of(2001, 10, 3), LocalDate.of(2010, 10, 10));
        Student student3 = new Student("Pawel", "Brosiński","578976341", LocalDate.of(1990, 10, 3), LocalDate.of(2000, 10, 10));

        database.add(student1);
        database.add(student2);
        database.add(student3);

        // TEACHERS
        Teacher teacher1 = new Teacher("Milosz", "Wolinowski", "123321123", LocalDate.of(2010, 10, 4), LocalDate.of(2018, 12, 20), 123);
        Teacher teacher2 = new Teacher("Marcin", "Perelka", "123321123", LocalDate.of(2010, 10, 4), LocalDate.of(2018, 12, 20), 123);
        Teacher teacher3 = new Teacher("Mario", "Woli", "123321123", LocalDate.of(2010, 10, 4), LocalDate.of(2018, 12, 20), 123);

        database.add(teacher1);
        database.add(teacher2);
        database.add(teacher3);

        // GRADES
        Grade grade1 = new Grade(Subjects.ENGLISH, student1, teacher1, Grades.A);
        Grade grade2 = new Grade(Subjects.MATH, student2, teacher2, Grades.B);
        Grade grade3 = new Grade(Subjects.CODING, student3, teacher3, Grades.C);
        Grade grade4 = new Grade(Subjects.POLISH, student2, teacher1, Grades.D);
        Grade grade5 = new Grade(Subjects.ETHICS, student3, teacher2, Grades.E);
        Grade grade6 = new Grade(Subjects.NETWORKING, student1, teacher3, Grades.F);

        database.add(grade1);
        database.add(grade2);
        database.add(grade3);
        database.add(grade4);
        database.add(grade5);
        database.add(grade6);

        // CLASSROOMS
        ArrayList<Student> classroomStudents1 = new ArrayList();
        classroomStudents1.add(student1);
        classroomStudents1.add(student2);

        ArrayList<Student> classroomStudents2 = new ArrayList();
        classroomStudents2.add(student3);

        Classroom classroom1 = new Classroom(classroomStudents1, "first class");
        Classroom classroom2 = new Classroom(classroomStudents2, "second class");
        Classroom classroom3 = new Classroom(new ArrayList<Student>(), "third class");

        database.add(classroom1);
        database.add(classroom2);
        database.add(classroom3);

        // LEGAL GUARDIANS
        LegalGuardian legalGuardian1 = new LegalGuardian("Lolek", "Guardimoan", "123123123", LocalDate.of(2011, 10, 10), DegreeOfRelationships.BROTHER);
        LegalGuardian legalGuardian2 = new LegalGuardian("Leszek", "Guardian2", "123123123", LocalDate.of(2013, 10, 10), DegreeOfRelationships.MOTHER);
        LegalGuardian legalGuardian3 = new LegalGuardian("Lechu", "Guardianmo3", "123123123", LocalDate.of(2014, 10, 10), DegreeOfRelationships.FATHER);

        database.add(legalGuardian1);
        database.add(legalGuardian2);
        database.add(legalGuardian3);

        System.out.println("SEEDING HAS BEEN FINISHED SUCCESSFULLY!");
    }
}
