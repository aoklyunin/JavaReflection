package TriangleWork.constructors;

public class Triangle {
    double a;
    double b;
    double c;

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

    void modify(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void scale(double s){
        this.a *=s;
        this.b *=s;
        this.c *=s;
    }

    Triangle getAHalf(){
        Triangle t = new Triangle();
        t.a = this.a;
        t.b = this.getArea()/this.a;
        t.c = Math.sqrt(t.a*t.a+t.b+t.b);
        return t;
    }



    boolean isIsosceles(){
        return (a==b)&&(b==c);
    }

    boolean isRecangular(){
        return  Math.abs(a*a+b*b-c*c)<0.01 ||
                Math.abs(a*a-b*b+c*c)<0.01 ||
                Math.abs(-a*a+b*b+c*c)<0.01;
    }

    boolean isEquilateral(){
        return (a==b||b==c||c==a);
    }
}
