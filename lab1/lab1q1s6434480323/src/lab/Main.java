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

                Student student = new Student(ID, FName, LName, GPAX);
                StudentCollection.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        // End Read Data From File

        // Loop input until input is stop
        do {
            System.out.println("add or delete or stop?");
            command = scanner.next();

            switch (command) {
                case "add" -> {
                    ID = scanner.next();
                    FName = scanner.next();
                    LName = scanner.next();
                    GPAX = scanner.nextDouble();

                    Student newStudent = new Student(ID, FName, LName, GPAX);
                    if (StudentCollection.contains(newStudent)) {
                        System.out.println("Duplicate remove old data");
                        StudentCollection.remove(newStudent);
                    }

                    StudentCollection.add(newStudent);

                    System.out.println("Add new record.");
                }
                case "delete" -> {
                    ID = scanner.next();
                    Student deleteStudent = new Student(ID, "", "", 0);

                    // Check Object in collection
                    if (StudentCollection.contains(deleteStudent)) {
                        StudentCollection.remove(deleteStudent);
                        System.out.println("Remove a record.");
                    } else {
                        System.out.println("Not Found");
                    }
                }
                case "stop" -> writeFile(StudentCollection);
                default -> {
                    System.out.println("Invalid command.");
                }
            }
        } while (!command.equals("stop"));
    }

    private static void writeFile(ArrayCollection StudentCollection) {
        try {
            FileWriter studentNEW = new FileWriter("src/studentNEW.csv");
            Object[] students = StudentCollection.toArray();

            for (Object student : students) {
                if (student instanceof Student std) {
                    studentNEW.write(std + "\n");
                }
            }

            studentNEW.close();
            System.out.println("Written to studentNew.csv");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
