package org.java.bin.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangbin on 17/1/5.
 */
public class TcpServer {

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8888);
        while (true) {

            Socket socket = server.accept();
            ServerThread serverThread = new ServerThread(socket);
            Thread thread = new Thread(serverThread);
            thread.start();

        }
    }
}

class ServerThread implements Runnable {
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedWriter bw = null;
        OutputStream out = null;
        try {

            out = socket.getOutputStream();
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            out
                    )
            );
            System.out.println("一个客户端访问");
            bw.write("欢迎访问");
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Closeable[] resources = {bw, out};
            closeResource(resources);
        }

    }

    public void closeResource(Closeable[] res) {
        for (Closeable c : res) {
            try {
                if (null != c) {
                    c.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}