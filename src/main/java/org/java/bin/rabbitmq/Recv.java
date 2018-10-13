package org.java.bin.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangbin on 2017/10/25.
 */
public class Recv {
    ConnectionFactory connectionFactory;
    String host;
    int port;
    String user;
    String password;
    String queueName;
    Connection connection;
    Channel channel;
    Consumer consumer;
    List<String> msgs;

    public Recv(String host, int port, String user, String password, String queueName) {
        connectionFactory = new ConnectionFactory();
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.queueName = queueName;
        connectionFactory.setHost(host);
        //connectionFactory.setPort(port);
        connectionFactory.setUsername(user);
        connectionFactory.setPassword(password);
        msgs = new ArrayList<>();
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(queueName, false, false, false, null);
            consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String msg = new String(body, "UTF-8");
                    msgs.add(msg);
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Recv recv = new Recv("116.196.86.250", 5672, "test", "test", "hello");
            while (true) {
                recv.channel.basicConsume(recv.queueName, true, recv.consumer);

                if (!recv.msgs.isEmpty()) {
                    System.out.println("[x] recv = " + recv.msgs.get(recv.msgs.size() - 1) + ", rest msg = " + (recv.msgs.size() - 1));
                    recv.msgs.remove(recv.msgs.size() - 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
