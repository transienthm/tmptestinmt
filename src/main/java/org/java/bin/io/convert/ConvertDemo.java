package org.java.bin.io.convert;

import org.java.bin.network.chat.CloseUtil;

import java.io.*;

/**
 * Created by wangbin on 17/1/4.
 */
public class ConvertDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(
                                    new File("/Users/wangbin/Documents/workspace/myjdk/src/main/resources/io.txt")
                                    )
                    )
            );
            String content;
            while (null != (content = br.readLine())) {
                System.out.println(content);
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }finally {
            CloseUtil.closeAll(br);
            System.out.println("br=" + br);
        }
    }
}
