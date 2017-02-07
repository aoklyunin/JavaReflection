package RectWork.statica;

public class Rect {
    private double width;
    private double height;

    public Rect() {
        width = 1;
        height = 1;
    }

    private Rect(double d) {
        width = d;
        height = d;
    }

    Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    protected static boolean isSquare(Rect r){
        return r.width==r.height;
    }
    public static double getArea(Rect r){
        return  r.width*r.height;
    }
    public static final double getPerimeter(Rect r){
        return 2*(r.width+r.height);
    }

    @Override
    public String toString() {
        return "Rect{" +
                "width=" + width +
                ",height=" + height +
                '}';
    }

}
