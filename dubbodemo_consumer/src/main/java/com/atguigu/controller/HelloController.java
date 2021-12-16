package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-11-22 14:56
 */
@RestController //等价于@Controller + @ResponseBody
@RequestMapping("/demo")
public class HelloController {

    //@Autowired 原来使用，注入当前IOC容器里的bean对象
    //@Reference //引用远程服务对象（从Zookeeper中订阅服务），进行远程调用，订阅服务
    @Reference(loadbalance = "roundrobin")//默认是random，loadbalance设置负载均衡的策略
    HelloService helloService;//代理对象

    //由于类上面也有requestMapping 所以访问路径为/demo/sayHello
    @RequestMapping("/sayHello")
    public String sayHello(String name){
        String string = helloService.sayHello(name); //调用远程接口 RPC
        return string;
    }

}
