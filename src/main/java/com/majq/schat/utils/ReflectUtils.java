package com.majq.schat.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 反射工具类
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/23 09:21
 */
public class ReflectUtils {
    /**
     * 对指定类进行检测，获取对类，超类，接口，字段，构造方法，方法的描述字符串
     *
     * @param classType 待描述类
     * @return 类描述字符串
     */
    public static String scanClass(Class classType) {
        StringBuffer buffer = new StringBuffer();
        if (null != classType) {
            buffer.append(getClassDesc(classType)).append("{").append("\r\n");
            buffer.append(feildsDesc(classType));
            buffer.append(constructorDesc(classType));
            buffer.append(methodsDesc(classType));
            buffer.append("}");
            return buffer.toString();
        } else
            throw new IllegalArgumentException("classType can't be null!");
    }

    /**
     * 通用toString方法  对于过于复杂的对象，会出现java.lang.StackOverflowError
     *
     * @param obj         待处理对象
     * @param visitedList 用于存储已经访问过的对象 避免自引用导致的循环
     * @return obj对象的toString结果
     */
    public static String toString(Object obj, List<Object> visitedList) {
        if (null == obj) return "null";
        if (null == visitedList) visitedList = new ArrayList<>();
        else if (visitedList.contains(obj)) return "...";
        Class classType = obj.getClass();
        StringBuffer buffer = new StringBuffer();
        if (classType == String.class) return (String) obj;
        else if (classType.isArray()) {
            buffer.append(classType.getComponentType()).append("[]{").append("\r\n");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) buffer.append(",").append("\r\n");
                Object val = Array.get(obj, i);
                if (classType.getComponentType().isPrimitive()) buffer.append(val);
                else buffer.append(toString(val, visitedList));
            }
            return buffer.append("\r\n").append("}").toString();
        } else {
            do {
                buffer.append(classType.getName());
                buffer.append("[");
                Field[] fields = classType.getDeclaredFields();
                AccessibleObject.setAccessible(fields, true);
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    if (!Modifier.isStatic(field.getModifiers())) {
                        if (!buffer.toString().endsWith("[")) buffer.append(",").append("\r\n");
                        buffer.append(field.getName()).append("=");
                        try {
                            Class type = field.getType();
                            Object val = field.get(obj);
                            if (type.isPrimitive()) buffer.append(val);
                            else buffer.append(toString(val, visitedList));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                buffer.append("]").append(" ");
                classType = classType.getSuperclass();
            } while (classType != null);
            return buffer.toString();
        }
    }

    /**
     * 调用指定类的指定方法
     *
     * @param classType          类对象
     * @param constructArgs      构造函数参数
     * @param methodName         方法名称
     * @param methodArgs         方法参数
     * @param constructParamType 构造函数参数类型列表
     * @param methodParamType    方法参数类型列表
     * @return 方法执行结果
     */
    public static <T> Object invokeSpecificMethod(Class<T> classType, Class[] constructParamType,
                                                  Object[] constructArgs, String methodName,
                                                  Class[] methodParamType, Object[] methodArgs)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T obj = null;
        Method method;
        if (null != classType && StringUtils.isNotBlank(methodName)) {
            if (null != methodParamType && methodParamType.length > 0) {
                method = classType.getDeclaredMethod(methodName, methodParamType);
            } else {
                method = classType.getDeclaredMethod(methodName);
            }
            if (!Modifier.isStatic(method.getModifiers())) {
                if (null == constructParamType || constructParamType.length == 0) {
                    obj = classType.newInstance();
                } else {
                    obj = classType.getConstructor(constructParamType).newInstance(constructArgs);
                }
            }
            if (null != methodParamType && methodParamType.length > 0) {
                return method.invoke(obj, methodArgs);
            } else {
                return method.invoke(obj);
            }
        } else
            throw new IllegalArgumentException("classType & methodName can't be null!");
    }

    /**
     * getDeclaredFields 获得某各类public、private和proteced，但是不包括从父类继承的字段
     * getFields 获得某个类的所有的公共（public）的字段，包括父类中的字段
     *
     * @param classType 待描述类
     * @return
     */
    private static String feildsDesc(Class classType) {
        StringBuffer buffer = new StringBuffer();
        if (null != classType) {
            Field[] fields = classType.getDeclaredFields();
            for (Field field : fields) {
                String modifiers = Modifier.toString(field.getModifiers());
                String type = field.getType().getCanonicalName();
                String name = field.getName();
                buffer.append(modifiers).append(" ").append(type).append(" ").append(name).append(";").append("\r\n");
            }
        }
        return buffer.toString();
    }

    /**
     * 获取对构造方法描述
     *
     * @param classType 待描述类
     * @return 构造方法描述
     */
    private static String constructorDesc(Class classType) {
        StringBuffer buffer = new StringBuffer();
        if (null != classType) {
            Constructor[] constructors = classType.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                String modifier = Modifier.toString(constructor.getModifiers());
                String consName = constructor.getName();
                Parameter[] parameters = constructor.getParameters();
                buffer.append(modifier).append(" ").append(consName).append("(").append(descMethodParam(parameters)).append(")").append(";").append("\r\n");
            }
        }
        return buffer.toString();
    }

    /**
     * 获取对类方法描述
     *
     * @param classType 待描述类
     * @return 类方法描述
     */
    private static String methodsDesc(Class classType) {
        StringBuffer buffer = new StringBuffer();
        if (null != classType) {
            Method[] methods = classType.getDeclaredMethods();
            for (Method method : methods) {
                buffer.append(descMethod(method));
            }
        }
        return buffer.toString();
    }

    /**
     * 对单个方法描述
     *
     * @param method 待描述方法
     * @return 单个方法描述
     */
    private static String descMethod(Method method) {
        StringBuffer buffer = new StringBuffer();
        if (null != method) {
            String modifiers = Modifier.toString(method.getModifiers());
            String returnType = method.getReturnType().getCanonicalName();
            String name = method.getName();
            Parameter[] parameters = method.getParameters();
            String parameterStr = descMethodParam(parameters);
            buffer.append(modifiers).append(" ").append(returnType).append(" ").append(name).append("(").append(parameterStr).append(")").append(";").append("\r\n");
        }
        return buffer.toString();
    }

    /**
     * 对方法参数描述
     *
     * @param parameters 待描述参数
     * @return 方法参数描述
     */
    private static String descMethodParam(Parameter[] parameters) {
        StringBuffer bufferParameter = new StringBuffer();
        if (null != parameters && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String type = parameter.getType().getCanonicalName();
                String name = parameter.getName();
                bufferParameter.append(i == 0 ? "" : ",").append(type).append(" ").append(name);
            }
        }
        return bufferParameter.toString();
    }

    /**
     * 获取类名描述
     *
     * @return 返回类名描述
     */
    private static String getClassDesc(Class classType) {
        StringBuilder builder = new StringBuilder();
        if (null != classType) {
            String packageName = classType.getPackage().getName();
            builder.append("package " + packageName + ";");
            builder.append("\r\n");
            String modifiers = Modifier.toString(classType.getModifiers());
            String className = classType.getCanonicalName();
            String superClass = classType.getSuperclass().getCanonicalName();
            List<String> interfaces = Arrays.stream(classType.getInterfaces()).map(x -> x.getCanonicalName()).collect(Collectors.toList());
            builder.append(modifiers + " class " + className + " extends " + superClass + " implements " + Arrays.toString(interfaces.toArray()));
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        //scanClass(ReflectUtils.class);
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i < 5; i++) squares.add(i * i);
        System.out.println(toString(AdministrativeAreaUtils.getAdministrativeAreaList(), null));
    }
}
