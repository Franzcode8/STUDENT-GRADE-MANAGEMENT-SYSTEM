import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String id, name, remark;
    double average;

    Student(String id, String name, double average, String remark) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.remark = remark;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nSTUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1)
                addStudent();
            else if (choice == 2)
                viewStudents();
            else if (choice == 3)
                System.out.println("Program ended.");
            else
                System.out.println("Invalid choice.");

        } while (choice != 3);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        double total = 0;

        for (int i = 1; i <= 3; i++) {
            double grade;
            do {
                System.out.print("Enter grade " + i + ": ");
                grade = sc.nextDouble();
            } while (grade < 0 || grade > 100);
            total += grade;
        }
        sc.nextLine();

        double average = total / 3;
        String remark;

        if (average >= 90)
            remark = "Excellent";
        else if (average >= 80)
            remark = "Very Good";
        else if (average >= 70)
            remark = "Good";
        else if (average >= 60)
            remark = "Needs Improvement";
        else
            remark = "Fail";

        students.add(new Student(id, name, average, remark));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n------------------------------------------------");
        System.out.println("ID\t\tName\t\t\tAverage\t\tRemark");
        System.out.println("------------------------------------------------");

        for (Student s : students) {
            System.out.println(
                s.id + "\t\t" +
                s.name + "\t\t\t" +
                String.format("%.2f", s.average) + "\t\t" +
                s.remark
            );
        }

        System.out.println("------------------------------------------------");
    }
}