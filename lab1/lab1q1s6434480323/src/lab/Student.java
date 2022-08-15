package lab;

public class Student {

    private String ID;
    private String FName;
    private String LName;
    private double GPAX;

    public Student(String ID, String FName, String LName, double GPAX) {
        this.ID = ID;
        this.FName = FName;
        this.LName = LName;
        this.GPAX = GPAX;
    }

    public void setGPAX(double GPAX) {
        this.GPAX = GPAX;
    }

    public String getID() {
        return ID;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public double getGPAX() {
        return GPAX;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student student){
            return student.ID.equals(this.ID);
        }
        return false;
    }

    @Override
    public String toString() {
        return ID + "," + FName + "," + LName + "," + GPAX;
    }
}
