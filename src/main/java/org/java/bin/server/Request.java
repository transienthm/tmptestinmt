package org.java.bin.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangbin on 17/1/12.
 */
public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String, List<String>> parameterMapValues;

    //内部
    private static final String CRLF = "\r\n";

    private InputStream is;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValues = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        byte[] data = new byte[20480];
        try {
            int len = is.read(data);
            requestInfo = new String(data, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    //分析头信息
    private void parseRequestInfo() {
        if (null == requestInfo || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }
        /**
         * =================================================
         * 从信息的首行分解出：请求方式 请求路径 请求参数
         * 如果为post方式，请求参数可能在正文最后
         * =================================================
         */
        String paramString = "";

        //1、获取请求方式
    }
}
