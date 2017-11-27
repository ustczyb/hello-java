package com.cloud.moon.net.bio;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author zhangyubo02
 * create time : 2017/11/26.
 */
public class BClientDemo {

    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("client msg");
            System.out.println("send msg");
            String responseStr = in.readLine();
            System.out.println("response : " + responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
