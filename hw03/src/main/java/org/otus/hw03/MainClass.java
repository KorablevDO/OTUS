package org.otus.hw03;

import org.otus.hw03.testframework.TestFramework;

public class MainClass {
    public static void main(String[] args) {
        TestFramework.newInstance()
                .add(ClassTest.class.getName())
                .run();
    }
}