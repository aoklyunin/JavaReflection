package Inheritance.student;

import Inheritance.paragraph.Paragraph;
import Inheritance.paragraph.Text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        boolean male = sc.next().equals("female");
        double weight = sc.nextDouble();
        int year = sc.nextInt();
        Student student1 = new Student(name,age,male,weight,year);

        name = sc.next();
        age = sc.nextInt();
        male = sc.next().equals("female");
        weight = sc.nextDouble();
        year = sc.nextInt();
        Student student2 = new Student(name,age,male,weight,year);

        Student student3 = new Student();
        Student student4 = student2.myClone();
        student4.incYearOfStudy();
        student4.incYearOfStudy();
        student4.setAge(18);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

    }
}

