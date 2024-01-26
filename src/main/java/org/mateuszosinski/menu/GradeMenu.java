package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.grades.grade.methods.*;

public class GradeMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Student\n" +
                    "1. Create a grade\n" +
                    "2. Delete a grade\n" +
                    "3. Show all grades\n" +
                    "5. Go back."
            );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createGrade(database);
                    break;
                case 2:
                    deleteGrade(database);
                    break;
                case 3:
                    showGrades(database);
                    break;
                default:
                    System.out.println("Going back!");
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong for the Grade menu!" + exception);
        }
    }
}
