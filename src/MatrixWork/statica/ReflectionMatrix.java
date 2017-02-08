package MatrixWork.statica;

import customReflection.MyReflection;

import static customReflection.MyReflection.*;

public class ReflectionMatrix {
    public static void main(String[] args) {
        MyReflection.setClass(Matrix.class);

        double[][] arr1 = {
                {1.1, 2.0, 3.7},
                {0.1, 1, 12},
                {-9, 1, 11},
        };

        double[][] arr2 = {
                {1.1, 2.0,1,2.1},
                {1.1, 1,1,1.1},
                {0.2, 1,0.9,7},
                {-0.01, 1, 1,1},
        };

        setField("n",  arr1.length, arr2.length);
        setField("m", arr1[0].length, arr2[1].length);
        setField("arr",  arr1, arr2);


        MyReflection.getField("n").check(int.class, MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("m").check(int.class, MyReflection.MODIFIER_PRIVATE);
        MyReflection.getField("arr").check(double[][].class, MyReflection.MODIFIER_PRIVATE);

        MyReflection.separate();
        MyReflection.checkMethod("toString").check(String.class, false, false,
                false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkConstructor().check(MODIFIER_DEFAULT);
        MyReflection.separate();
        MyReflection.checkConstructor(new Class[]{int.class},
                new Object[]{3}, new Object[]{2}).check(MODIFIER_PROTECTED);
        MyReflection.separate();
        double[][] arr4 = {
                {1.1, 2.0, 3.7,9,1},
                {0.1, 1, 12,5,1},
                {-9, 1, 11,1,2},
        };
        double[][] arr5 = {
                {1.1, 1},
                {0.1, 0.12},
                {-9, 7.1},
        };
        MyReflection.checkConstructor(new Class[]{double[][].class},
                new Object[]{arr4}, new Object[]{arr5}).check(MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("sum",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                        {1.1, 0, 9},
                        {0.1, 1, 1},
                        {-0.1, -1, -1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                })}).check(Matrix.class, false, false,
                false, false, MODIFIER_PRIVATE);
        MyReflection.separate();
        checkMethod("mult",
                new Class[]{double.class},
                new Object[]{0.5},new Object[]{1.5}).check(Matrix.class, false, false,
                false, false, MODIFIER_PROTECTED);

        MyReflection.separate();
        MyReflection.checkMethod("mult",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                        {1.1, 0},
                        {0.1, 1},
                        {1.1, 1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                        {0.1, 1},
                })}).check(Matrix.class, false, false,
                false, false, MODIFIER_DEFAULT);
        MyReflection.separate();
        MyReflection.checkMethod("getMinor",
                new Class[] { int.class,int.class},
                new Object[]{ 0,1},new Object[]{1,0}).check(Matrix.class, false, true,
                false, false, MODIFIER_PUBLIC);
        MyReflection.separate();

        MyReflection.checkMethod("det",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                        {1.1, 0,1},
                        {0.1, 1,1},
                        {1.1, 1,1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                })}).check(double.class, true, false,
                false, false, MODIFIER_PUBLIC);

        MyReflection.separate();

        MyReflection.checkMethod("inv",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                        {1.1, 0,1},
                        {0.1, 1,1},
                        {1.1, 1,1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                })}).check(Matrix.class, true, true,
                false, false, MODIFIER_DEFAULT);

/*
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
*/
    }
}
