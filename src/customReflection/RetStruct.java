package customReflection;

import java.lang.reflect.*;
import java.util.Arrays;

import static customReflection.MyReflection.*;

/**
 * Created by teacher on 07.02.17.
 */
public class RetStruct {

    public Object[] objects = new Object[2];
    public boolean isStatic;
    public int modifier;
    public boolean isFinal;
    public boolean isAbstract;
    public Class paramType;
    public boolean isOverrided;
    public boolean isNullable;

    public RetStruct() {
        isNullable = true;

    }

    static boolean isStatic(int m) {
        if (Modifier.isStatic(m)) return true;
        return false;
    }

    static boolean isFinal(int m) {
        if (Modifier.isFinal(m)) return true;
        return false;
    }

    static boolean isAbstract(int m) {
        if (Modifier.isAbstract(m)) return true;
        return false;
    }

    public RetStruct(Field field) throws IllegalAccessException {
        field.setAccessible(true);
        this.paramType = field.getType();
        this.objects[0] = field.get(obj1);
        this.objects[1] = field.get(obj2);
        this.setModifiers(field.getModifiers());
        this.isNullable = false;
    }

    public RetStruct(Method method) throws IllegalAccessException, InvocationTargetException {
        method.setAccessible(true);
        this.setModifiers(method.getModifiers());
        this.isOverrided = !method.getDeclaringClass().equals(obj1.getClass());
        this.paramType = method.getReturnType();
        this.objects[0] = method.invoke(obj1);
        this.objects[1] = method.invoke(obj2);
        this.isNullable = false;
    }

    public RetStruct(Method method, Object[] arg_arr, Object[] arg_arr2) throws IllegalAccessException, InvocationTargetException {
        method.setAccessible(true);
        this.setModifiers(method.getModifiers());
        this.isOverrided = !method.getDeclaringClass().equals(obj1.getClass());
        this.paramType = method.getReturnType();
        this.objects[0] = method.invoke(obj1, arg_arr);
        this.objects[1] = method.invoke(obj2, arg_arr2);
        this.isNullable = false;
    }

    public RetStruct(Constructor constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        constructor.setAccessible(true);
        this.setModifiers(constructor.getModifiers());
        this.isOverrided = false;
        this.paramType = obj1.getClass();
        this.objects[0] = constructor.newInstance();
        this.objects[1] = constructor.newInstance();
        this.isNullable = false;
    }

    public RetStruct(Constructor constructor, Object[] arg_arr, Object[] arg_arr2) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        constructor.setAccessible(true);
        this.setModifiers(constructor.getModifiers());
        this.isOverrided = false;
        this.paramType = obj1.getClass();
        this.objects[0] = constructor.newInstance(arg_arr);
        this.objects[1] = constructor.newInstance(arg_arr2);
        this.isNullable = false;
    }

    public void check(int modifier, String yesString, String noString) {
        if (isNullable) {
            System.out.println(noString);
            return;
        }
        if (this.modifier == modifier) {
            System.out.println(yesString + this.getObjects());
        } else {
            System.out.println(noString);
        }
    }

    public void check(int modifier) {
        check(modifier,"success definding ", "error definding ");
    }

    public void check(Class paramType, boolean isStatic, boolean isFinal, boolean isAbstract, boolean isOverrided, int modifier) {
        check(paramType, isStatic, isFinal, isAbstract, isOverrided, modifier, "success definding ", "error definding ");
    }

    public void check(Class paramType, boolean isStatic, boolean isFinal, boolean isAbstract, boolean isOverrided, int modifier,
                      String yesString, String noString) {
        if (isNullable) {
            System.out.println(noString);
            return;
        }
        if (this.paramType == paramType && this.isStatic == isStatic && this.isFinal == isFinal && this.isOverrided == isOverrided && this.isAbstract == isAbstract && this.modifier == modifier) {
            System.out.println(yesString + this.getObjects());
        } else {
            System.out.println(noString);
        }
    }

    public void check(Class paramType) {
        check(paramType, "success definding ", "error definding ");
    }

    public void check(Class paramType, String yesString, String noString) {
        if (isNullable) {
            System.out.println(noString);
            return;
        }
        if (this.paramType == paramType) {
            System.out.println(yesString + this.getObjects());
        } else {
            System.out.println(noString);
        }
    }

    public void check(String noString, String yesString) {
        if (isNullable) {
            System.out.println(noString);
            return;
        }
        System.out.println(yesString+this.getObjects());
    }

    public void check() {
        check("error definding ", "success definding ");
    }

    public void check(Class paramType, int modifier) {
        check(paramType, modifier, "success definding ", "error definding ");
    }

    public void check(Class paramType, int modifier, String yesString, String noString) {
        if (isNullable) {
            System.out.println(noString);
            return;
        }
        if (this.paramType == paramType && this.modifier == modifier) {
            System.out.println(yesString + this.getObjects());
        } else {
            System.out.println(noString);
        }
    }

    @Override
    public String toString() {
        return "RetStruct{" +
                "objects=" + Arrays.toString(objects) +
                ", isStatic=" + isStatic +
                ", modifier=" + modifier +
                ", isFinal=" + isFinal +
                ", isAbstract=" + isAbstract +
                ", paramType=" + paramType +
                ", isOverrided=" + isOverrided +
                ", isNullable=" + isNullable +
                '}';
    }

    public String getObjects() {
        String s = "";
        if (!objects[0].getClass().isArray())
        for (Object o : objects)
            s += o==null?"null":o.toString() + " ";
        return s;
    }

    static int getModifiersAccess(int m) {
        if (Modifier.isPublic(m)) return MODIFIER_PUBLIC;
        if (Modifier.isProtected(m)) return MODIFIER_PROTECTED;
        if (Modifier.isPrivate(m)) return MODIFIER_PRIVATE;
        return MODIFIER_DEFAULT;
    }

    void setModifiers(int m) {
        this.modifier = getModifiersAccess(m);
        this.isStatic = isStatic(m);
        this.isFinal = isFinal(m);
        this.isAbstract = isAbstract(m);
    }


}

