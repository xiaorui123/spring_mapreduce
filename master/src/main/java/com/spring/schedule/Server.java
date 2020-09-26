package com.spring.schedule;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {



    public void server() {
        try {
            ServerSocket socket = new ServerSocket(7008);
            socket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
