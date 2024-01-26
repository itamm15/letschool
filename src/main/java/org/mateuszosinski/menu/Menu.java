package org.mateuszosinski.menu;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.people.LegalGuardian;
import org.mateuszosinski.people.Person;
import org.mateuszosinski.people.Student;
import org.mateuszosinski.people.Teacher;
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
                            "6. Display the people by the substring on full name\n" +
                            "7. Seed it!\n" +
                            "8. Exit."
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
                        ClassroomMenu.run(database);
                        break;
                    case 5:
                        LegalGuardianMenu.run(database);
                        break;
                    case 6:
                        showPeopleBySubstrings(database);
                    case 7:
                        Seeds.run(database);
                        break;
                    case 8:
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

    public static void showPeopleBySubstrings(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Provide substring for full name");

            String substring = scanner.nextLine();

            for(DatabaseObject databaseObject : database) {
                if(databaseObject instanceof Person) {
                    String fullName = (((Person) databaseObject).getFirstname() + " " + ((Person) databaseObject).getLastname()).toLowerCase();

                    if(fullName.contains(substring.toLowerCase())) {
                        System.out.println("-------------------------");
                        if(databaseObject instanceof Teacher) {
                            Teacher teacher = (Teacher) databaseObject;
                            System.out.println(teacher.basicPersonInformation());
                        }

                        if(databaseObject instanceof Student) {
                            Student student = (Student) databaseObject;
                            System.out.println(student.basicPersonInformation());
                        }

                        if(databaseObject instanceof LegalGuardian) {
                            LegalGuardian legalGuardian = (LegalGuardian) databaseObject;
                            System.out.println(legalGuardian.basicPersonInformation());
                        }
                        System.out.println("-------------------------");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Could not show people by substring!" + exception);
        }
    }
}
