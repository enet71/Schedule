package table;


public class Audience {
    private int id;
    private String building;
    private String Number;

    public Audience(int id, String building, String number) {
        this.id = id;
        this.building = building;
        Number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
