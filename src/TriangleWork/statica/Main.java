package TriangleWork.statica;


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
            Triangle triangle2 = new Triangle(a2,b2,b2);
            Triangle triangle3 = new Triangle(a3,b3,c3);

            Triangle [] triangles = new Triangle[]{triangle1,triangle2,triangle3};
            double perimeter = 0;
            double area = 0;
            for (Triangle triangle:triangles){
                if(triangle.checkTriangle()){
                    area+=Triangle.getArea(triangle);
                    perimeter+=Triangle.getPerimeter(triangle);
                }
            }
            System.out.println(perimeter+" "+area);
            for (Triangle triangle:triangles){
                System.out.println(triangle);
            }
            System.out.println("---------------");
        }
    }
}

