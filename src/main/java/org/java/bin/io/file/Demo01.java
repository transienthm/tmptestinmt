package org.java.bin.io.file;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个常用的常量
 * 1、 路径分隔符
 * 2、名称分隔符
 * Created by wangbin on 17/1/1.
 */
public class Demo01 {
    public static void main(String[] args) {
        File src = new File("/Users/wangbin/Documents/workspace/myjdk/src/main/resources/io.txt");
        File dest = new File("/Users/wangbin/Documents/workspace/myjdk/src/main/resources/dest.txt");

        InputStream in = null;
        OutputStream out = null;
        Queue queue = new LinkedList();
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            byte[] flush = new byte[10];
            int len = 0;
            while (-1 != (len = in.read(flush))) {
                out.write(flush, 0, len);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("文件不存在");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("文件读取io异常");
        }finally {
            if (null != in) {
                try {
                    in.close();
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.out.println("关闭失败");
                }
            }
        }
    }
}
