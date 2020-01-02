package com.lj.cc;

import com.lj.cc.vo.RpcRequestVo;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author deke
 * @description 客户端发送请求
 * @date 2020/1/1
 */
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport() {
    }

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @SneakyThrows
    public Object send(RpcRequestVo request) {
        Socket socket = new Socket(host, port);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object result = objectInputStream.readObject();

        if (null != objectInputStream) {
            objectInputStream.close();
        }
        if (null != objectOutputStream) {
            objectOutputStream.close();
        }
        return result;
    }
}
