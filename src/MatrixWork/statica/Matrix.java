package MatrixWork.statica;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aokly on 21.01.2017.
 */
public class Matrix {
    private int n;
    private int m;
    private double[][] arr;

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

    Matrix() {
        this(new double[][]{
                {1, 0, 0,},
                {0, 1, 0},
                {0, 0, 1}
        });
    }

    private Matrix sum(Matrix m) {
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

    protected Matrix(int n) {
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
    protected Matrix mult(double d) {
        Matrix m = new Matrix(this.arr);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                m.arr[i][j] = this.arr[i][j] * d;
            }
        }
        return m;
    }

    Matrix mult(Matrix m) {
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

    public static double det(Matrix m) {
        double [][] A = m.arr;
        int n = A.length;
        double D = 1.0;                 // определитель
        double B[][] = new double[n][n];  // рабочая матрица
        int row[] = new int[n];
        int hold, I_pivot;
        double pivot;
        double abs_pivot;

        if (A[0].length != n) {
            System.out.println("Error in Matrix.determinant, inconsistent array sizes.");
        }
        // создаем рабочую матрицу
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = A[i][j];
        // заполняем вектор перестановок
        for (int k = 0; k < n; k++) {
            row[k] = k;
        }
        // начало основного цикла
        for (int k = 0; k < n - 1; k++) {
            // находим наиболший элемент для основы
            pivot = B[row[k]][k];
            abs_pivot = Math.abs(pivot);
            I_pivot = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(B[row[i]][k]) > abs_pivot) {
                    I_pivot = i;
                    pivot = B[row[i]][k];
                    abs_pivot = Math.abs(pivot);
                }
            }
            // если нашлась такая основа, то меняем знак определителя и меняем местами столбцы
            if (I_pivot != k) {
                hold = row[k];
                row[k] = row[I_pivot];
                row[I_pivot] = hold;
                D = -D;
            }
            // проверка на ноль
            if (abs_pivot < 1.0E-10) {
                return 0.0;
            } else {
                D = D * pivot;
                // делим на основу
                for (int j = k + 1; j < n; j++) {
                    B[row[k]][j] = B[row[k]][j] / B[row[k]][k];
                }
                //  внутренний цикл
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                            B[row[i]][j] = B[row[i]][j] - B[row[i]][k] * B[row[k]][j];
                        }
                    }
                }
            }
            // конец внутреннего цикла
        }
        // конец главного цикла
        return D * B[row[n - 1]][n - 1];
    }

    static final Matrix inv(Matrix m) {
        double A[][] = m.arr.clone();
        int n = A.length;
        int row[] = new int[n];
        int col[] = new int[n];
        double temp[] = new double[n];
        int hold, I_pivot, J_pivot;
        double pivot, abs_pivot;

        if (A[0].length != n) {
            System.out.println("Error in Matrix.invert, inconsistent array sizes.");
        }
        // установиим row и column как вектор изменений.
        for (int k = 0; k < n; k++) {
            row[k] = k;
            col[k] = k;
        }
        // начало главного цикла
        for (int k = 0; k < n; k++) {
            // найдем наибольший элемент для основы
            pivot = A[row[k]][col[k]];
            I_pivot = k;
            J_pivot = k;
            for (int i = k; i < n; i++) {
                for (int j = k; j < n; j++) {
                    abs_pivot = Math.abs(pivot);
                    if (Math.abs(A[row[i]][col[j]]) > abs_pivot) {
                        I_pivot = i;
                        J_pivot = j;
                        pivot = A[row[i]][col[j]];
                    }
                }
            }
            if (Math.abs(pivot) < 1.0E-10) {
                System.out.println("Matrix is singular !");
                return null;
            }
            //перестановка к-ой строки и к-ого столбца с стобцом и строкой, содержащий основной элемент(pivot основу)
            hold = row[k];
            row[k] = row[I_pivot];
            row[I_pivot] = hold;
            hold = col[k];
            col[k] = col[J_pivot];
            col[J_pivot] = hold;
            // k-ую строку с учетом перестановок делим на основной элемент
            A[row[k]][col[k]] = 1.0 / pivot;
            for (int j = 0; j < n; j++) {
                if (j != k) {
                    A[row[k]][col[j]] = A[row[k]][col[j]] * A[row[k]][col[k]];
                }
            }
            // внутренний цикл
            for (int i = 0; i < n; i++) {
                if (k != i) {
                    for (int j = 0; j < n; j++) {
                        if (k != j) {
                            A[row[i]][col[j]] = A[row[i]][col[j]] - A[row[i]][col[k]] *
                                    A[row[k]][col[j]];
                        }
                    }
                    A[row[i]][col[k]] = -A[row[i]][col[k]] * A[row[k]][col[k]];
                }
            }
        }
        // конец главного цикла

        // переставляем назад rows
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                temp[col[i]] = A[row[i]][j];
            }
            for (int i = 0; i < n; i++) {
                A[i][j] = temp[i];
            }
        }
        // переставляем назад columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[row[j]] = A[i][col[j]];
            }
            for (int j = 0; j < n; j++) {
                A[i][j] = temp[j];
            }
        }
        return new Matrix(A);
    }


    public final Matrix getMinor(int row, int column) {
        int minorLength = this.arr.length - 1;
        double[][] minor = new double[minorLength][minorLength];
        int dI = 0;
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
