package org.otus.hw03.testframework;

import org.otus.hw03.testframework.annotations.After;
import org.otus.hw03.testframework.annotations.Before;
import org.otus.hw03.testframework.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFramework {
    private List<String> list;

    private TestFramework() {
    }

    public static TestFramework newInstance() {
        return new TestFramework();
    }

    public TestFramework add(String className) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }

        list.add(className);

        return this;
    }

    public TestFramework run() {
        if (this.list != null && this.list.size() != 0) {
            executeTests(this.list);
        } else {
            System.err.println("Not add Test Class name, add Class name.");
        }
        return null;
    }

    private void executeTests(List<String> list) {
        for (String line : list) {
            Class clazz = null;

            try {
                clazz = Class.forName(line);
            } catch (ClassNotFoundException e) {
                System.err.println(e.toString());
                continue;
            }

            if (clazz.isAnnotationPresent(Test.class)) {
                try {
                    execute(clazz);
                } catch (InvocationTargetException e) {
                    System.err.println(e.toString());
                } catch (IllegalAccessException e) {
                    System.err.println(e.toString());
                } catch (NoSuchMethodException e) {
                    System.err.println(e.toString());
                } catch (InstantiationException e) {
                    System.err.println(e.toString());
                }
            } else {
                System.err.println("Class: " + clazz.toString() + " not contains annotation \"@Test\"");
            }
        }
    }

    private void execute(Class clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Methods testMethods = getExecuteMethods(clazz);

        Method after = testMethods.after;
        Method before = testMethods.before;
        List<Method> methodsList = testMethods.methods;

        if (methodsList.size() != 0) {
            for (Method method : methodsList) {

                Object object = clazz.getDeclaredConstructor().newInstance();

                try {
                    if (before != null) {
                        before.invoke(object);
                    }
                } catch (Exception e) {
                    System.err.println("Error before method: " + method.getName() + " in class: " + clazz.getName());
                    return;
                }

                try {
                    method.invoke(object);
                } catch (Exception e) {
                    System.err.println("Error test method: " + method.getName() + " in class: " + clazz.getName());
                }

                try {
                    if (after != null) {
                        after.invoke(object);
                    }
                } catch (Exception e) {
                    System.err.println("Error after method: " + method.getName() + " in class: " + clazz.getName());
                    return;
                }
            }
        } else {
            System.err.println("Not fount Test Method in class.");
        }
    }

    private Methods getExecuteMethods(Class clazz) {
        Method[] clazzMethods = clazz.getMethods();
        Methods testMethods = new Methods();
        Method after = null;
        Method before = null;

        for (Method method : clazzMethods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.methods.add(method);
            } else if (method.isAnnotationPresent(After.class)) {
                after = method;
            } else if (method.isAnnotationPresent(Before.class)) {
                before = method;
            }
        }

        testMethods.after = after;
        testMethods.before = before;

        return testMethods;
    }

    private class Methods {
        List<Method> methods = new ArrayList<>();
        Method after;
        Method before;
    }
}
