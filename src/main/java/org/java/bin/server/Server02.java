package org.java.bin.server;

import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wangbin on 17/1/9.
 */
public class Server02 {

    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    public static void main(String[] args) {
        Server02 server = new Server02();
        server.start();
    }

    /**
     * 启动方法
     */
    public void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            Socket client = server.accept();
            StringBuilder sb = new StringBuilder();
            String msg = null;

            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);

/*            BufferedReader br = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));

            while ((msg = br.readLine()).length() > 0) {
                sb.append(msg);
                sb.append("\r\n");
                if (msg == null) {
                    break;
                }
            }*/
/*            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);*/

            //响应
            Response response = new Response(client.getOutputStream());
            response.println("<html><head><title>http响应示例" +
                    "</title></head><body>Hello res!</body></html>");
            response.pushToClient(404);

            /*
            StringBuilder response = new StringBuilder();
            //http协议版本、状态码、描述
            response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK");
            //响应头
            response.append("Server:mi server/0.0.1").append(CRLF);
            response.append("Data:").append(new Date()).append(CRLF);
            response.append("Content-type:text/html;charset=UTF-8").append(CRLF);
            response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
//            response.append("Content-Length:").append("123").append(CRLF);
            response.append(CRLF);
            response.append(responseContext);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
            bw.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {

    }
}
