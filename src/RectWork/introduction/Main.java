package RectWork.introduction;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<4;i++) {
            double a = r.nextDouble();
            double b = r.nextDouble();
            double c = r.nextDouble();
            System.out.println(a+" "+b+" "+" "+c);
            System.out.println("---------------");
            Rect rect1 = new Rect();

            rect1.width = a;
            rect1.height = b;
            Rect rect2 = new Rect();

            rect2.width = c;
            rect2.height = c;
            System.out.println(rect1.getPerimeter());
            System.out.println(rect1.getArea());
            System.out.println(rect2.getPerimeter());
            System.out.println(rect2.getArea());
            Rect rect3 = new Rect();
            rect3.width = rect1.width;
            rect3.height = rect1.height;
            rect3.scale(2.5);
            Rect rect4 = rect1.getAFourth();
            Rect rect5 = rect2.devide(0.2, 0.5);
            System.out.println(rect3);
            System.out.println(rect4);
            // вывод
            System.out.println(rect1);
            System.out.println(rect2);
            System.out.println(rect3);
            System.out.println(rect4);
            System.out.println(rect5);
            System.out.println("---------------");
        }
    }
}

