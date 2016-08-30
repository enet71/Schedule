package table;

public class Teacher {
    private int id;
    private String name;
    private String surName;
    private String middleName;

    public Teacher(int id, String name, String surName, String middleName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.middleName = middleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
