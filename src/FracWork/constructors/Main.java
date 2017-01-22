package FracWork.constructors;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<10;i++) {
            int a = r.nextInt(100);
            int b = r.nextInt(100);
            int c = r.nextInt(100);
            int d = r.nextInt(100);
            System.out.println(a + " " + b + " " + c + " " + d);
            System.out.println("---------------");
            Frac frac1 = new Frac(a,b);
            Frac frac2 = new Frac(c,d);
            Frac frac3 = frac1.sum(frac2);
            String s = "";
            switch (frac1.compareTo(frac2)){
                case -1:
                    s = "Less";
                    break;
                case 0:
                    s = "Equal";
                    break;
                case 1:
                    s = "Bigger";
                    break;
            }
            System.out.println(s);
            Frac frac4 = frac3.mult(3).sum(frac2.inv()).sum(-2);
            System.out.println(frac4);
            System.out.println(frac4.isShorten());
            System.out.println(frac4.doShort());
            System.out.println(frac3.isEqual(frac4)?"YES":"NO");

            System.out.println(frac1);
            System.out.println(frac2);
            System.out.println(frac3);
            System.out.println(frac4);
            System.out.println("---------------");
        }
    }
}

