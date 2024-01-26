package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.legalGuardian.methods.createLegalGuardian;

public class LegalGuardianMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Student\n" +
                    "1. Create a legal guardian for student\n" +
                    "2. Go back."
            );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createLegalGuardian(database);
                    break;
                default:
                    System.out.println("Going back!");
                    break;
            }

        } catch (Exception exception) {
            System.out.println("Something went wrong for the LegalGuardian menu!" + exception);
        }
    }
}
