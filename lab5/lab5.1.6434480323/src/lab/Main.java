package lab;

import datastr.ArrayStack;

public class Main {

    static ArrayStack ari = new ArrayStack();

    public static void main(String[] args) {
        System.out.println(reverse("12345"));
    }

    public static String reverse(String s) {
        if (s.isEmpty()) return "";             // Recursive base case

        // Call Recursive
        String back = s.substring(1);
        ari.push(new ARI(s, back, ""));              // Push Calling Stack

        System.out.println("Call Reverse (\"" + s + "\")");
        System.out.println("=== BOTTOM OF STACK ===");
        System.out.println(ari);                            // Print Calling Stack

        String backR = reverse(back);                       // Calling recursive

        // Return From recursive
        ARI lastARI = ((ARI) ari.pop());        // Pop Top State
        lastARI.setBackR(backR);                // Set Top state with backR value that return from recursive calling

        System.out.println("Return from Reverse (\"" + s + "\")");
        System.out.println("=== BOTTOM OF STACK ===");
        System.out.print(ari);                  // Print Array Stack of ARI
        System.out.println(lastARI);            // Print Top state

        return backR + s.charAt(0);       // Return of recursive
    }
}
