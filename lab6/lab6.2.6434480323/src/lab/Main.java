package lab;

import datastr.CourseGrade;
import datastr.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Student, ArrayList<CourseGrade>> data = new HashMap<>();
        File file = new File("src/register.csv");

        // Read File and Store Data
        try {
            Scanner register = new Scanner(file);
            String record;
            String[] recordData;

            int studentId, courseId, semester, year, credit;
            double grade;
            String studentFName, studentLName, courseName;

            while (register.hasNextLine()) {
                record = register.nextLine();
                recordData = record.strip().split(",");

                studentId = Integer.parseInt(recordData[0]);
                studentFName = recordData[1];
                studentLName = recordData[2];
                Student student = new Student(studentId, studentFName, studentLName);

                courseId = Integer.parseInt(recordData[3]);
                courseName = recordData[4];
                semester = Integer.parseInt(recordData[5]);
                year = Integer.parseInt(recordData[6]);
                credit = Integer.parseInt(recordData[7]);
                grade = Double.parseDouble(recordData[8]);
                CourseGrade courseGrade = new CourseGrade(courseId, courseName, semester, year, credit, grade);

                if (data.containsKey(student)) {
                    data.get(student).add(courseGrade);
                } else {
                    data.put(student, new ArrayList<>());
                    data.get(student).add(courseGrade);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Query Step
        System.out.println("Enter student ID");
        int studentID = Integer.parseInt(scanner.next());

        ArrayList<CourseGrade> courseGrades = data.get(new Student(studentID));
        if (courseGrades != null) {
            for (CourseGrade course : courseGrades) {
                System.out.println(course);
            }
        } else {
            System.out.println("No record");
        }
    }
}
