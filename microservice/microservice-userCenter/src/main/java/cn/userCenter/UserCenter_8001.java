/**  
 * @Title: DeptProvider8001_App.java
 * @Package cn.zg.springcloud
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2018年12月28日
 * @version V1.0  
 */

        
package cn.userCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @ClassName: DeptProvider8001_App
 * @Description: 用户服务中心
 * @author zhugang
 * @date 2018年12月28日
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class UserCenter_8001 {

	/** 
	 * @Title: main 
	 * @Description: TODO 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(UserCenter_8001.class, args);
	}
}
