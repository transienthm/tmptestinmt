package org.java.bin.network;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by wangbin on 17/1/5.
 * 封装ip及dns
 */
public class InetDemo {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("www.163.com");
            byte[] address = addr.getAddress();
            for (byte i = 0; i < address.length; i++) {
                System.out.println(address[i]);
            }
            System.out.println(addr.getHostAddress());
            System.out.println(addr.getHostName());

            URL url = new URL("http://www.baidu.com:80/index.html");
            System.out.println(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));
            String msg = null;
            while (null != (msg = br.readLine())) {
                bw.write(msg);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
