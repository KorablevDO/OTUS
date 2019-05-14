package org.otus.hw04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IoC {
    public static TestLoggingInterface createClass (){
        InvocationHandler handler = new LogInvocationHandler(new TestLoggingImpl());
        return (TestLoggingInterface) Proxy.newProxyInstance(IoC.class.getClassLoader(), new Class[]{TestLoggingInterface.class}, handler);
    }

    private static class LogInvocationHandler implements InvocationHandler{
        public final TestLoggingImpl testLogging;

        public LogInvocationHandler(TestLoggingImpl impl){
            this.testLogging = impl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method baseMethod = this.testLogging.getClass().getMethod(method.getName(), method.getParameterTypes());

            if(baseMethod.isAnnotationPresent(Log.class)){
                System.out.println("Method: " + method.getName() + getLineArgs(args));
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
