package com.cloud.moon.asyn;

/**
 * Created by zhangyubo02 on 2017/9/27.
 */
public class Client implements CSCallBack {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String msg){
        System.out.println("客户端：发送的消息为：" + msg);
        new Thread(() -> server.getClientMsg(Client.this,msg)).start();
        System.out.println("客户端：异步发送成功");
    }

    @Override
    public void process(String status) {
        System.out.println("客户端：服务端回调状态为：" + status);
    }
}