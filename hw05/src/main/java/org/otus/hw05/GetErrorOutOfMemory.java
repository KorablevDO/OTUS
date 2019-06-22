package org.otus.hw05;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetErrorOutOfMemory {
    private static String line = "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000" +
            "000000000000000000000000000000000000000000000000000000000000000000";

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        Thread thread = new MyGC();
        thread.start();

        try {
            error();
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }

        System.out.println(new Date().toString());
    }

    private static void error() {
        List<String> list = null;
        while (true) {
            if (list == null) {
                list = new ArrayList<>();
            }

            for (int i = 0; i < 5000000; i++) {
                list.add(line);
            }

            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < list.size() / 2; i++) {
                list1.add(line);
            }

            list = list1;
        }
    }

    public static class MyGC extends Thread {

        public void run() {
            while (true) {
                monitor();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        private void monitor() {
            List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
            StringBuffer buffer = new StringBuffer();
            for (GarbageCollectorMXBean bean : beans) {
                String name = bean.getName();
                buffer.append("name: ").append(name).append("\r\n");
                System.out.println(name);
                String count = String.valueOf(bean.getCollectionCount());
                buffer.append("count: ").append(count).append("\r\n");
                System.out.println(count);
                String time = String.valueOf(bean.getCollectionTime());
                buffer.append("time: ").append(time).append("\r\n");
                System.out.println(time);
                buffer.append("\r\n");
            }

            try (OutToFile out = new OutToFile()) {
                out.out(buffer.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
