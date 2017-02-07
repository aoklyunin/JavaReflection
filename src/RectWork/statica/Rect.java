package RectWork.statica;

public class Rect {
    private double width;
    private double height;
    double getArea(){
        return  width*height;
    }
    double getPerimeter(){
        return 2*(width+height);
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
