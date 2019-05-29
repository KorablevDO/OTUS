package org.otus.hw04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IoC {
    public static TestLoggingInterface createClass (){
        InvocationHandler handler = new LogInvocationHandler(new TestLoggingImpl());
        return (TestLoggingInterface) Proxy.newProxyInstance(IoC.class.getClassLoader(), new Class[]{TestLoggingInterface.class}, handler);
    }

    private static class LogInvocationHandler implements InvocationHandler{
        private final TestLoggingImpl testLogging;
        private Set<String> methods;

        public LogInvocationHandler(TestLoggingImpl impl){
            this.testLogging = impl;
            this.methods = new HashSet<>();
            for(Method method : impl.getClass().getMethods()){
                if (method.isAnnotationPresent(Log.class)){
                    this.methods.add(method.getName());
                }
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            if(methods.contains(name)){
                System.out.println("Method: " + name + getLineArgs(args));
            }

            return method.invoke(this.testLogging, args);
        }

        private String getLineArgs(Object[] args){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Args{ ");
            int i = 0;
            for(Object o  : args){
                i++;
                buffer.append("{");
                buffer.append("Type: " + o.getClass().getName());
                buffer.append(", ");
                buffer.append("Value: " + o);
                buffer.append("}");

                if (i < args.length){
                    buffer.append(", ");
                }
            }
            buffer.append(" }");
            return buffer.toString();
        }
    }
}
