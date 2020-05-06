package com.lq.demo.UDP;


import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {
    static MyTime mt=new MyTime();

    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(8889);

        byte[] data=new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        System.out.println("准备接收数据");
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                mt.startTime();
            }
        });
        t.start();
        ds.receive(dp);
        System.out.println("接收数据成功");
        int length = dp.getLength();
        mt.stopTime();
        System.out.println("输出数据:"+new String(data,0,length));
        ds.close();
    }

    static class MyTime{
        int time=1;

        private void startTime(){
            while (time>0){
                try {
                    Thread.sleep(1000);
                    synchronized (this){
                        if(time>0)
                            System.out.println("已等待"+time+"秒钟");
                    }
                    time++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        private synchronized void stopTime(){
            time=-1;
        }
    }

    @Test
    public void test_send() throws IOException {
        DatagramSocket ds=new DatagramSocket();
        byte[] data=new String("测试发送数据").getBytes();
        InetAddress ia=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp=new DatagramPacket(data,data.length,ia,8889);

        System.out.println("准备发送数据");
        ds.send(dp);
        System.out.println("发送数据成功");
        ds.close();
    }

    @Test
    public void test_receive() throws IOException {

    }
}
