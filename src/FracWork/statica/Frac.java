package FracWork.statica;

/**
 * Created by aokly on 21.01.2017.
 */
public class Frac {
    private int numerator;
    private int denominator;

    Frac(Frac div) {
        this.denominator = div.denominator;
        this.numerator = div.numerator;

    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }

    public Frac(int a){
        this.numerator = a;
        this.denominator = 1;
    }

    private Frac(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Frac() {
        numerator = 0;
        denominator = 1;
    }

    protected Frac sum(Frac f){
        return new Frac(this.numerator*f.denominator+this.denominator*f.numerator,
                this.denominator*f.denominator);

    }

    public Frac sum(int a){
        return this.sum(new Frac(a));
    }

    private Frac mult(int a){
        return new Frac(numerator*a,denominator);
    }

    private Frac mult(Frac f){
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

    public static final Frac doShort(Frac f){
        int g = gcd(f.denominator,f.numerator);
        int k = f.numerator<0&&f.denominator<0?-1:1;
        return new Frac(f.numerator/g*k, f.denominator/g*k);
    }

    int compareTo(Frac f){
        Frac f2 = this.sum(f.mult(-1));
        return (int) Math.signum(f2.numerator);
    }

    Frac myClone(){
        return  new Frac(this.numerator,this.denominator);
    }

}
