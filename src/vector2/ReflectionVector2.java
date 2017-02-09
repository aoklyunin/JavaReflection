package vector2;

import customReflection.MyReflection;
import customReflection.RetStruct;

import static customReflection.MyReflection.*;


public class ReflectionVector2 {
    public static void main(String[] args) {

        MyReflection.setClass(Vector2.class);

        MyReflection.setField("X",5,2);
        MyReflection.setField("Y",1,2);

        MyReflection.getField("X").check(double.class, MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("Y").check(double.class, MyReflection.MODIFIER_PRIVATE);

        MyReflection.separate();
        MyReflection.checkConstructor().check(MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkConstructor(   new Class[] {double.class,double.class },
                new Object[]{ 1,2 },new Object[]{1,2}).check(MODIFIER_DEFAULT);
        MyReflection.separate();

        MyReflection.checkConstructor(   new Class[] { Vector2.class },
                new Object[]{ new Vector2(1,2)},new Object[]{new Vector2(1,2)}).check(MODIFIER_PROTECTED);
        MyReflection.separate();

        MyReflection.checkMethod("getX").check(double.class,MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("getY").check(double.class,MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("setX", new Class[]{double.class},
                new Object[]{0.1}, new Object[]{2}).check(void.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("setY", new Class[]{double.class},
                new Object[]{0.2}, new Object[]{1.2}).check(void.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("plus", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},new Object[]{new Vector2(1,2)}).check(Vector2.class,
                false, false, false, false, MODIFIER_DEFAULT);
        MyReflection.separate();
        MyReflection.checkMethod("minus", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},new Object[]{new Vector2(1,2)}).check(Vector2.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("norm").check(Vector2.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("mult", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},new Object[]{new Vector2(1,2)}).check(double.class,
                false, false, false, false, MODIFIER_DEFAULT);
        MyReflection.separate();
        MyReflection.checkMethod("mult", new Class[]{double.class},
                new Object[]{0.1},new Object[]{0.5}).check(Vector2.class,
                false, false, false, false, MODIFIER_DEFAULT);
        MyReflection.separate();
        MyReflection.checkMethod("rotated", new Class[]{double.class},
                new Object[]{0.1},new Object[]{0.5}).check(Vector2.class,
                false, false, false, false, MODIFIER_PRIVATE);
        MyReflection.separate();
        MyReflection.checkMethod("equals", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},new Object[]{new Vector2(1,2)}).check(boolean.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("toString").check(String.class,MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("ort").check(Vector2.class,MODIFIER_DEFAULT);
        MyReflection.separate();

        MyReflection.checkMethod("sum", new Class[]{Vector2.class,Vector2.class},
                new Object[]{ new Vector2(1,2),new Vector2(0.1,1.1)},
                new Object[]{ new Vector2(-11,2),new Vector2(3,-12)}).check(Vector2.class,
                true, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("len", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},
                new Object[]{ new Vector2(-11,2)}).check(double.class,
                true, false, false, false, MODIFIER_PRIVATE);
        MyReflection.separate();

        MyReflection.checkMethod("rotate", new Class[]{Vector2.class,double.class},
                new Object[]{ new Vector2(1,2),0.4},
                new Object[]{ new Vector2(-11,2),-0.1}).check(Vector2.class,
                true, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("phi", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},
                new Object[]{ new Vector2(-11,2)}).check(double.class,
                true, false, false, false, MODIFIER_DEFAULT);
        MyReflection.separate();

        MyReflection.checkMethod("normalize", new Class[]{Vector2.class},
                new Object[]{ new Vector2(1,2)},
                new Object[]{ new Vector2(-11,2)}).check(Vector2.class,
                true, true, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

/*
        MyReflection.checkMethod("toString").check(String.class,MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkConstructor().check(MODIFIER_PROTECTED);
        MyReflection.separate();


        MyReflection.checkConstructor(   new Class[] { double.class,double.class,double.class},
                new Object[]{ 3,4,5},new Object[]{1,2,2.5}).check(MODIFIER_DEFAULT);
        MyReflection.separate();

        MyReflection.checkConstructor(new Class[]{double.class},
                new Object[]{5}, new Object[]{2}).check(MODIFIER_PRIVATE);
        MyReflection.separate();
        MyReflection.checkMethod("scale", new Class[]{double.class},
                new Object[]{0.1}, new Object[]{2}).check(Triangle.class,
                false, true, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("scale", new Class[]{double.class,double.class,double.class},
                new Object[]{0.1,2,1}, new Object[]{2,0.2,1}).check(Triangle.class,
                false, false, false, false, MODIFIER_PRIVATE);
        MyReflection.separate();
        MyReflection.checkMethod("checkTriangle").check(boolean.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();


        RetStruct retStruct = MyReflection.checkConstructor(new Class[]{double.class, double.class, double.class},
                new Object[]{5,4,3}, new Object[]{2,3,2});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getArea", new Class[]{Triangle.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(double.class,
                    true, false, false, false, MODIFIER_DEFAULT);
        }
        MyReflection.separate();
        RetStruct retStruct2 = MyReflection.checkConstructor(new Class[]{double.class, double.class, double.class},
                new Object[]{5,4,3}, new Object[]{2,3,2});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getPerimeter", new Class[]{Triangle.class},
                    new Object[]{retStruct2.objects[0]}, new Object[]{retStruct2.objects[1]}).check(double.class,
                    true, false, false, false, MODIFIER_PUBLIC);
        }
        MyReflection.separate();*/
    }
}
