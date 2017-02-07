package RectWork.statica;

import Inheritance.polynom.MyArray;
import def.MyReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static def.MyReflection.MODIFIER_PUBLIC;

/**
 * Created by kluninao on 11.01.2017.
 */
public class ReflectionRect {
    public static void main(String[] args) {
        MyReflection.setClass(Rect.class);

        MyReflection.setField("width",5,2);
        MyReflection.setField("height",1,2);

        MyReflection.getField("width").check(double.class,MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("height").check(double.class,MyReflection.MODIFIER_PRIVATE);

        MyReflection.separate();
        MyReflection.checkMethod("toString").check(String.class,false,false,
                false,true,MODIFIER_PUBLIC);
        MyReflection.separate();
        MyReflection.checkConstructor().check();
        MyReflection.separate();
        MyReflection.checkConstructor(new Class[] { double.class},
                new Object[]{ 5},new Object[]{2}).check();
        MyReflection.separate();
        MyReflection.checkConstructor(new Class[] { double.class,double.class},
                new Object[]{ 5,7},new Object[]{2,1}).check();
        MyReflection.separate();

    }
}
