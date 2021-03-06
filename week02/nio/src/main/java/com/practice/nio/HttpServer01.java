package com.practice.nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8801);
            while (true) {
                Socket client = serverSocket.accept();
                service(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void service(Socket socketObj) {
        try {
            PrintWriter pw = new PrintWriter(socketObj.getOutputStream(), true);
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type:text/html;charset=utf-8");
            String body = "hello, nio1";
            pw.println("Content-Length:" + body.getBytes().length);
            pw.println();
            pw.write(body);
            pw.close();
            socketObj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
