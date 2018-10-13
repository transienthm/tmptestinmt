package org.java.bin.io.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

/**
 * Created by wangbin on 2017/9/8.
 */
public class BufferDemo {
    public static void main(String[] args) {
        FileWriter out = null;
        File file = new File("/Users/wangbin/Documents/workspace/myjdk/iotest.txt");
        try {
            out = new FileWriter(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
