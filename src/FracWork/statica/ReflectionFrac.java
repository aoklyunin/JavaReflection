package FracWork.statica;

import customReflection.MyReflection;
import customReflection.RetStruct;

import static customReflection.MyReflection.*;


public class ReflectionFrac {
    public static void main(String[] args) {

        MyReflection.setClass(Frac.class);

        setField("numerator",6,2);
        setField("denominator",2,1);

        MyReflection.getField("numerator").check(int.class, MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("denominator").check(int.class, MyReflection.MODIFIER_PRIVATE);

        MyReflection.separate();
        MyReflection.checkMethod("toString").check(String.class,MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkConstructor().check(MODIFIER_DEFAULT);
        MyReflection.separate();

        MyReflection.checkConstructor(new Class[]{int.class},
                new Object[]{5}, new Object[]{2}).check(MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkConstructor(   new Class[] { int.class,int.class},
                new Object[]{ 3,4},new Object[]{1,2}).check(MODIFIER_PRIVATE);
        MyReflection.separate();


        MyReflection.checkMethod("scale", new Class[]{double.class},
                new Object[]{0.1}, new Object[]{2}).check(Frac.class,
                false, true, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("scale", new Class[]{double.class,double.class,double.class},
                new Object[]{0.1,2,1}, new Object[]{2,0.2,1}).check(Frac.class,
                false, false, false, false, MODIFIER_PRIVATE);
        MyReflection.separate();
        MyReflection.checkMethod("checkTriangle").check(boolean.class,
                false, false, false, false, MODIFIER_PUBLIC);
        MyReflection.separate();


        RetStruct retStruct = MyReflection.checkConstructor(new Class[]{double.class, double.class, double.class},
                new Object[]{5,4,3}, new Object[]{2,3,2});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getArea", new Class[]{Frac.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(double.class,
                    true, false, false, false, MODIFIER_DEFAULT);
        }
        MyReflection.separate();
        RetStruct retStruct2 = MyReflection.checkConstructor(new Class[]{double.class, double.class, double.class},
                new Object[]{5,4,3}, new Object[]{2,3,2});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("getPerimeter", new Class[]{Frac.class},
                    new Object[]{retStruct2.objects[0]}, new Object[]{retStruct2.objects[1]}).check(double.class,
                    true, false, false, false, MODIFIER_PUBLIC);
        }
        MyReflection.separate();
    }
}
