
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.userCenter.controller.LoginController;
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
	private static Logger logger = LoggerFactory.getLogger( userService.class );
	
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
	public UserInfo getUserInfoByUserId( int userid ) {
		UserInfo userInfo = userInfoMapper.findUserInfoById(userid);
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
	  * @return: int  返回新增用户主键      
	  */  
	@Override
	public int saveUserServ(UserOrganization user) {
		try {
			int i = userMapper.saveUserBackId(user);
			//检查插入条数
			if( i < 0 ) {
				return -1;
			}else if(i == 0){
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		logger.debug("---S----新增用户---" + user);
		//检查是否返回主键
		if(user.getOrgid() == null || user.getOrgid().toString().isEmpty()) {
			//重新查询
			UserOrganization newUser = userMapper.findUserByUsernum(user.getUsernum());
			//结果判定
			if( newUser.getOrgid() == null || newUser.getOrgid().toString().isEmpty() ) {
				return 0;
			}else {
				return newUser.getOrgid();
			}
		}
		return user.getOrgid();
	}
	
	
	 /**   
	  * @Title: saveUserInfoServ   
	  * @Description: 新增用户信息       
	  * @return: int 返回数据库受影响的条目       
	  */
	@Override
	public int saveUserInfoServ( UserInfo userInfo ) {
		logger.debug("---S----新增用户------");
		int i ;
		try {
			i = userInfoMapper.saveUserInfo(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
	
	
	 /**   
	  * @Title: getUserAllListServ   
	  * @Description: 查询所有用户       
	  * @return: UserOrganization        
	  */  
	@Override
	public List<UserOrganization> getUserAllListServ() {
		logger.debug("---S----查询所有 用户------");
		List<UserOrganization> userAll = null;
		try {
			userAll = userMapper.findUsersAndState();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userAll;
	}
	
	
	
	 /**   
	  * @Title: deleteUserByNumServ   
	  * @Description:根据usernum删除用户        
	  * @return: int        
	  */  
	@Override
	public int deleteUserByNumServ(int usernum) {
		logger.debug("---S------根据usernum删除用户 ------");
		int i ;
		try {
			i = userMapper.deleteUserByUsernum(usernum);			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return i;
	}
	
}
