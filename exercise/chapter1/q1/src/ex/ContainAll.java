package ex;

import datastr.ArrayCollection;

public class ContainAll {
    public static void main(String[] args) {
        ArrayCollection c1 = new ArrayCollection();
        ArrayCollection c2 = new ArrayCollection();

        c1.add("A");
        c1.add("B");
        c1.add("C");
        c1.add("A");
        c1.add("C");

        c2.add("A");
        c2.add("B");

        System.out.println("Is c1 element in every c2 : " + c1.containsAll(c2));
        System.out.println("Is c2 element in every c1 : " + c2.containsAll(c1));
    }
}
