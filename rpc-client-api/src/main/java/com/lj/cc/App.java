package com.lj.cc;

import com.lj.cc.service.HelloService;

/**
 * @author deke
 * @description 客户端调用入口
 * @date 2020/1/1
 */
public class App {

    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();

        HelloService helloService = rpcProxyClient.clientProxy(HelloService.class, "localhost", 8080);
        String result = helloService.sayHello("pipi");
        System.out.println(result);

    }
}
