package FracWork.statica;

import customReflection.MyReflection;
import customReflection.RetStruct;

import static customReflection.MyReflection.*;


public class ReflectionFrac {
    public static void main(String[] args) {

        MyReflection.setClass(Frac.class);

        MyReflection.setField("numerator",6,2);
        MyReflection.setField("denominator",2,1);

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

        RetStruct retStruct = MyReflection.checkConstructor(new Class[]{int.class, int.class},
                new Object[]{5,4}, new Object[]{2,3});
        if (!retStruct.isNullable) {
            MyReflection.checkMethod("sum", new Class[]{Frac.class},
                    new Object[]{retStruct.objects[0]}, new Object[]{retStruct.objects[1]}).check(Frac.class,
                    false, false, false, false, MODIFIER_PROTECTED);
        }
        MyReflection.separate();
            MyReflection.checkMethod("sum", new Class[]{int.class},
                    new Object[]{5}, new Object[]{1}).check(Frac.class,
                    false, false, false, false, MODIFIER_PUBLIC);

        MyReflection.separate();

        RetStruct retStruct2 = MyReflection.checkConstructor(new Class[]{int.class, int.class},
                new Object[]{5,4}, new Object[]{2,3});
        if (!retStruct2.isNullable) {
            MyReflection.checkMethod("mult", new Class[]{Frac.class},
                    new Object[]{retStruct2.objects[0]}, new Object[]{retStruct2.objects[1]}).check(Frac.class,
                    false, false, false, false, MODIFIER_PRIVATE);
        }
        MyReflection.separate();
        MyReflection.checkMethod("mult", new Class[]{int.class},
                new Object[]{5}, new Object[]{1}).check(Frac.class,
                false, false, false, false, MODIFIER_PRIVATE);

        MyReflection.separate();

        RetStruct retStruct3 = MyReflection.checkConstructor(new Class[]{int.class, int.class},
                new Object[]{20,5}, new Object[]{5,3});
        if (!retStruct3.isNullable) {
            MyReflection.checkMethod("doShort", new Class[]{Frac.class},
                    new Object[]{retStruct3.objects[0]}, new Object[]{retStruct3.objects[1]}).check(Frac.class,
                    true, true, false, false, MODIFIER_PUBLIC);
        }
    }
}
