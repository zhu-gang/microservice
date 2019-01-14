/**  
 * @Title: Zuul_9527_StartSpringCloudApp.java
 * @Package cn.zg.springcloud
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月3日
 * @version V1.0  
 */

        
package cn.zg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: Zuul_9527_StartSpringCloudApp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhugang
 * @date 2019年1月3日
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class Zuul_9527_StartSpringCloudApp {
	public static void main(String[] args)
	  {
	   SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	  }

}
