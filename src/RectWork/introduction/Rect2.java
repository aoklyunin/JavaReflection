package RectWork.introduction;

/**
 * Created by kluninao on 11.01.2017.
 */
public class Rect2 {
    double width;
    double height;
    double getArea(){
        return  width*height;
    }
    double getPerimeter(){
        return 2*(width+height);
    }

    void modify(double width, double height) {
        this.width = width;
        this.height = height;
    }

    void scale(double d){
        this.width *= d;
        this.height *= d;
    }


    @Override
    public String toString() {
        return "Прямоугольник{" +
                "ширина=" + width +
                ",высота=" + height +
                '}';
    }
    Rect getAFourth(){
        Rect rect =  new Rect();
        rect.height = this.height/2;
        rect.width = this.width/2;
        return rect;
    }
    Rect devide(double w,double h){
        Rect rect =  new Rect();
        rect.height = this.height*h;
        rect.width = this.width*w;
        return rect;
    }
}