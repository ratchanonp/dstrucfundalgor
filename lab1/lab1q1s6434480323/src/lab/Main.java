package lab;

import datastr.ArrayCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command, ID, FName, LName;
        double GPAX;

        Scanner scanner = new Scanner(System.in);
        ArrayCollection StudentCollection = new ArrayCollection(2);

        // Read Data From File
        try {
            File studentFile = new File("src/student.csv");
            Scanner studentReader = new Scanner(studentFile);

            while (studentReader.hasNextLine()) {
                String[] line = studentReader.nextLine().split(",");

                ID = line[0];
                FName = line[1];
                LName = line[2];
                GPAX = Double.parseDouble(line[3]);

                StudentCollection.add(new Student(ID, FName, LName, GPAX));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Loop input until stop
        do {
            System.out.println("add or delete or stop?");
            command = scanner.next();

            switch (command) {
                case "add":
                    ID = scanner.next();
                    FName = scanner.next();
                    LName = scanner.next();
                    GPAX = scanner.nextDouble();

                    Student newStudent = new Student(ID, FName, LName, GPAX);
                    if (StudentCollection.contains(newStudent)){
                        System.out.println("Duplicate Replace with new Data");
                        StudentCollection.remove(newStudent);
                        StudentCollection.add(newStudent);
                    } else {
                        StudentCollection.add(newStudent);
                    }

                    System.out.println("Add new record.");
                    break;
                case "delete":
                    ID = scanner.next();

                    if (StudentCollection.contains(new Student(ID, "", "", 0))) {
                        StudentCollection.remove(new Student(ID, "", "", 0));
                        System.out.println("Remove a record.");
                    } else {
                        System.out.println("Not Found");
                    }

                    break;
                case "stop":
                    writeFile(StudentCollection);
                    break;
                default:
                    System.out.println("Invalid command.");
            }

        } while (!command.equals("stop"));


    }

    private static void writeFile(ArrayCollection StudentCollection) {
        try {
            FileWriter studentNEW = new FileWriter("src/studentNEW.csv");
            Object[] students = StudentCollection.toArray();
            for (int i = 0; i < students.length; i++) {
                if (students[i] instanceof Student std) {
                    studentNEW.write(std.toString() + "\n");
                }
            }
            studentNEW.close();
            System.out.println("Written to studentNew.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
