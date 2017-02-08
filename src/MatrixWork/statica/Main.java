package MatrixWork.statica;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<20;i++) {
            System.out.println("----------------------");
            int n1 = r.nextInt(2)+2;
            int m1;

            if (r.nextBoolean()){
                m1 = n1;
            }else{
                m1 = r.nextInt(2)+2;
            }

            double arr1 [][] = new double[n1][m1];


            System.out.println(n1+" "+m1);
            for (int j = 0; j <n1 ; j++) {
                for (int k = 0; k < m1; k++) {
                    arr1[j][k] = r.nextDouble();
                    System.out.print(arr1[j][k]+" ");
                }
                System.out.println();
            }

            Matrix matrix1 = new Matrix(arr1);
            System.out.println(Matrix.inv(matrix1));
        }
    }
}

