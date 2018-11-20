package cn.com.wind;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/user")
public class UserController {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${server.port}")
	private int serverPort;
	
	@RequestMapping("/hello")
    public String hello() {
		
        return "response msg from "+this.applicationName+" "+this.serverPort+"--Hello "+new Date();
    }

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	
	
	
	
}
