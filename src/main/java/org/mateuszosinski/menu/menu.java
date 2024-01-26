package org.mateuszosinski.menu;

import org.mateuszosinski.seeds.Seeds;

import java.util.Scanner;

public class menu {
    public static void menu() {
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
                        createTeacher();
                        break;
                    case 2:

                        break;
                    case 3:
                        deleteTeacher();
                        break;
                    case 4:
                        createStudent();
                        break;
                    case 5:

                        break;
                    case 6:
                        deleteStudent();
                        break;
                    case 7:
                        createLegalGuardian();
                        break;
                    case 8:
                        createClassroom();
                        break;
                    case 9:
                        assignStudentToClassroom();
                        break;
                    case 10:
                        showGivenClassroom();
                        break;
                    case 11:
                        createGrade();
                        break;
                    case 12:
                        deleteGrade();
                        break;
                    case 13:
                        showTeachers();
                        break;
                    case 14:
                        showStudents();
                        break;
                    case 15:
                        showGrades();
                        break;
                    case 16:
                        showClassrooms();
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
