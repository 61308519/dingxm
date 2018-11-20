package cn.com.wind.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Bean
    @LoadBalanced//此注解必须存在
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Autowired
    private RestTemplate restTemplate;
 
	/**
	 * 浏览器访问：http://dingxm-pc:7001/user/hello
	 * @param name
	 * @return
	 */
	@GetMapping("/hello")
	public String sayhello(@RequestParam(required = false, value = "name") String name) {
		return restTemplate.getForEntity("http://eureka-provider/user/hello", String.class, "").getBody();

	}
    
    /**
     * 从注册中心获取所有服务清单。
     * @return
     */
	@RequestMapping(value="/getAllService",method=RequestMethod.GET)
	public Map<String, List<ServiceInstance>> getAllService() {
		Map<String, List<ServiceInstance>> msl = new HashMap<>();
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			List<ServiceInstance> sis = discoveryClient.getInstances(service);
			msl.put(service, sis);
		}
		 return msl;
    }
    
   /* @RequestMapping(value="/sayHi",method=RequestMethod.GET)
    public String sayHi() {
    	
    	ServiceInstance instance=client.getservice
    	return null;
    	
    }*/
    
}
