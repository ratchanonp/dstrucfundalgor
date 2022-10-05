package ex;

import datastr.ArrayCollection;

public class ModeTest {
    public static void main(String[] args) {
        ArrayCollection c1 = new ArrayCollection();

        c1.add("A");
        c1.add("B");
        c1.add("A");
        c1.add("B");
        c1.add("A");
        c1.add("C");

        System.out.println(c1.mode());
    }
}
