package FracWork.statica;

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
            Frac frac3 = frac1.mult(4).sum( frac1.sum(frac2).mult(3)).sum(1);
            System.out.println(frac3);
            System.out.println(Frac.doShort(frac3));



            System.out.println(frac1);
            System.out.println(frac2);
            System.out.println(frac3);

            System.out.println("---------------");
        }
    }
}

