package org.java.bin.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by wangbin on 17/1/5.
 */
public class UdpServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket server = new DatagramSocket(8888);
        byte[] container = new byte[1024];

        DatagramPacket packet = new DatagramPacket(container, container.length);
        server.receive(packet);
        byte[] content = packet.getData();
        System.out.println(convert(content));

        server.close();

    }

    private static double convert(byte[] msg) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(msg);
        DataInputStream dis = new DataInputStream(bis);
        return dis.readDouble();
    }
}
