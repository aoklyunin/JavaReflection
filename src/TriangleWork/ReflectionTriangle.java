package TriangleWork;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kluninao on 11.01.2017.
 */
public class ReflectionTriangle {
    static Triangle triangle = new Triangle();
    static Triangle triangle2 = new Triangle();

    // задаёт новое значение полю, если оно существует
    // параметры: имя поля; строка, если получилось; строка, если не получилось;
    // значение поля для первого объекта; значение поля для второго объекта
    static void setField(String fieldName, String yesString, String noString, double fieldVal1, double fieldVal2) {
        try {
            Class class_var = triangle.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);
            width_field.setDouble(triangle, fieldVal1);
            width_field.setDouble(triangle2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }

    // Проверяет, существует ли double поле
    // возвращаемое значение: массив из двух элементов, соответствующий значениям полей двух объектов
    // параметры: имя поля; строка, если есть поле; строка, если нет поля;
    static Double[] checkDoubleField(String fieldName, String yesString, String noString) {
        Double[] returnObjects = new Double[2];
        try {
            Class class_var = triangle.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = field.getDouble(triangle);
            returnObjects[1] = field.getDouble(triangle2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    // отображает массив объектов
    static void dispRetObjects(Object[] returnObjects) {
        for (Object o : returnObjects)
            System.out.print(o + " ");
        System.out.println();
    }

    // проверяет, существует ли метод без параметров
    // возвращаемое значение: массив из двух элементов, соответствующий значениям, возвращённым методом
    // первого объекта и второго объекта
    // параметры: имя поля; строка, если есть поле; строка, если нет поля;
    // методы, которые надо выполнить после удачного вызова методов
    static Object[] checkMethod(String methodName, String yesString, String noString, Runnable runnable) {
        Class[] paramTypes = new Class[]{};
        Object[] arg_arr = new Object[]{};
        Method method = null;
        Method method2 = null;
        Object returnObjects[] = new Object[2];
        try {
            Class class_var = triangle.getClass();
            method = class_var.getDeclaredMethod(methodName);
            method.setAccessible(true);
            returnObjects[0] = method.invoke(triangle);
            Class class_var2 = triangle2.getClass();
            method2 = class_var2.getDeclaredMethod(methodName);
            method2.setAccessible(true);
            returnObjects[1] = method2.invoke(triangle2);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    // проверяет, существует ли метод с параметрами
    // возвращаемое значение: массив из двух элементов, соответствующий значениям, возвращённым методом
    // первого объекта и второго объекта
    // параметры: имя поля; строка, если есть поле; строка, если нет поля;
    // массив параметров метода; массив значений при вызове метода первого объекта;
    // массив значений при вызове метода второго объекта;
    // методы, которые надо выполнить после удачного вызова методов
    static Object[] checkMethod(String methodName, String yesString, String noString,
                                Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2, Runnable runnable) {
        Method method = null;
        Method method2 = null;
        Object returnObjects[] = new Object[2];
        try {
            Class class_var = triangle.getClass();
            method = class_var.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            returnObjects[0] = method.invoke(triangle, arg_arr);
            Class class_var2 = triangle2.getClass();
            method2 = class_var2.getDeclaredMethod(methodName, paramTypes);
            method2.setAccessible(true);
            returnObjects[1] = method2.invoke(triangle2, arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    // проверяем поля на равенство заданным
    // параметры: имя поля; значение поля первого объекта; значение поля второго объекта
    public static boolean checkFieldValues(String filedName,double val1, double val2){
        Double d [] = checkDoubleField(filedName,"","");
        return d[0] == val1 && d[1]==val2;
    }
    // главный метод
    public static void main(String[] args) {

        setField("a","","",5,2);
        setField("b","","",1,2);
        setField("c","","",5,2);


        checkDoubleField("a","find field 'a'","no field 'a'");
        checkDoubleField("b","find field 'b'","no field 'b'");
        checkDoubleField("c","find field 'c'","no field 'c'");


        dispRetObjects(checkMethod("getArea", "", "no method 'getArea()'", new Runnable() {
            @Override
            public void run() {

            }
        }));


        dispRetObjects(checkMethod("getPerimeter","","no method 'getPerimeter()'", new Runnable() {
            @Override
            public void run() {

            }
        }));

        checkMethod("modify","","no method 'modify()'",
                new Class[] { double.class,double.class,double.class },
                new Object[]{ 4,5,2},new Object[]{1,2,-1},
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(checkFieldValues("a",4,1)?"YES":"NO");
                        System.out.println(checkFieldValues("b",5,2)?"YES":"NO");
                        System.out.println(checkFieldValues("c",2,-1)?"YES":"NO");
                    }
                });

        setField("a","","",5,2);
        setField("b","","",1,2);
        setField("c","","",5,2);
        checkMethod("scale","","no method 'scale()'",
                new Class[] { double.class},
                new Object[]{2},new Object[]{1},
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(checkFieldValues("a", 10, 2) ? "YES" : "NO");
                        System.out.println(checkFieldValues("b", 2,  2) ? "YES" : "NO");
                        System.out.println(checkFieldValues("c", 10, 2) ? "YES" : "NO");
                    }
                });

        setField("a","","",5,2);
        setField("b","","",1,2);
        setField("c","","",5,2);

        checkMethod("toString","","no method 'toString()'",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(triangle);
                        System.out.println(triangle2);
                    }
                });


        dispRetObjects(checkMethod("getAHalf","","no method 'getAHalf()'",
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        setField("a","","",5,2);
        setField("b","","",1,2);
        setField("c","","",5,2);


        dispRetObjects(checkMethod("isEquilateral", "", "no method 'isEquilateral()'",
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        dispRetObjects(checkMethod("isIsosceles", "", "no method 'isIsosceles()'",
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        setField("a","","",5,3);
        setField("b","","",1,4);
        setField("c","","",5,5);
        dispRetObjects(checkMethod("isRecangular", "", "no method 'isRecangular()'",
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

    }
}
