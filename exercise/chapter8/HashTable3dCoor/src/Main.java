public class Main {
    public static void main(String[] args) {
        Point point_1 = new Point(1, 2, 3);
        Point point_2 = new Point(3,2,1);

        System.out.println(point_1.hashCode());
        System.out.println(point_2.hashCode());
    }
}
