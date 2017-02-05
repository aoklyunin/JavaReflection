package Inheritance.polynom;

import java.util.Arrays;

/**
 * Created by teacher on 05.02.17.
 */
public class MyArray {
    double [] cArr = new double[3];
    double [] xArr = new double[2];

    public MyArray() {
        for (int i = 0; i < 3; i++) {
            cArr[i]=1;
        }
        for (int i = 0; i < 2; i++) {
            xArr[i]=1;
        }
    }
    public MyArray(double c0, double c1, double c2, double x0, double x1) {
        cArr[0]= c0;
        cArr[1]= c1;
        cArr[2]= c2;

        xArr[0]= x0;
        xArr[1]= x1;
    }


    public MyArray(double[] cArr, double[] xArr) {
        this.cArr = cArr.clone();
        this.xArr = xArr.clone();
    }

    @Override
    public String toString() {
        return "cArr=" + Arrays.toString(cArr) +
                "\nxArr=" + Arrays.toString(xArr);
    }
}
