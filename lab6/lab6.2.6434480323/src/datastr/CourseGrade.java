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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseGrade that)) return false;

        if (id != that.id) return false;
        if (semester != that.semester) return false;
        if (year != that.year) return false;
        if (credit != that.credit) return false;
        if (grade != grade) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result;
        result = id;
        result = 31 * result + semester;
        result = 31 * result + year;
        result = 31 * result + credit;
        result = 31 * result + (int) grade;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%d  %s  %d/%d  %d  %.1f", id,name,year,semester,credit,grade);
    }
}
