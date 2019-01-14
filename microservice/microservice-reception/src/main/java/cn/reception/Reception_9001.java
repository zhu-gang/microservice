/**  
 * @Title: DeptConsumer80_App.java
 * @Package cn.zg.springcloud
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2018年12月28日
 * @version V1.0  
 */

        
package cn.reception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: DeptConsumer80_App
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhugang
 * @date 2018年12月28日
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Reception_9001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Reception_9001.class, args);
	}

}
