package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.util.ArrayList;
import java.util.Scanner;

import static org.mateuszosinski.people.legalGuardian.methods.createLegalGuardian;
import static org.mateuszosinski.people.legalGuardian.methods.showLegalGuardians;

public class LegalGuardianMenu {
    public static void run(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option for Legal guardian\n" +
                    "1. Create a legal guardian for student\n" +
                    "2. Show all legal guardians\n" +
                    "3. Go back."
            );

            int chosenOption = scanner.nextInt();

            switch (chosenOption) {
                case 1:
                    createLegalGuardian(database);
                    break;
                case 2:
                    showLegalGuardians(database);
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
