package MatrixWork;

import RectWork.Rect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kluninao on 11.01.2017.
 */
public class ReflectionMatrix {
    static Matrix rect = new Matrix();
    static Matrix rect2 = new Matrix();

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

    static void setField(String fieldName, String yesString, String noString, double[][] fieldVal1, double[][] fieldVal2) {
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

    // Проверяет, существует ли double поле
    // возвращаемое значение: массив из двух элементов, соответствующий значениям полей двух объектов
    // параметры: имя поля; строка, если есть поле; строка, если нет поля;
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

    static Object[] checkField(String fieldName, String yesString, String noString) {
        Object[] returnObjects = new Double[2];
        try {
            Class class_var = rect.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            returnObjects[0] = field.get(rect);
            returnObjects[1] = field.get(rect2);
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
    public static boolean checkFieldValues(String filedName, double val1, double val2) {
        Double d[] = checkDoubleField(filedName, "", "");
        return d[0] == val1 && d[1] == val2;
    }

    // главный метод
    public static void main(String[] args) {
        double[][] arr1 = {
                {1.1, 2.0, 3.7},
                {0.1, 1, 12},
                {-9, 1, 11},
        };

        double[][] arr2 = {
                {1.1, 2.0},
                {1.1, 1},
                {0.2, 1},
                {-0.01, 1},
        };

        setField("n", "", "", arr1.length, arr2.length);
        setField("m", "", "", arr1[0].length, arr2[1].length);
        setField("arr", "", "", arr1, arr2);
        System.out.println("-----------------");
        checkIntegerField("n", "find field 'n'", "no field 'n'");
        checkIntegerField("m", "find field 'm'", "no field 'm'");
        checkArrayField("arr", "find field 'arr'", "no field 'arr'");
        System.out.println("-----------------");
         checkMethod("toString", "", "no method 'toString()'",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rect);
                        System.out.println(rect2);
                    }
                });
        System.out.println("-----------------");
        checkMethod("setArr", "", "no method 'setArr(double [][] arr) '",
                new Class[]{double[][].class},
                new Object[]{new double[][]{{1, 2}, {2, 5}}}, new Object[]{new double[][]{{1}}},
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rect);
                        System.out.println(rect2);
                    }
                });

        System.out.println("-----------------");
        setField("n", "", "", arr1.length, arr2.length);
        setField("m", "", "", arr1[0].length, arr2[1].length);
        setField("arr", "", "", arr1, arr2);

        dispRetObjects(checkMethod("sum", "", "no method 'sum()'",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                {1.1, 0, 9},
                {0.1, 1, 1},
                        {-0.1, -1, -1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                })},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        System.out.println("-----------------");
        dispRetObjects(checkMethod("mult", "", "no method 'mult()'",
                new Class[]{double.class},
                new Object[]{0.5},new Object[]{1.5},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));
        System.out.println("-----------------");
        dispRetObjects(checkMethod("multM", "", "no method 'multM()'",
                new Class[]{Matrix.class},
                new Object[]{new Matrix( new double[][] {
                        {1.1, 0},
                        {0.1, 1},
                        {1.1, 1},
                })},new Object[]{new Matrix( new double[][] {
                        {1.1, 2.0},
                        {0.1, 1},
                        {0.1, 1},
                })},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        System.out.println("-----------------");
        dispRetObjects(checkMethod("isSquare","","no method 'isSquare()'", new Runnable() {
            @Override
            public void run() {

            }
        }));

        arr2 = new double[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1},
        };

        setField("n", "", "", arr1.length, arr2.length);
        setField("m", "", "", arr1[0].length, arr2[1].length);
        setField("arr", "", "", arr1, arr2);

        System.out.println("-----------------");
        dispRetObjects(checkMethod("isIdent","","no method 'isIdent()'", new Runnable() {
            @Override
            public void run() {

            }
        }));


/*
        checkMethod("scale","","no method 'scale()'",
                new Class[] { double.class},
                new Object[]{2},new Object[]{4},
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(checkFieldValues("width", 8, 4) ? "YES" : "NO");
                        System.out.println(checkFieldValues("height", 10, 8) ? "YES" : "NO");
                    }
                });
        checkMethod("toString","","no method 'toString()'",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(rect);
                        System.out.println(rect2);
                    }
                });

        dispRetObjects(checkMethod("getAFourth","","no method 'getAFourth()'",
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));

        dispRetObjects(checkMethod("devide", "", "no method 'devide()'",
                new Class[]{double.class, double.class},
                new Object[]{0.3, 0.1}, new Object[]{1, 0.1},
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }));*/
    }
}
