package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.classrooms.classroom.methods.*;

public class ClassroomMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Classroom\n" +
                    "1. Create a classroom\n" +
                    "2. Show all classrooms\n" +
                    "3. Show given classroom\n" +
                    "4. Go back."
            );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createClassroom(database);
                    break;
                case 2:
                    showClassrooms(database);
                    break;
                case 3:
                    showGivenClassroom(database);
                    break;
                default:
                    System.out.println("Going back!");
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong for the Classroom menu!" + exception);
        }
    }
}
