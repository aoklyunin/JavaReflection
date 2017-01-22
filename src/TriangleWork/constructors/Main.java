package TriangleWork.constructors;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<10;i++) {
            double a1 = r.nextDouble();
            double a2 = r.nextDouble();
            double b2 = r.nextDouble();
            double a3 = r.nextDouble();
            double b3 = r.nextDouble();
            double c3 = r.nextDouble();
            System.out.println(a1);
            System.out.println(a2+" "+b2);
            System.out.println(a3+" "+b3+" "+c3);
            System.out.println("---------------");
            Triangle triangle1 = new Triangle(a1);
            Triangle triangle2 = new Triangle(a2,b2);
            Triangle triangle3 = new Triangle(a3,b3,c3);
            Triangle triangle4 = new Triangle();
            Triangle triangle5 = triangle1.scale(2.5);
            Triangle triangle6 = triangle2.scale(0.85, 0.8, 0.9);
            System.out.println(triangle1.getArea()+" "+triangle2.getArea()+" "+triangle5.getArea()+" "+triangle6.getArea());
            System.out.println(triangle5.getPerimeter()+" "+triangle6.getPerimeter());
            System.out.println(triangle1);
            System.out.println(triangle2);
            System.out.println(triangle3);
            System.out.println(triangle4);
            System.out.println(triangle5);
            System.out.println(triangle6);
            System.out.println("---------------");
        }
    }
}

