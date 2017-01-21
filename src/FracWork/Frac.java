package FracWork;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * Created by aokly on 21.01.2017.
 */
public class Frac {
    int numerator;
    int denominator;

    public Frac(Frac div) {
        this.denominator = div.denominator;
        this.numerator = div.numerator;

    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }

    Frac(int a){
        this.numerator = a;
        this.denominator = 1;
    }

    public Frac(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Frac() {
        numerator = 0;
        denominator = 1;
    }

    Frac sum(Frac f){
        return new Frac(this.numerator*f.denominator+this.denominator*f.numerator,
                this.denominator*f.denominator);

    }

    Frac sum(int a){
        return this.sum(new Frac(a));
    }

    Frac mult(int a){
        return new Frac(numerator*a,denominator);
    }

    Frac mult(Frac f){
        return new Frac(numerator*f.numerator,denominator*f.denominator);
    }

    Frac div(int a){
        return new Frac(this.numerator,this.denominator/a);
    }
    Frac inv(){
        return new Frac(this.denominator,this.numerator);
    }
    boolean isDenumeratorZero(){
        return denominator==0;
    }

    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    boolean isShorten(){
        return gcd(this.denominator,this.numerator)>1;
    }

    Frac doShort(){
        int g = gcd(this.denominator,this.numerator);
        int k = this.numerator<0&&this.denominator<0?-1:1;
        return new Frac(this.numerator/g*k, this.denominator/g*k);
    }

    boolean isEqual(Frac f){
        Frac f1 = this.doShort();
        Frac f2 = f.doShort();
        return f1.numerator==f2.numerator&&f1.denominator==f2.denominator;
    }

    int compareTo(Frac f){
        Frac f2 = this.sum(f.mult(-1));
        return (int) Math.signum(f2.numerator);
    }

}
