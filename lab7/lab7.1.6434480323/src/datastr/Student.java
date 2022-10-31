package datastr;

public class Student {
    private int id;
    private String FName;
    private String LName;

    public Student(int id, String FName, String LName) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
    }

    public Student(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        int result = id / 1000;
        result = result % 10000;
        return result;
    }                   // Hashcode ใช้ student id เลย
}
