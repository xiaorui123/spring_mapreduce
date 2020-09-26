package com.spring.schedule;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.function.Consumer;

public interface IRPC {

    /**
     * 服务端监听端口并注入消息回调接口
     *
     * @param port
     * @param function
     */
    void server(int port, Consumer<AskForTaskReq> function) throws IOException;


    /**
     * 客户端连接服务端
     *
     * @param port
     * @return
     */
    SocketChannel doConnect(String host, int port) throws IOException;


    /**
     * 客户端向服务端请求任务
     * @param req
     * @return
     */
    AskForTaskRes askForTask(AskForTaskReq req) throws IOException, InterruptedException;


}
