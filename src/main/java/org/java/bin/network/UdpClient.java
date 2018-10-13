package org.java.bin.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by wangbin on 17/1/5.
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket(6666);
        double num = 81.92;
        byte[] container = convert(num);

        DatagramPacket packet = new DatagramPacket(container, container.length, new InetSocketAddress("localhost", 8888));
        client.send(packet);
        client.close();

    }

    private static byte[] convert(double num) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeDouble(num);
        return bos.toByteArray();
    }
}
