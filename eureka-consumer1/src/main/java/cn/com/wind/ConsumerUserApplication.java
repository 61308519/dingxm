package cn.com.wind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 也可以使用@EnableEurekaClient注解代替@EnableDiscoveryClient。在Spring Cloud中，服务发现组件也有多种选择，例如Zookeeper、Consul等。
　　　　@EnableEurekaClient：表明是Eureka的Client，该注解时spring-cloud-netflix项目中的注解，只能与Eureka一起工作。
　　　　@EnableDiscoveryClient：为各个服务组件提供了支持，该注解时spring-cloud-commons项目的注解，是一个高度的抽象。
 * @author dingxm
 *
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }
}
