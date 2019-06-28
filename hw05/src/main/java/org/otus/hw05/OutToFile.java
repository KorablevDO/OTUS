package org.otus.hw05;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutToFile implements Closeable {
    private String path = "./hw05/statistics/";
    private String name = "Log";
    private String format = ".txt";
    private FileWriter writer;

    public OutToFile() throws IOException {
        createFileWriter(this.name);
    }

    public OutToFile(String fileName) throws IOException {
       createFileWriter(fileName);
    }

    private void createFileWriter(String name) throws IOException {
        File file = new File(this.path + name + format);
        if(!file.exists()){
            file.createNewFile();
        }

        this.writer = new FileWriter(file, true);
    }

    public void out(String line) throws IOException {
        writer.write(line);
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }
}
