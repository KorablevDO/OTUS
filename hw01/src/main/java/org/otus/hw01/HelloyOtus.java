package org.otus.hw01;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class HelloyOtus {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int i = 0;
        int max = 10000000;
        while (i < max) {
            i++;
        }
        stopwatch.stop();
        long step1Elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("Step1 completed for " + step1Elapsed + "ms");
    }
}
