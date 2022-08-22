package lab;

import datastr.LinkedCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedCollection StudentCollection = new LinkedCollection(), WithdrawCollection = new LinkedCollection();

        // Read Data From student.csv File & Check Duplicate
        readCSV(StudentCollection, "src/student.csv");
        if (StudentCollection.containsDup()) {
            System.out.println("Duplicate students in file. Removed.");
            StudentCollection.removeDup();
        } else {
            System.out.println("No duplicate student.");
        }

        // Read Data From withdraw.csv File & Check Duplicate
        readCSV(WithdrawCollection, "src/withdraw.csv");
        if (WithdrawCollection.containsDup()){
            System.out.println("Duplicate withdraws in file. Removed.");
            WithdrawCollection.removeDup();
        } else {
            System.out.println("No duplicate withdraw.");
        }

        // Check withdraw is not equal registered
        if (!WithdrawCollection.equals(StudentCollection)) {
            // Remove withdraw student
            Object[] withdrawArr = WithdrawCollection.toArray();
            for (Object withdraw : withdrawArr) StudentCollection.remove(withdraw);

            System.out.println("\nAll registered (" + StudentCollection.size() + ")");
            printData(StudentCollection);
        }
        System.out.println("\nAll withdraw (" + WithdrawCollection.size() + ")");
        printData(WithdrawCollection);
    }

    private static void printData(LinkedCollection linkedCollection) {
        Object[] objArr = linkedCollection.toArray();
        for (Object obj: objArr) System.out.println(obj);
    }

    private static void readCSV(LinkedCollection StudentCollection, String pathname) {
        double GPAX;
        String ID, FName, LName;

        try {
            File file = new File(pathname);
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String[] line = fileReader.nextLine().split(",");

                ID = line[0];
                FName = line[1];
                LName = line[2];
                GPAX = Double.parseDouble(line[3]);

                Student student = new Student(ID, FName, LName, GPAX);
                StudentCollection.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
