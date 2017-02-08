package TriangleWork.statica;

public class Triangle {
    private double a;
    private double b;
    private double c;

    protected Triangle() {
        a = 1;
        b = 1;
        c = 1;
    }

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Triangle(double a) {
        this.a = a;
        this.b = a;
        this.c = a;
    }

    static double getArea(Triangle t) {
        double p = (t.a + t.b + t.c) / 2;
        return Math.sqrt(p * (p - t.a) * (p - t.b) * (p - t.c));
    }

    public static double getPerimeter(Triangle t) {
        return t.a + t.b + t.c;
    }

    @Override
    public String
    toString() {
        return "Triangle{"
                + a +
                "," + b +
                "," + c +
                '}';
    }

    public final Triangle scale(double d) {
        return new Triangle(this.a * d, this.b * d, this.c * d);
    }

    private Triangle scale(double da, double db, double dc) {
        return new Triangle(this.a * da, this.b * db, this.c * dc);
    }

    public boolean checkTriangle(){
        return a<=b+c&&b<=c+a&&c<=a+b;

    }
}
