package com.atguigu.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;

/**
 * @author shkstart
 * @create 2021-11-22 13:33
 */
//注意：这个是Dubbo框架提供的注解。用于发布指定的服务到注册中心（zookeeper) ，注册中心必须是开启状态
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("name = 8089");
        return "8089hello " + name;
    }
}

