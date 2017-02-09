package abstract_interface.work7;

import customReflection.MyReflection;

import static customReflection.MyReflection.MODIFIER_PRIVATE;
import static customReflection.MyReflection.MODIFIER_PUBLIC;


public class ReflectionPotato {
    public static void main(String[] args) {


        MyReflection.checkImlementsInterface(Potato.class);
        MyReflection.separate();
        MyReflection.getField("name").check(String.class,MODIFIER_PRIVATE);


        MyReflection.separate();
        MyReflection.checkMethod("harvest").check(void.class,MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("cultivate").check(void.class,MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkMethod("debug").check(void.class,MODIFIER_PUBLIC);


       /* MyReflection.separate();

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
