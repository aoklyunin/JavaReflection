package TriangleWork.constructors;

public class Triangle {
    double a;
    double b;
    double c;

    public Triangle() {
        a = 1;
        b = 1;
        c = 1;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double a, double b) {
        this.a = a;
        this.b = a;
        this.c = b;
    }
    public Triangle(double a) {
        this.a = a;
        this.b = a;
        this.c = a;
    }

    double getArea(){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    double getPerimeter(){
        return a+b+c;
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

    Triangle scale(double d){
        return  new Triangle(this.a*d,this.b*d,this.c*d);
    }

    Triangle scale(double da, double db, double dc){
        return  new Triangle(this.a*da,this.b*db,this.c*dc);
    }



}
