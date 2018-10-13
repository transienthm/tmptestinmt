package org.java.bin.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by wangbin on 2017/10/24.
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = null;
        Channel channel = null;
        Connection connection = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost("116.196.86.250");
            //factory.setPort(5672);

            //设置访问的用户
            factory.setUsername("test");
            factory.setPassword("test");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world! fuck you !";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Send '" + message + "'");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
