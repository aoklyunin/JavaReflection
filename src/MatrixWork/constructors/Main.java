package MatrixWork.constructors;

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
            int n2;
            int m2;

            if (r.nextBoolean()){
                m1 = n1;
                n2 = n1;
                m2 = n1;
            }else{
                m1 = r.nextInt(2)+2;
                n2 = r.nextInt(2)+2;
                m2 = r.nextInt(2)+2;
            }

            double arr1 [][] = new double[n1][m1];
            double arr2 [][] = new double[n2][m2];


            System.out.println(n1+" "+m1);
            for (int j = 0; j <n1 ; j++) {
                for (int k = 0; k < m1; k++) {
                    arr1[j][k] = r.nextDouble();
                    System.out.print(arr1[j][k]+" ");
                }
                System.out.println();
            }
            System.out.println(n2+" "+m2);
            for (int j = 0; j <n2 ; j++) {
                for (int k = 0; k < m2; k++) {
                    arr2[j][k] = r.nextDouble();
                    System.out.print(arr2[j][k]+" ");
                }
                System.out.println();
            }

            Matrix matrix1 = new Matrix(arr1);
            Matrix matrix2 = new Matrix(arr2);

            int a = r.nextInt(2)+2;
            int b = r.nextInt(2)+2;
            System.out.println(a+ " "+ b);
            Matrix matrix3 = new Matrix(a);
            Matrix matrix4 = new Matrix(a,b);

            Matrix m = matrix1.mult(matrix2);
            System.out.println(m==null?"error":m);

            Matrix matrix5 = null;
            Matrix tmpMatrix = matrix2.mult(5).sum(matrix3);
            if (tmpMatrix!=null)
                matrix5 = matrix1.sum(tmpMatrix);

            System.out.println(matrix1==null?"null":matrix1);
            System.out.println(matrix2==null?"null":matrix2);
            System.out.println(matrix3==null?"null":matrix3);
            System.out.println(matrix4==null?"null":matrix4);
            System.out.println(matrix5==null?"null":matrix5);

        }
    }
}

