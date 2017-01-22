package TriangleWork.constructors;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<10;i++) {
            double a = r.nextDouble();
            double b = r.nextDouble();
            double c = r.nextDouble();
            System.out.println(a + " " + b + " " + c);
            double a2 = r.nextDouble();
            double b2 = r.nextDouble();
            double c2 = r.nextDouble();
            System.out.println(a2 + " " + b2 + " " + c2);
            System.out.println("---------------");
            Triangle triangle = new Triangle();
            triangle.a = a;
            triangle.b = b;
            triangle.c = c;
            Triangle triangle2 = new Triangle();
            triangle2.a = a2;
            triangle2.b = b2;
            triangle2.c = c2;

            System.out.println(triangle.getArea());
            System.out.println(triangle.getPerimeter());
            System.out.println(triangle2.getArea());
            System.out.println(triangle2.getPerimeter());

            Triangle triangle3 = new Triangle();
            triangle3.a = triangle.a;
            triangle3.b = triangle.b;
            triangle3.c = triangle.c;
            triangle3.scale(2);
            System.out.println(triangle3.getArea());
            System.out.println(triangle3);
            Triangle triangle4 = triangle2.getAHalf();
            System.out.println(triangle4.isEquilateral());
            System.out.println(triangle4.isIsosceles());
            System.out.println(triangle4.isRecangular());
            // вывод
            System.out.println(triangle);
            System.out.println(triangle2);
            System.out.println(triangle3);
            System.out.println(triangle4);
            System.out.println("---------------");
        }
    }
}

