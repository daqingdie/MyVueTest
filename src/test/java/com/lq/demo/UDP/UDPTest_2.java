package com.lq.demo.UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPTest_2 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        while(true){
            String s = in.nextLine();
            byte[] bytes=s.getBytes();
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length,byName,8889);
            ds.send(dp);
            if (s.equals("886")) {
                break;
            }
        }
        ds.close();
        in.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramSocket ds = new DatagramSocket(8889);
        while (true){
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);
            int length = dp.getLength();
            String s = new String(bytes, 0, length);
            if (s.equals("886")) {
                break;
            }
            System.out.println(s);
        }
        ds.close();
    }
}
