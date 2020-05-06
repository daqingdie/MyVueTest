package com.lq.demo.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest_4 {
    @Test
    public void send() throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = "测试".getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 8889);
        ds.send(dp);
        System.out.println("发送成功");
        ds.close();
    }

    @Test
    public void receive() throws IOException{
        DatagramSocket ds = new DatagramSocket(8889);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        int length = dp.getLength();
        System.out.println(new String(bytes, 0, length));
        ds.close();
    }
}
