package org.java.bin.network.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by wangbin on 17/1/8.
 */
public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (int i = 0; i < io.length; i++) {
            Closeable temp = io[i];
            if (null != temp) {
                try {
                    temp.close();
                    io[i] = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (Closeable c : io) {
            System.out.println(c);
        }
    }
}
