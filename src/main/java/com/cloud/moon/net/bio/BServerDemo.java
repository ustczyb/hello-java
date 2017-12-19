package com.cloud.moon.net.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhangyubo02
 * create time : 2017/11/26.
 */
public class BServerDemo {

    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {

        try(ServerSocket serverSocket= new ServerSocket(PORT)) {
            System.out.println("server init at port:" + PORT);
            while (true) {
                Socket conn = serverSocket.accept();
                InputStream inputStream = conn.getInputStream();
                PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String info = reader.readLine();
                if ("EOF".equalsIgnoreCase(info)) {
                    break;
                }
                System.out.println(info);
                out.println("server msg");
            }
        }
    }
}
