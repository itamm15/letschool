package org.mateuszosinski.databaseobject;

public abstract class DatabaseObject {
    private String name;
    private int id;
    private static int currentObjectId = 1;

    public DatabaseObject(String name) {
        this.name = name;
        this.id = currentObjectId;

        currentObjectId++;
    }

    public int getId() {
        return id;
    }
}
