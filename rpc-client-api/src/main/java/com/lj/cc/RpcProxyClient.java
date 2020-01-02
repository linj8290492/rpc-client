package com.lj.cc;

import java.lang.reflect.Proxy;

/**
 * @author deke
 * @description rpc客户端
 * @date 2020/1/1
 */
public class RpcProxyClient {
    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
