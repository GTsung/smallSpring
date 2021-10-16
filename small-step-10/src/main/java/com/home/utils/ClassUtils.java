package com.home.utils;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader c1 = null;
        try {
            c1 = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {

        }
        if (c1 == null) {
            c1 = ClassUtils.class.getClassLoader();
        }
        return c1;
    }

    /**
     * Check whether the specified class is a CGLIB-generated class.
     * @param clazz the class to check
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * Check whether the specified class name is a CGLIB-generated class.
     * @param className the class name to check
     */
    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
