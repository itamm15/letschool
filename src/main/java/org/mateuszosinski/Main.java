package org.mateuszosinski;

import org.mateuszosinski.databaseobject.DatabaseObject;
import org.mateuszosinski.menu.Menu;

import java.util.ArrayList;

public class Main {
    private static ArrayList<DatabaseObject> database = new ArrayList();
    public static void main(String[] args) {
        Menu.showMenu(database);
    }
}