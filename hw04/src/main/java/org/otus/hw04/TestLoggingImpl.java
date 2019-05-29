package org.otus.hw04;

public class TestLoggingImpl implements TestLoggingInterface {
    @Log
    public void calculationInfo(int number){
        System.out.println("Logger should return:" + number);
    }

    @Log
    public void calculationError(int number){
        System.out.println("Logger should return:" + number);
    }

    public void calculationNotAnnotation(int number) {
        System.out.println("Logger should return:" + number);
    }
}
