package datastr;

public class CourseGrade {
    private int id;
    private String name;
    private int semester;
    private int year;
    private int credit;
    private double grade;

    public CourseGrade(int id, String name, int semester, int year, int credit, double grade) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.year = year;
        this.credit = credit;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%d  %s  %d/%d  %d  %.1f", id,name,year,semester,credit,grade);
    }
}
