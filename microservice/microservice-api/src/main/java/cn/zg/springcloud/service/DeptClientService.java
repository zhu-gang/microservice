/**  
 * @Title: DeptClientService.java
 * @Package cn.zg.springcloud.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月2日
 * @version V1.0  
 */

        
package cn.zg.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zg.springcloud.entities.Dept;

/**
 * @ClassName: DeptClientService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhugang
 * @date 2019年1月2日
 *
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);
	 
	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	public List<Dept> list();
	 
	@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	public boolean add(Dept dept);
}
