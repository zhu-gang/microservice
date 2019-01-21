
	/**  
     * @Title: LoginInfoInter.java
 	 * @Package cn.userCenter.service.inter
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月20日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.service.inter.mongo;

import java.util.List;
import java.util.Map;

import cn.userCenter.Entity.mongo.UserLogin;

/**
  * @ClassName: LoginInfoInter
  * @Description: 登录信息 - 业务层接口
  * @author zhugang
  * @date 2019年1月20日
  */

public interface LoginInfoInter {

	
	 /**   
	  * @Title: findLoginInfoServ   
	  * @Description: 根据用户usernum查询用户登录信息              
	  * @return: UserLogin        
	  */  
	UserLogin findLoginInfoServ(int usernum);

	
	 /**   
	  * @Title: getLoginUserNumServ   
	  * @Description: 根据用户的登录信息，统计用户登录次数              
	  * @return: Map<String,List<Integer>>        
	  */  
	Map<String, List<Object>> getLoginUserNumServ(int i);

}
