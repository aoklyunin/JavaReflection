package RectWork.constructors;

public class Rect {
    double width;
    double height;
    double getArea(){
        return  width*height;
    }
    double getPerimeter(){
        return 2*(width+height);
    }

    public Rect() {
        width = 1;
        height = 1;
    }

    public Rect(double d) {
        width = d;
        height = d;
    }

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    Rect scale(double d){
        return new Rect(this.width * d,this.height * d);
    }

    Rect scale(double w, double h){
        return new Rect(this.width * w,this.height * h);
    }

    boolean isSquare(){
        return width==height;
    }

    @Override
    public String toString() {
        return "Rect{" +
                "width=" + width +
                ",height=" + height +
                '}';
    }

}
