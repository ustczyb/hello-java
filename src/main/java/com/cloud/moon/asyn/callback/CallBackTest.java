package com.cloud.moon.asyn.callback;

/**
 * Created by zhangyubo02 on 2017/9/27.
 */
public class CallBackTest {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        for (int i = 0; i < 5; i++) {
            client.sendMsg("Server,Hello~");
        }
    }
}