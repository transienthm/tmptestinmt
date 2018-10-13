package org.java.bin.io;

import java.io.*;

/**
 * Created by wangbin on 2017/5/29.
 */
public class Test01 {
    public static void main(String[] args) throws IOException{
        File in = new File("/Users/wangbin/Documents/workspace/myjdk/a.txt");
        File out = new File("/Users/wangbin/Documents/workspace/myjdk/b.txt");
        InputStream is = new FileInputStream(in);
        OutputStream os = new FileOutputStream(out);

        byte[] b = new byte[1024];
        while (-1 != is.read(b)) {
            os.write(b);
        }
        os.close();
    }
}
