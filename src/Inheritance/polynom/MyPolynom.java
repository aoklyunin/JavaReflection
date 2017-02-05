package Inheritance.polynom;

/**
 * Created by teacher on 05.02.17.
 */
public class MyPolynom extends MyArray{
    public MyPolynom(double c0, double c1, double c2, double x0, double x1) {
        super(c0, c1, c2, x0, x1);
    }

    public MyPolynom() {
        super();
    }

    public MyPolynom(double[] cArr, double[] xArr) {
        super(cArr, xArr);
    }

    double solve(){
        return  cArr[0]+cArr[1]*xArr[0]+cArr[2]*xArr[1];
    }

    @Override
    public String toString() {
        return  cArr[0]+"+"+cArr[1]+"*"+xArr[0]+"+"+cArr[2]+"*"+xArr[1]+"="+solve();
    }
}
