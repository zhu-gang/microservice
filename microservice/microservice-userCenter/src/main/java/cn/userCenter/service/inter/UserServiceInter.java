
	/**  
     * @Title: userServiceInter.java
 	 * @Package cn.userCenter.service.inter
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.service.inter;

import java.util.List;

import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;
import cn.zg.springcloud.entities.userCenter.UserRole;

/**
 	 * @ClassName: userServiceInter
 	 * @Description: 
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */

public interface UserServiceInter {
	
	/**   
	  * @Title: getUserOrganById   
	  * @Description: 根据用户id查询用户信息       
	  * @return: UserOrganization        
	  */
	public UserOrganization getUserOrganById( int userId );

	
	 /**   
	  * @Title: getUserInfoByUserId   
	  * @Description: 根据用户唯一标示usernum查询用户信息        
	  * @return: UserInfo        
	  */  
	public UserInfo getUserInfoByUserId(int usernum);


	
	 /**   
	  * @Title: getUserRoleByUserid   
	  * @Description: 根据用户id查询用户具有的角色           
	  * @return: UserRole        
	  */  
	public List<UserRole> getUserRoleByUserid(int userid);


	
	 /**   
	  * @Title: getUserOrganByUsernum   
	  * @Description:   根据用户唯一标示num查询用户          
	  * @return: UserOrganization        
	  */  
	UserOrganization getUserOrganByUsernum(int usernum);


	
	 /**   
	  * @Title: saveUserServ   
	  * @Description:  新增用户      
	  * @return: int        
	  */  
	int saveUserServ(UserOrganization user);
}
