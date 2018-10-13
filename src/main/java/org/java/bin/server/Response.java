package org.java.bin.server;

import java.io.*;
import java.util.Date;

/**
 * Created by wangbin on 17/1/11.
 */
public class Response {

    //存储头信息
    private StringBuilder headInfo;
    private StringBuilder content;


    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    //流
    private BufferedWriter bw;

    //存储正文长度
    private int len = 0;

    public Response() {
        headInfo = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }


    //构建正文
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    /**
     * 构建正文+回车
     *
     * @param info
     * @return
     */
    public Response println(String info) {
        content.append(info).append(CRLF);
        len += info.getBytes().length;
        return this;
    }

    //推送到客户端
    public void pushToClient(int code) throws IOException{
        if (headInfo == null) {
            code = 500;
        }
        createHeadInfo(code);
        bw.append(headInfo.toString());
        System.out.println(headInfo);
        bw.append(content.toString());
        bw.flush();
        close();
    }

    public void close() {
        CloseUtil.closeAll(bw);
    }

    /**
     * 构建响应头
     *
     * @param code
     */
    private void createHeadInfo(int code) {
        //http协议版本、状态码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        /*switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 505:
                headInfo.append("SERVER ALART");
                break;
        }*/
        headInfo.append(CRLF);
        //响应头
        headInfo.append("Server:mi server/0.0.1").append(CRLF);
        headInfo.append("Data:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
}
