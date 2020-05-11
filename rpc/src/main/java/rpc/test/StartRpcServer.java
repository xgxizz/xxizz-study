package main.java.rpc.test;

import main.java.rpc.producer.ServiceProducer;
import main.java.rpc.producer.ServiceProducerImpl;
import main.java.rpc.server.Server;
import main.java.rpc.server.ServiceCenter;

import java.io.IOException;

public class StartRpcServer {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Server serviceServer = new ServiceCenter(8088);
                serviceServer.register(ServiceProducer.class, ServiceProducerImpl.class);
                serviceServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
