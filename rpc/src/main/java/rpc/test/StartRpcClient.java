package main.java.rpc.test;

import main.java.rpc.client.RPCClient;
import main.java.rpc.producer.ServiceProducer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class StartRpcClient {
    public static void main(String[] args) throws IOException {

        ServiceProducer service = RPCClient.getRemoteProxyObj(ServiceProducer.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sendData("test"));
    }
}