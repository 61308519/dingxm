package cn.com.wind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.wind.service.UserFeignClient;


@RestController
@RequestMapping("/feignuser")
public class UserFeignController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	/**
	 * 浏览器访问：http://dingxm-pc:7001/feignuser/feignHello
	 * @param name
	 * @return
	 */
	@GetMapping("/feignHello")
	public String sayhello(@RequestParam(required = false, value = "name") String name) {
		return userFeignClient.sayhello();

	}
   
}
