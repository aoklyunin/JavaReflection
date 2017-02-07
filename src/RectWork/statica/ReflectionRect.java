package RectWork.statica;

import customReflection.MyReflection;
import customReflection.RetStruct;

import static customReflection.MyReflection.*;

public class ReflectionRect {
    public static void main(String[] args) {
        MyReflection.setClass(Rect.class);

        MyReflection.setField("width", 5, 2);
        MyReflection.setField("height", 1, 2);

        MyReflection.getField("width").check(double.class, MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("height").check(double.class, MyReflection.MODIFIER_PRIVATE);

        MyReflection.separate();
        MyReflection.checkMethod("toString").check(String.class, false, false,
                false, true, MODIFIER_PUBLIC);
        MyReflection.separate();

            MyReflection.checkConstructor().check(MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkConstructor(new Class[]{double.class},
                new Object[]{5}, new Object[]{2}).check(MODIFIER_PRIVATE);
        MyReflection.separate();
        MyReflection.checkConstructor(new Class[]{double.class, double.class},
                new Object[]{5, 7}, new Object[]{2, 1}).check(MODIFIER_DEFAULT);
        MyReflection.separate();
        RetStruct retStruct = MyReflection.checkConstructor(new Class[]{double.class, double.class},
                new Object[]{5, 5}, new Object[]{2, 1});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("isSquare", new Class[]{Rect.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(boolean.class,
                    true, false, false, false, MODIFIER_PROTECTED);
        }
        MyReflection.separate();
        retStruct = MyReflection.checkConstructor(new Class[]{double.class, double.class},
                new Object[]{5, 5}, new Object[]{2, 1});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getArea", new Class[]{Rect.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(double.class,
                    true, false, false, false, MODIFIER_PUBLIC);
        }
        MyReflection.separate();
        retStruct = MyReflection.checkConstructor(new Class[]{double.class, double.class},
                new Object[]{5, 5}, new Object[]{2, 1});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getPerimeter", new Class[]{Rect.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(double.class,
                    true, true, false, false, MODIFIER_PUBLIC);
        }
        MyReflection.separate();

    }
}
