package Inheritance.paragraph;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kluninao on 11.01.2017.
 */
public class ReflectionParagraph {
    static Paragraph rect = new Paragraph();
    static Paragraph rect2 = new Paragraph();

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
        setField("caption","","","c1","c2");


        checkStringField("text","find field 'text'","no field 'text'");
        checkStringField("caption","find field 'caption'","no field 'caption'");


        System.out.println(checkConstructor("", "no method 'Paragraph()'", new Runnable() {
            @Override
            public void run() {

            }
        }));
        dispRetObjects(checkConstructor("", "no method 'Paragraph(String caption)'",
                new Class[] { String.class},
                new Object[]{"textTmp"},new Object[]{"textTmp2"},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        dispRetObjects(checkConstructor("", "no method 'Paragraph(String text, String caption)'",
                new Class[] { String.class,String.class},
                new Object[]{"textTmp","caption1"},new Object[]{"textTmp2","caption2"},
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


        checkMethod("changeCaption","","no method 'changeCaption(String s)'",
                new Class[] { String.class},
                new Object[]{" captionTmp1"},new Object[]{" captionTmp2"},
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rect);
                        System.out.println(rect2);
                    }
                });

        final boolean[] flg = new boolean[]{false};

        Object [] mArr =  checkMethod("myClone","","no method 'myClone()'",
                new Runnable() {
                    @Override
                    public void run() {
                        flg[0] = true;
                    }
                });

        if (flg[0]) {
            rect.text = "12";
            rect2.text = "11";
        }

        dispRetObjects(mArr);


    }
}
