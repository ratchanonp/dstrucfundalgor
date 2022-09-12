package lab;

public class ARI {

    private String s;
    private String back;
    private String backR;

    public ARI(String s, String back, String backR) {
        this.s = s;
        this.back = back;
        this.backR = backR;
    }

    public void setBackR(String backR) {
        this.backR = backR;
    }

    @Override
    public String toString() {
        return "s\t\t = " + s + "\n" +
                "back \t = " + back + "\n" +
                "backR \t = " + backR + "\n" +
                "------------------------\n";
    }
}
