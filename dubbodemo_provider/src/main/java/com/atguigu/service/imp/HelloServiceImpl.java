package com.atguigu.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shkstart
 * @create 2021-11-22 13:33
 */
//注意：这个是Dubbo框架提供的注解。用于发布指定的服务到注册中心（zookeeper) ，注册中心必须是开启状态
@Service(interfaceClass = HelloService.class)
@Transactional //开启事务支持，但是开启事务后，就不能发布事务了 ；生成了JDK动态代理 com.sun.proxy.$Proxy42//proxy-target-class="true" 采用cjlib代理增加事务切面操作。 Cglib代理基于继承的。 Cglib是目标类的一个子类事务是可以加上去的，注解是加在父类上，子类可以继承
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("name = 8081");
        return "8081hello " + name;
    }
}

