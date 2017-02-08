package RectWork.statica;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            double a = r.nextDouble();
            double b;
            if (r.nextBoolean()){
                b = a;
            }else
                b = r.nextDouble();
            double c = r.nextDouble();
            double d = r.nextDouble();
            System.out.println(a + " " + b + " " + c + " " + d);
            System.out.println("---------------");

            Rect rect1 = new Rect(a, b);
            Rect rect2 = new Rect();
            Rect rect3 = new Rect(c);
            Rect rect4 = new Rect(d, 1);
            Rect[] rect = new Rect[]{rect1, rect2, rect3, rect4};
            System.out.println(Rect.isSquare(rect1));

            double area = 0;
            double perimeter = 0;
            for (Rect R : rect) {
                area += Rect.getArea(R);
                perimeter += Rect.getPerimeter(R);
            }
            System.out.println(area+" "+perimeter);
            for (Rect R : rect) {
                System.out.println(R);
            }
            System.out.println("---------------");
        }
    }
}

