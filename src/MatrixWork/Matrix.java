package MatrixWork;

import java.util.Arrays;

/**
 * Created by aokly on 21.01.2017.
 */
public class Matrix {
    int n;
    int m;
    double[][] arr;

    @Override
    public String toString() {
        String s = "Matrix{";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s += String.format("%4.1f ", arr[i][j]);
            }
            s += '\n';
        }

        return s + '}';
    }

    public void setArr(double[][] arr) {
        this.arr = arr;
        this.m = arr[0].length;
        this.n = arr.length;
    }

    public Matrix() {
    }

    public Matrix sum(Matrix m) {
        if (this.m != m.m || this.n != m.n)
            return null;
        double arr[][] = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                arr[i][j] = this.arr[i][j] + m.arr[i][j];
            }
        }
        return new Matrix(arr);
    }

    public Matrix(double[][] arr) {
        this.arr = arr;
        this.m = arr[0].length;
        this.n = arr.length;
    }

    public Matrix mult(double d) {
        Matrix m = new Matrix(this.arr);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                m.arr[i][j] = this.arr[i][j] * d;
            }
        }
        return m;
    }

    public Matrix multM(Matrix m) {
        if (this.m != m.n)
            return null;
        double arr[][] = new double[this.n][m.m];
        try {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < m.m; j++) {
                    arr[i][j] = 0;
                    for (int s = 0; s < this.m; s++) {
                        arr[i][j] += this.arr[i][s] * m.arr[s][j];
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e+"");
        }
        return new Matrix(arr);
    }

    boolean isSquare(){
        return n==m;
    }

    boolean isIdent(){
        if (!isSquare()) return false;
        boolean flg = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (arr[i][j] != 1) flg = false;
                } else {
                    if (arr[i][j] != 0) flg = false;
                }
            }
        }
        return flg;
    }
}
