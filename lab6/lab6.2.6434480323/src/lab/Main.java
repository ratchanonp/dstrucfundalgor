package lab;

import datastr.CourseGrade;
import datastr.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Student, ArrayList<CourseGrade>> data = new HashMap<>();    // HashMap ที่มี Student เป็น key และ ArrayList ของ CourseGrade เป็น value

        // Try-Catch อ่านไฟล์ register.csv เก็บลง HashMap
        File registerFile = new File("src/register.csv");
        try {
            Scanner registerScanner = new Scanner(registerFile);

            while (registerScanner.hasNextLine()) {
                String record = registerScanner.nextLine();
                String[] recordData = record.strip().split(",");        // spilt ด้วย ","

                int studentId       = Integer.parseInt(recordData[0]);
                String studentFName = recordData[1];
                String studentLName = recordData[2];
                Student student     = new Student(studentId, studentFName, studentLName);

                int courseId        = Integer.parseInt(recordData[3]);
                String courseName   = recordData[4];
                int semester        = Integer.parseInt(recordData[5]);
                int year            = Integer.parseInt(recordData[6]);
                int credit          = Integer.parseInt(recordData[7]);
                double grade        = Double.parseDouble(recordData[8]);
                CourseGrade courseGrade = new CourseGrade(courseId, courseName, semester, year, credit, grade);

                if (data.containsKey(student)) {
                    data.get(student).add(courseGrade);     // ถ้ามี student อยู่แล้วเพิ่ม CourseGrade ไปที่นักเรียนคนนั้น
                } else {
                    data.put(student, new ArrayList<>());   // ไม่มี student เพิ่ม student ใน Hashmap และ Allocate ArrayList สำหรับใส่ CourseGrade
                    data.get(student).add(courseGrade);     // เพิ่ม CourseGrade ไปที่นักเรียนคนที่เพิ่งเพิ่ม
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Task : รับรหัสนิสิตจากผู้ใช้ เพื่อพิมพ์ผลการเรียนของนิสิตคนนั้นออกมา */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID");
        int studentID = Integer.parseInt(scanner.next());

        ArrayList<CourseGrade> courseGrades = data.get(new Student(studentID));
        if (courseGrades != null) {                             // Check ว่ามีนิสิตคนที่ต้องการไหม
            for (CourseGrade course : courseGrades) {
                System.out.println(course);                     // ถ้ามีินิสิต Print เกรดออกมา
            }
        } else {
            System.out.println("No record");                    // ถ้าไม่มีนิิสิต
        }
    }
}
