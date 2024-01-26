package org.mateuszosinski.classrooms.classroom;

import org.mateuszosinski.classrooms.Classroom;
import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.people.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class methods {
    public static void showGivenClassroom(ArrayList<DatabaseObject> database) {
        System.out.println("Provide the DatabaseObjectID of the classroom you want to inspect.");

        try {
            showClassrooms(database);
            Scanner scanner = new Scanner(System.in);

            int pickedDatabaseClassroomObject = scanner.nextInt();
            DatabaseObject classroomDatabaseObject = database.get(pickedDatabaseClassroomObject - 1);
            if(!(classroomDatabaseObject instanceof Classroom))  throw new IllegalAccessException("It is not a classroom!");

            classroomDatabaseObject.toString();
        } catch (Exception exception) {
            System.out.println("Could not inspect the classroom!" + exception);
        }
    }
    public static void showClassrooms(ArrayList<DatabaseObject> database) {
        int classroomsCount = 0;
        for(DatabaseObject databaseObject : database) {
            if(databaseObject instanceof Classroom) {
                System.out.println(databaseObject.toString());
                classroomsCount++;
            }
        }

        if (classroomsCount == 0) {
            System.out.println("There are no classrooms!");
        }
    }
    public static void createClassroom(ArrayList<DatabaseObject> database) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Provide classroom name");
            String classroomName = scanner.nextLine();

            Classroom classroom = new Classroom(new ArrayList<Student>(), classroomName);
            System.out.println("Classroom created successfully!");
            database.add(classroom);
        } catch (Exception exception) {
            System.out.println("Could not create classroom" + exception);
        }
    }
}
