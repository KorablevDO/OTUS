package org.otus.hw05;

import com.sun.management.GarbageCollectorMXBean;
import com.sun.management.GcInfo;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
;
import java.lang.management.MemoryUsage;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MBean {
    private static MBeanServerConnection serverConnection;
    private static String path = "./hw05/statistics/";

    public static void main(String[] args) throws IOException, InterruptedException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.1.1.1:1234/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        serverConnection = connector.getMBeanServerConnection();
        Set<ObjectName> beanSet = serverConnection.queryNames(null, null);
        Set<ObjectName> containsGC = new HashSet<>();
        for (var oN : beanSet) {
            if (oN.getCanonicalName().contains("GarbageCollector")) {
                containsGC.add(oN);
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            buffer.append(monitor(containsGC)).append("\r\n").append("----------------------------------------------------\r\n");
            Thread.sleep(30000);
        }

        out(buffer.toString(), path + "GarbageCollector.txt");
        connector.close();
    }

    private static String monitor(Set<ObjectName> containsGC) {
        StringBuffer statistics = new StringBuffer();
        for (var bean : containsGC) {
            GarbageCollectorMXBean gcBean = JMX.newMXBeanProxy(serverConnection, bean, GarbageCollectorMXBean.class);
            String time = "collection time: " + gcBean.getCollectionTime();
            System.out.println(time);
            String count = "collection count: " + gcBean.getCollectionCount();
            System.out.println(count);
            statistics.append(time).append("\r\n").append(count).append("\r\n");
            GcInfo gcInfo = gcBean.getLastGcInfo();
            if (gcInfo != null) {
                Map<String, MemoryUsage> memoryUsageMap = gcInfo.getMemoryUsageBeforeGc();
                for (Map.Entry<String, MemoryUsage> memUsage : memoryUsageMap.entrySet()) {
                    String memoryUsage = memUsage.getKey() + ": " + memUsage.getValue() + "\r\n";
                    statistics.append(memoryUsage);
                    System.out.println(memoryUsage);
                }
            }
        }
        return statistics.toString();
    }

    private static void out(String line, String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file, false);
        writer.write(line);
        writer.close();
    }
}
