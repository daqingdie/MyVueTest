package com.lq.demo.TCP;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest_2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8889);
        Socket socket=ss.accept();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test\\copy.png"));
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        bos.close();
        socket.close();
        ss.close();
    }

    @Test
    public void send() throws IOException {
        Socket socket = new Socket("127.0.0.1",8889);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test\\1.png"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        socket.shutdownOutput();


        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }

        bis.close();
        socket.close();
    }
}
