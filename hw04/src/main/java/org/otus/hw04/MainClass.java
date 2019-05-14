package org.otus.hw04;

public class MainClass {
    public static void main(String... args){
        TestLoggingInterface test = IoC.createClass();
        test.calculationInfo(5);
        test.calculationError(10);
        test.calculationNotAnnotation(20);
    }
}
