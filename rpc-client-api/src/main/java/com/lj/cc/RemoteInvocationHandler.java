package com.lj.cc;

import com.lj.cc.vo.RpcRequestVo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author deke
 * @description 动态代理发送信息
 * @date 2020/1/1
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler() {
    }

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come  in.....");
        RpcRequestVo rpcRequestVo = new RpcRequestVo();
        rpcRequestVo.setClassName(method.getDeclaringClass().getName());
        rpcRequestVo.setMethodName(method.getName());
        rpcRequestVo.setParams(args);

        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        return rpcNetTransport.send(rpcRequestVo);
    }
}
