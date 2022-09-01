package exercise;

import datastr.Polynomial;

public class Main {
    public static void main(String[] args) {
        Polynomial ply1 = new Polynomial();
        Polynomial ply2 = new Polynomial();

        ply1.addTerm(-3, 2);
        ply1.addTerm(2,1);
        ply1.addTerm(1,0);

        ply2.addTerm(4, 2);
        ply2.addTerm(2,1);
        ply2.addTerm(2,0);

        System.out.println(ply1);
        System.out.println(ply2);
        System.out.println(ply1.add(ply2));
        System.out.println(ply1.multiply(ply2));
    }
}
