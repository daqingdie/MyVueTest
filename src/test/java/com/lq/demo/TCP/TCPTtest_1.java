package com.lq.demo.TCP;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTtest_1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8889);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        System.out.println("发送完毕");
        outputStream.close();
        System.out.println("输出流关闭");
        socket.close();
        System.out.println("socket关闭");
    }

    @Test
    public void serve() throws IOException {
        ServerSocket ss = new ServerSocket(8889);

        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();

        int b=inputStream.read();
        System.out.println("准备接收");
        while (b != -1) {
            System.out.print((char)b);
            b=inputStream.read();
        }
        System.out.println();
        System.out.println("接收完毕");
        inputStream.close();
        socket.close();
        ss.close();
    }
}
