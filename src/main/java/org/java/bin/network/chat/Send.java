package org.java.bin.network.chat;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by wangbin on 17/1/8.
 */
public class Send implements Runnable {
    // 控制台输入流
    private BufferedReader console;
    //控制台输出流
    private DataOutputStream dos;
    private boolean isRunning = true;
    private String name;

    public Send() {
        this.console = new BufferedReader(
                new InputStreamReader(System.in)
        );
    }

    public Send(Socket client,String name) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(this.name);
        } catch (IOException ex) {
            isRunning = false;
            CloseUtil.closeAll(dos, console);
        }
    }

    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException ex) {
        }
        return "";
    }

    /**
     * 1. 从控制台接收数据
     * 2. 发送数据
     */
    public void send(String msg) {

        try {
            if (msg != null && msg != "") {
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException ex) {
            isRunning = false;
            CloseUtil.closeAll(dos, console);
        }

    }

    @Override
    public void run() {
        while (isRunning) {
            send(getMsgFromConsole());
        }
    }
}
