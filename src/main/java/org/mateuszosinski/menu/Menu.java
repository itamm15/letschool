package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.seeds.Seeds;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.classrooms.classroom.methods.*;
import static org.mateuszosinski.grades.grade.methods.*;
import static org.mateuszosinski.people.legalGuardian.methods.createLegalGuardian;
import static org.mateuszosinski.people.student.methods.*;
import static org.mateuszosinski.people.teacher.methods.*;

public class Menu {
    public static void showMenu(ArrayList<DatabaseObject> database) {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println(
                    "Pick the action to proceed!\n" +
                            "1. Create a Teacher\n" +
                            "2. Update a Teacher\n" +
                            "3. Delete a Teacher\n" +
                            "4. Create a Student\n" +
                            "5. Update a Student\n" +
                            "6. Delete a Student\n" +
                            "7. Create a legal guardian for student\n" +
                            "8. Create a grade\n" +
                            "9. Update a grade\n" +
                            "10. Delete a grade\n" +
                            "11. Show all Teachers\n" +
                            "12. Show all Students\n" +
                            "13. Show all Grades\n" +
                            "14. Exit.\n" +
                            "15. Seed it!"
            );

            Scanner scanner = new Scanner(System.in);

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        createTeacher(database);
                        break;
                    case 2:

                        break;
                    case 3:
                        deleteTeacher(database);
                        break;
                    case 4:
                        createStudent(database);
                        break;
                    case 5:

                        break;
                    case 6:
                        deleteStudent(database);
                        break;
                    case 7:
                        createLegalGuardian(database);
                        break;
                    case 8:
                        createClassroom(database);
                        break;
                    case 9:
                        assignStudentToClassroom(database);
                        break;
                    case 10:
                        showGivenClassroom(database);
                        break;
                    case 11:
                        createGrade(database);
                        break;
                    case 12:
                        deleteGrade(database);
                        break;
                    case 13:
                        showTeachers(database);
                        break;
                    case 14:
                        showStudents(database);
                        break;
                    case 15:
                        showGrades(database);
                        break;
                    case 16:
                        showClassrooms(database);
                        break;
                    case 17:
                        isRunning = false;
                        break;
                    case 18:
                        Seeds.run(database);
                        break;
                    default:
                        System.out.println("There is no such an option! Try again.");
                        break;
                }
            } catch (Exception exception) {
                System.out.println("Could not parse the input!" + exception);
            }
        }
    }
}
