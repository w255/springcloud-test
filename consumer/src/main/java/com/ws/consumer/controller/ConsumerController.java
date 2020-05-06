package com.ws.consumer.controller;

import com.ws.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate rt;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/{id}")
    public User queryById(@PathVariable long id){
        String url="";
        //获取eureka中注册的user-service中的实例
        List<ServiceInstance> ServiceInstances = discoveryClient.getInstances("USER-SERVICE");
        //当前注册只有一个实例,所以获取0即可
        ServiceInstance serviceInstance = ServiceInstances.get(0);
        url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        User user=rt.getForObject(url,User.class);
        return user;
    }
}
