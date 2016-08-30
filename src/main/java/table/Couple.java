package table;

public class Couple {
    private int id;
    private String subject;
    private String group;
    private int number;
    private String audience;
    private String begin;
    private String end;
    private int star;
    private int dayWeek;
    private String teacher;
    private String type;

    public Couple(int id, String subject, String group, int number, String audience, String begin, String end, int star, int dayWeek, String teacher, String type) {
        this.id = id;
        this.subject = subject;
        this.group = group;
        this.number = number;
        this.audience = audience;
        this.begin = begin;
        this.end = end;
        this.star = star;
        this.dayWeek = dayWeek;
        this.teacher = teacher;
        this.type = type;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(int dayWeek) {
        this.dayWeek = dayWeek;
    }
}
