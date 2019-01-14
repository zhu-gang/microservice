/**  
 * @Title: DeptClientServiceFallbackFactory.java
 * @Package cn.zg.springcloud.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhugang
 * @date 2019年1月2日
 * @version V1.0  
 */

        
package cn.zg.springcloud.service;

import java.util.List;

import cn.zg.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;

/**
 * @ClassName: DeptClientServiceFallbackFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhugang
 * @date 2019年1月2日
 *
 */

public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{

	
	 /**   
	  * <p>Title: create</p>   
	  * <p>Description: </p>   
	  * @param arg0
	  * @return
	  */
	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
		     @Override
		     public Dept get(long id)
		     {
		       return new Dept().setDeptno(id)
		               .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
		               .setDb_source("no this database in MySQL");
		     }
		 
		     @Override
		     public List<Dept> list()
		     {
		       return null;
		     }
		 
		     @Override
		     public boolean add(Dept dept)
		     {
		       return false;
		     }
		   };
		  }
		}
		 
		 
		 

