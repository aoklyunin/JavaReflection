package MatrixWork.constructors;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i=0;i<10;i++) {
            System.out.println("----------------------");
            int n1 = r.nextInt(2)+2;
            int m1;
            int n2;
            int m2;
            int n3;
            int m3;

            if (r.nextBoolean()){
                m1 = n1;
                n2 = n1;
                m2 = n1;
                n3 = n1;
                m3 = n1;
            }else{
                m1 = r.nextInt(2)+2;
                n2 = r.nextInt(2)+2;
                m2 = r.nextInt(2)+2;
                n3 = r.nextInt(2)+2;
                m3 = r.nextInt(2)+2;
            }

            double arr1 [][] = new double[n1][m1];
            double arr2 [][] = new double[n2][m2];
            double arr3 [][] = new double[n3][m3];


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
            System.out.println(n3+" "+m3);
            for (int j = 0; j <n3 ; j++) {
                for (int k = 0; k < m3; k++) {
                    arr3[j][k] = r.nextDouble();
                    System.out.print(arr3[j][k]+" ");
                }
                System.out.println();
            }

            Matrix matrix1 = new Matrix();
            Matrix matrix2 = new Matrix();
            Matrix matrix3 = new Matrix();

            matrix1.setArr(arr1);
            matrix2.setArr(arr2);
            matrix3.setArr(arr3);

            Matrix m = matrix1.multM(matrix2);
            System.out.println(m==null?"error":m);
            Matrix matrix4 = null;
            Matrix tmpMatrix = matrix2.mult(5).multM(matrix3);
            if (tmpMatrix!=null)
                matrix4 = matrix1.sum(tmpMatrix);

            System.out.println(matrix1==null?"null":matrix1);
            System.out.println(matrix2==null?"null":matrix2);
            System.out.println(matrix3==null?"null":matrix3);
            System.out.println(matrix4==null?"null":matrix4);

        }
    }
}

