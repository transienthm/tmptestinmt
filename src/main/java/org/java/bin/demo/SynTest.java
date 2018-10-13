package org.java.bin.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.ExportException;

/**
 * Created by wangbin on 2017/9/8.
 */
public class SynTest implements Runnable{
    private File file;

    public SynTest(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        FileWriter writer = null;
        synchronized (file) {
            try {
                writer = new FileWriter(file, true);
                writer.write("hello world!\r\n");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("/Users/wangbin/Documents/workspace/myjdk/iotest.txt");
        for (int i = 0; i < 10; i++) {
            new Thread(new SynTest(file)).start();
        }
    }
}
