package anonimus_class.work3;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by teacher on 09.02.17.
 */
public class Main {
    interface Figure {
        double getArea(double a, double b, double c);

        double getPerimeter(double a, double b, double c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Figure triangle = new Figure() {

            @Override
            public double getArea(double a, double b, double c) {
                double p = (a + b + c) / 2;
                return Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }

            @Override
            public double getPerimeter(double a, double b, double c) {
                return a + b + c;
            }
        };

        Figure rect = new Figure() {
            @Override
            public double getArea(double a, double b, double c) {
                return a * b * c;
            }

            @Override
            public double getPerimeter(double a, double b, double c) {
                return 2 * (a + b) * c;
            }
        };

        for (Method m : triangle.getClass().getDeclaredMethods()) {
            System.out.println(m);
        }
        for (Method m : rect.getClass().getDeclaredMethods()) {
            System.out.println(m);
        }

       /* Random r = new Random();
        for (int i = 0; i <10 ; i++) {
            double a = r.nextDouble();
            double b = r.nextDouble();
            double c = r.nextDouble();
            System.out.println(a+" "+b+" "+c);
            System.out.println("-----------------------------------------------");
            System.out.println(triangle.getArea(a, b, c));
            System.out.println(triangle.getPerimeter(a, b, c));

            System.out.println(rect.getArea(a, b, c));
            System.out.println(rect.getPerimeter(a, b, c));
            System.out.println("-----------------------------------------------");
        }
*/
    }
}
