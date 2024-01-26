package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.seeds.Seeds;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void showMenu(ArrayList<DatabaseObject> database) {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println(
                    "Pick the action to proceed!\n" +
                            "1. Teacher actions\n" +
                            "2. Student actions\n" +
                            "3. Grades actions\n" +
                            "4. Classrooms actions\n" +
                            "5. Legal Guardian actions\n" +
                            "6. Seed it!\n" +
                            "7. Exit."
            );

            Scanner scanner = new Scanner(System.in);

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        TeacherMenu.run(database);
                        break;
                    case 2:
                        StudentMenu.run(database);
                        break;
                    case 3:
                        GradeMenu.run(database);
                        break;
                    case 4:
                        // CLASSROOM
                        break;
                    case 5:
                        LegalGuardianMenu.run(database);
                        break;
                    case 6:
                        Seeds.run(database);
                        break;
                    case 7:
                        isRunning = false;
                        System.out.println("Bye!");
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
