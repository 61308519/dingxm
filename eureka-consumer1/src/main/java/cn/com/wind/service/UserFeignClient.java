package cn.com.wind.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "eureka-provider")
public interface UserFeignClient {
	
	@GetMapping("/user/hello")
	public String sayhello();
  
}
