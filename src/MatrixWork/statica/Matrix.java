package MatrixWork.statica;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aokly on 21.01.2017.
 */
public class Matrix {
    int n;
    int m;
    double[][] arr;

    Matrix(Scanner sc) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
    }

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

    public Matrix() {
        this(new double[][]{
                {1, 0, 0,},
                {0, 1, 0},
                {0, 0, 1}
        });
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
        this.arr = Arrays.copyOf(arr,arr.length);
        this.m = arr[0].length;
        this.n = arr.length;
    }

    public Matrix(int n) {
        arr = new double[n][n];
        for  (int i = 0; i <n; i++) {
            arr[i][i] = 1;
        }
        this.n = n;
        this.m = n;
    }
    public Matrix(int n,int m) {
        arr = new double[n][m];
        this.n = n;
        this.m = m;
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

    public Matrix mult(Matrix m) {
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
        } catch (Exception e) {
            System.out.println(e + "");
        }
        return new Matrix(arr);
    }

    boolean isSquare() {
        return n == m;
    }

    boolean isIdent() {
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


    //функция, к-я возвращает нужный нам минор. На входе - определитель, из к-го надо достать минор и номера строк-столбцов, к-е надо вычеркнуть.
    private Matrix getMinor(int row, int column) {
        int minorLength = this.arr.length - 1;
        double[][] minor = new double[minorLength][minorLength];
        int dI = 0;//эти переменные для того, чтобы "пропускать" ненужные нам строку и столбец
        int dJ = 0;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    dI = 1;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = this.arr[i][j];
                    }
                }
            }
        }
        return new Matrix(minor);

    }

    Matrix myClone(){
        return new Matrix(arr);
    }
}
