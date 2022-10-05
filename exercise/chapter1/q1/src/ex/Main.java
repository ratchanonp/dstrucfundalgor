package ex;

import datastr.ArrayCollection;

public class Main {
    public static void main(String[] args) {
        ArrayCollection arrCol = new ArrayCollection();

        arrCol.add("A");
        arrCol.add("E");
        arrCol.add("B");
        arrCol.add("A");
        arrCol.add("B");
        arrCol.add("E");
        arrCol.add("B");
        arrCol.add("C");
        arrCol.add("C");
        arrCol.add("D");

        arrCol.add("E");
        arrCol.add("E");
        arrCol.add("E");

        System.out.println("========== [ArrayCollection] ==========");
        System.out.println("elementData : " + arrCol);
        System.out.println("Is contains dup : " + (arrCol.containsDup() ? "Yes" : "No"));
        System.out.println("A freq : " + arrCol.frequency("A"));
        System.out.println("B freq : " + arrCol.frequency("B"));
        System.out.println("C freq : " + arrCol.frequency("C"));

        System.out.println("========== After All E ===========");
        System.out.println("elementData : " + arrCol);
        arrCol.removeAll("E");
        System.out.println("elementData : " + arrCol);
        System.out.println("==================================");

        System.out.println("========== Trim Test ==========");
        arrCol.trimToSize();
        System.out.println("===============================");

        if (arrCol.containsDup()) {
            arrCol.removeDup();
            System.out.println("========== After Remove Dup ===========");
            System.out.println("elementData : " + arrCol);
            System.out.println("A freq : " + arrCol.frequency("A"));
            System.out.println("B freq : " + arrCol.frequency("B"));
            System.out.println("C freq : " + arrCol.frequency("C"));
        }

        arrCol.clear();
        System.out.println("========== After Clear ===========");
        System.out.println("elementData : " + arrCol);
    }
}
