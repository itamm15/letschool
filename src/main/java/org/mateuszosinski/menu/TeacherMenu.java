package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.teacher.methods.*;

public class TeacherMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Teacher\n" +
                    "1. Create Teacher\n" +
                    "2. Delete teacher\n" +
                    "3. Show all teachers\n" +
                    "4. Show teachers contact details\n" +
                    "5. Go back."
            );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createTeacher(database);
                    break;
                case 2:
                    deleteTeacher(database);
                    break;
                case 3:
                    showTeachers(database);
                    break;
                case 4:
                    showTeachersContactDetails(database);
                    break;
                default:
                    System.out.println("Going back!");
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong for the Teacher menu!" + exception);
        }
    }
}
