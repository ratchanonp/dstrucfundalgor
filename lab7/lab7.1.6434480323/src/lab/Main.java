package lab;

import datastr.CourseGrade;
import datastr.SeparateChainingHashMap;
import datastr.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SeparateChainingHashMap data = new SeparateChainingHashMap(12);    // HashMap ที่มี Student เป็น key และ ArrayList ของ CourseGrade เป็น value

        // Try-Catch อ่านไฟล์ register.csv เก็บลง HashMap
        File registerFile = new File("src/register.csv");
        try {
            Scanner registerScanner = new Scanner(registerFile);

            while (registerScanner.hasNextLine()) {
                String record           = registerScanner.nextLine();
                String[] recordData     = record.strip().split(",");        // spilt ด้วย ","

                int studentId           = Integer.parseInt(recordData[0]);
                String studentFName     = recordData[1];
                String studentLName     = recordData[2];
                Student student         = new Student(studentId, studentFName, studentLName);

                int courseId            = Integer.parseInt(recordData[3]);
                String courseName       = recordData[4];
                int semester            = Integer.parseInt(recordData[5]);
                int year                = Integer.parseInt(recordData[6]);
                int credit              = Integer.parseInt(recordData[7]);
                double grade            = Double.parseDouble(recordData[8]);
                CourseGrade courseGrade = new CourseGrade(courseId, courseName, semester, year, credit, grade);

                data.put(student, courseGrade);     // Put Data ลง Separate Chaining
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(data);
    }
}
