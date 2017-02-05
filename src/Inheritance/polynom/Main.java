package Inheritance.polynom;

import Inheritance.student.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyPolynom myPolynom = new MyPolynom(sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println(myPolynom);
    }
}

