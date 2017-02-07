package customReflection;

import java.lang.reflect.*;
import java.util.Arrays;


// ToDo:
// передавать вообще только класс

public class MyReflection {

    public static final int MODIFIER_PUBLIC = 0;
    public static final int MODIFIER_PRIVATE = 1;
    public static final int MODIFIER_PROTECTED = 2;
    public static final int MODIFIER_DEFAULT = 3;

    public static Object obj1;
    public static Object obj2;

    public static void setClass(Class className) {
        Constructor constructor = null;
        try {
            constructor = className.getDeclaredConstructor();
            obj1 = constructor.newInstance();
            obj2 = constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Error creating object from getted class");
        }

    }

    public static void setField(String fieldName, Object fieldVal1, Object fieldVal2, String yesString, String noString) {
        try {
            Class class_var = obj1.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj1, fieldVal1);
            field.set(obj2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }

    public static void setField(String fieldName, Object fieldVal1, Object fieldVal2) {
        setField(fieldName, fieldVal1, fieldVal2, "", "");
    }

    public static void setFieldInterhited(String fieldName, String yesString, String noString,
                                          Object fieldVal1, Object fieldVal2) {
        try {
            Class class_var = obj1.getClass();
            Field width_field = class_var.getSuperclass().getDeclaredField(fieldName);

            if (!width_field.getType().isArray()) {
                if (!noString.equals("")) System.out.println(noString);
                return;
            }
            width_field.set(obj1, fieldVal1);
            width_field.set(obj2, fieldVal2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            if (!noString.equals("")) System.out.println(noString);
        }
    }

    public static RetStruct getField(String fieldName, String yesString, String noString) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Field field = class_var.getDeclaredField(fieldName);
            retStruct = new RetStruct(field);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
            //System.out.println(e+"");
        }
        return retStruct;
    }

    public static RetStruct getField(String fieldName) {
        return getField(fieldName, "find field " + fieldName, "no field " + fieldName);
    }

    public static RetStruct checkMethod(String methodName, Runnable runnable) {
        return checkMethod(methodName, "find method " + methodName, "no method " + methodName, runnable);
    }

    public static RetStruct checkMethod(String methodName, String yesString, String noString, Runnable runnable) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Method method = class_var.getDeclaredMethod(methodName);
            retStruct = new RetStruct(method);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }

    public static RetStruct checkMethod(String methodName) {
        return checkMethod(methodName, "find method " + methodName, "no method " + methodName);
    }

    public static RetStruct checkMethod(String methodName, String yesString, String noString) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Method method = class_var.getDeclaredMethod(methodName);
            retStruct = new RetStruct(method);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }

    public static RetStruct checkMethod(String methodName, Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2, Runnable runnable) {
        return checkMethod(methodName, "find method " + methodName + " with params: " + Arrays.toString(paramTypes), "no method " + methodName, paramTypes,
                arg_arr, arg_arr2, runnable);
    }

    public static RetStruct checkMethod(String methodName, Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2) {
        return checkMethod(methodName, "find method " + methodName + " with params" + Arrays.toString(paramTypes),
                "no method " + methodName + " with params" + Arrays.toString(paramTypes), paramTypes,
                arg_arr, arg_arr2);
    }

    public static RetStruct checkMethod(String methodName, String yesString, String noString,
                                        Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2, Runnable runnable) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Method method = class_var.getDeclaredMethod(methodName, paramTypes);
            retStruct = new RetStruct(method, arg_arr, arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;

    }


    public static RetStruct checkMethod(String methodName, String yesString, String noString,
                                        Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Method method = class_var.getDeclaredMethod(methodName, paramTypes);
            retStruct = new RetStruct(method, arg_arr, arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;

    }


    public static RetStruct checkConstructor(Runnable runnable) {
        return checkConstructor("find constructor", "no constructor", runnable);
    }

    public static RetStruct checkConstructor() {
        return checkConstructor("find constructor", "no constructor");
    }

    public static RetStruct checkConstructor(String yesString, String noString,
                                             Runnable runnable) {
        RetStruct retStruct = new RetStruct();

        try {
            Class class_var = obj1.getClass();
            Constructor constructor = class_var.getDeclaredConstructor();
            retStruct = new RetStruct(constructor);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }

    public static RetStruct checkConstructor(String yesString, String noString) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Constructor constructor = class_var.getDeclaredConstructor();
            retStruct = new RetStruct(constructor);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }


    public static RetStruct checkConstructor(String yesString, String noString, Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2,
                                             Runnable runnable) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Constructor constructor = class_var.getDeclaredConstructor(paramTypes);
            retStruct = new RetStruct(constructor, arg_arr, arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
            runnable.run();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }


    public static RetStruct checkConstructor(String yesString, String noString, Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2) {
        RetStruct retStruct = new RetStruct();
        try {
            Class class_var = obj1.getClass();
            Constructor constructor = class_var.getDeclaredConstructor(paramTypes);
            retStruct = new RetStruct(constructor, arg_arr, arg_arr2);
            if (!yesString.equals("")) System.out.println(yesString);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            if (!noString.equals("")) System.out.println(noString);
        }
        return retStruct;
    }

    public static RetStruct checkConstructor(Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2) {
        return checkConstructor("find constructor with params" + Arrays.toString(paramTypes),
                "no constructor with params: " + Arrays.toString(paramTypes), paramTypes,
                arg_arr, arg_arr2);
    }

    public static RetStruct checkConstructor(Class[] paramTypes, Object[] arg_arr, Object[] arg_arr2,
                                             Runnable runnable) {
        return checkConstructor("find constructor with params" + Arrays.toString(paramTypes),
                "no constructor with params" + Arrays.toString(paramTypes), paramTypes,
                arg_arr, arg_arr2, runnable);
    }

    public static void separate() {
        System.out.println("--------------------------------------------------------------------------");
    }


}
