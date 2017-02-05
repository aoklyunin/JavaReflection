package Inheritance.polynom;

import Inheritance.student.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kluninao on 11.01.2017.
 */
public class ReflectionMyArray {
    static MyArray rect = new MyArray();
    static MyArray rect2 = new MyArray();

    // задаёт новое значение полю, если оно существует
    // параметры: имя поля; строка, если получилось; строка, если не получилось;
    // значение поля для первого объекта; значение поля для второго объекта
    static void setField(String fieldName, String yesString, String noString, int fieldVal1, int fieldVal2) {
        try {
            Class class_var = rect.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);
            width_field.setInt(rect, fieldVal1);
            width_field.setInt(rect2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }
    static void setField(String fieldName, String yesString, String noString, double fieldVal1, double fieldVal2) {
        try {
            Class class_var = rect.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);
            width_field.setDouble(rect, fieldVal1);
            width_field.setDouble(rect2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }
    static void setField(String fieldName, String yesString, String noString, boolean fieldVal1, boolean fieldVal2) {
        try {
            Class class_var = rect.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);
            width_field.setBoolean(rect, fieldVal1);
            width_field.setBoolean(rect2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }
    static void setField(String fieldName, String yesString, String noString, String fieldVal1, String fieldVal2) {
        try {
            Class class_var = rect.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);
            width_field.set(rect, fieldVal1);
            width_field.set(rect2, fieldVal2);
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
            Class class_var = rect.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = field.getDouble(rect);
            returnObjects[1] = field.getDouble(rect2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    static String[] checkStringField(String fieldName, String yesString, String noString) {
        String[] returnObjects = new String[2];
        try {
            Class class_var = rect.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = (String)field.get(rect);
            returnObjects[1] = (String)field.get(rect2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    static Boolean[] checkBooleanField(String fieldName, String yesString, String noString) {
        Boolean[] returnObjects = new Boolean[2];
        try {
            Class class_var = rect.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = field.getBoolean(rect);
            returnObjects[1] = field.getBoolean(rect2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    static Integer[] checkIntegerField(String fieldName, String yesString, String noString) {
        Integer[] returnObjects = new Integer[2];
        try {
            Class class_var = rect.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = field.getInt(rect);
            returnObjects[1] = field.getInt(rect2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }

    static void checkArrayField(String fieldName, String yesString, String noString) {
        Object[] returnObjects = new Double[2];
        try {
            Class class_var = rect.getClass();

            Field field = class_var.getDeclaredField(fieldName);
            if (field.getType().isArray()) {
                if (!yesString.equals("")) System.out.println(yesString);
            } else if (!noString.equals("")) System.out.println(noString);

        } catch (NoSuchFieldException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }


    static void setField(String fieldName, String yesString, String noString, double[] fieldVal1, double[] fieldVal2) {
        try {
            Class class_var = rect.getClass();
            Field width_field = class_var.getDeclaredField(fieldName);

            if (!width_field.getType().isArray()) {
                if (!noString.equals("")) System.out.println(noString);
                return;
            }
            width_field.set(rect, fieldVal1);
            width_field.set(rect2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
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
            Class class_var = rect.getClass();
            method = class_var.getDeclaredMethod(methodName);
            method.setAccessible(true);
            returnObjects[0] = method.invoke(rect);
            Class class_var2 = rect2.getClass();
            method2 = class_var2.getDeclaredMethod(methodName);
            method2.setAccessible(true);
            returnObjects[1] = method2.invoke(rect2);
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
            Class class_var = rect.getClass();
            method = class_var.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            returnObjects[0] = method.invoke(rect, arg_arr);
            Class class_var2 = rect2.getClass();
            method2 = class_var2.getDeclaredMethod(methodName, paramTypes);
            method2.setAccessible(true);
            returnObjects[1] = method2.invoke(rect2, arg_arr2);
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

    public static Object checkConstructor(String yesString, String noString,
                                          Runnable runnable){
        try {
            Class class_var = rect.getClass();
            Constructor constructor  = class_var.getDeclaredConstructor();
            Object o = constructor.newInstance();
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
            return o;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |InstantiationException e){
            if (!noString.equals("")) System.out.println(noString);
        }
        return null;
    }
    public static Object [] checkConstructor(String yesString, String noString, Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2,
                                             Runnable runnable){
        Object returnObjects[] = new Object[2];
        try {
            Class class_var = rect.getClass();
            Constructor constructor  = class_var.getDeclaredConstructor(paramTypes);
            returnObjects[0] = constructor.newInstance(arg_arr);
            constructor  = class_var.getDeclaredConstructor(paramTypes);
            returnObjects[1] = constructor.newInstance(arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |InstantiationException e){
            if (!noString.equals("")) System.out.println(noString);
        }
        return returnObjects;
    }


    // главный метод
    public static void main(String[] args) {
        double [] carr1 = {1,2,3};
        double [] carr2 = {0.5,1,1};
        setField("cArr","","",carr1,carr2);
        double [] xarr1 = {1,2};
        double [] xarr2 = {0.5,1};
        setField("xArr","","",xarr1,xarr2);

        checkArrayField("cArr","find field 'cArr'","no field 'cArr'");
        checkArrayField("xArr","find field 'xArr'","no field 'xArr'");


        System.out.println(checkConstructor("", "no method 'MyArray()'", new Runnable() {
            @Override
            public void run() {

            }
        }));

        dispRetObjects(checkConstructor("", "no method 'MyArray(double [] cArr, double [] xArr)'",
                new Class[] { double[].class,double[].class},
                new Object[]{ new double[]{-0.9,0.1,0.5},new double[]{-1,1}},new Object[]{new double[]{0.9,0.9,2.5},new double[]{-2.1,5}},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        dispRetObjects(checkConstructor("", "no method 'MyArray(double c0, double c1, double c2, double x0, double x1)'",
                new Class[] { double.class,double.class,double.class,double.class,double.class,},
                new Object[]{ 1,-1,0.2,1,2},new Object[]{0.5,9,1.2,0.4,-0.5},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        checkMethod("toString","","no method 'toString()'",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rect);
                        System.out.println(rect2);
                    }
                });






    }
}
