package com.lq.demo.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest_3 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "测试";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,address,8889);
        ds.send(dp);
        ds.close();
    }

    @Test
    public void receive() throws IOException{
        MulticastSocket ms = new MulticastSocket(8889);
        InetAddress address = InetAddress.getByName("224.0.1.0");
        ms.joinGroup(address);
        byte[] bytes=new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ms.receive(dp);
        int length = dp.getLength();
        System.out.println(new String(bytes,0,length));
        ms.close();
    }
}
