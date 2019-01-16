
	/**  
     * @Title: userService.java
 	 * @Package cn.userCenter.service.impl
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.userCenter.dao.UserInfoMapper;
import cn.userCenter.dao.UserMapper;
import cn.userCenter.dao.UserRoleMapper;
import cn.userCenter.service.inter.UserServiceInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;
import cn.zg.springcloud.entities.userCenter.UserRole;

	/**
 	 * @ClassName: userService
 	 * @Description: 用户信息服务  - 业务层
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 */
@Service
public class userService implements UserServiceInter{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	 /**   
	  * @Title: getUserOrganById   
	  * @Description: 根据用户id查询用户信息       
	  * @return: UserOrganization        
	  */ 
	@Override
	public UserOrganization getUserOrganById( int userId ) {
		UserOrganization user = userMapper.findUserById(userId);
		return user;
	}
	
	
	
	 /**   
	  * @Title: getUserOrganByUsernum   
	  * @Description: 根据用户唯一标示num查询用户        
	  * @return:         
	  */  
	@Override
	public UserOrganization getUserOrganByUsernum( int usernum ) {
		UserOrganization user = userMapper.findUserByUsernum(usernum);
		return user;
	}
	
	
	
	 /**   
	  * @Title: getUserInfoByUserId   
	  * @Description: 根据用户唯一标示usernum查询用户信息             
	  * @return: UserInfo        
	  */  
	@Override
	public UserInfo getUserInfoByUserId( int usernum ) {
		UserInfo userInfo = userInfoMapper.findUserInfoByUsernum(usernum);
		return userInfo;
	}
	
	
	 /**   
	  * @Title: getUserRoleByUserid   
	  * @Description: 根据用户id查询用户具有的角色           
	  * @return: UserRole        
	  */  
	@Override
	public List<UserRole> getUserRoleByUserid( int userid ) {
		List<UserRole> userRoles = userRoleMapper.findUserRoleByUserId(userid);
		return userRoles;
	}
	
	
	 /**   
	  * @Title: saveUserServ   
	  * @Description: 新增用户       
	  * @return: int        
	  */  
	@Override
	public int saveUserServ(UserOrganization user) {
		
		return 0;
	}

	
	
	
}
