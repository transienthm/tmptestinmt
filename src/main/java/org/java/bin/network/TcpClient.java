package org.java.bin.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.IllegalFormatCodePointException;

/**
 * Created by wangbin on 17/1/5.
 */
public class TcpClient {
    public static void main(String[] args) throws IOException{
        Socket client = new Socket("localhost", 8888);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream())
        );
        String msg = br.readLine();
        System.out.println(msg);
    }
}
