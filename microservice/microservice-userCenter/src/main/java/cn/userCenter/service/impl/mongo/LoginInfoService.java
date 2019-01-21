
	/**  
     * @Title: LoginInfoService.java
 	 * @Package cn.userCenter.service.impl.mongo
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月20日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.service.impl.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.userCenter.Entity.mongo.UserLogin;
import cn.userCenter.controller.mongo.LoginInfoController;
import cn.userCenter.dao.mongo.UserLoginDao;
import cn.userCenter.service.inter.mongo.LoginInfoInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;

/**
  * @ClassName: LoginInfoService
  * @Description: 登录信息 - 业务层实现
  * @author zhugang
  * @date 2019年1月20日
  */

@Service
public class LoginInfoService implements LoginInfoInter {
	private static Logger logger = LoggerFactory.getLogger( LoginInfoService.class );
	
	@Autowired
	private UserLoginDao userLoginDao;
	
	
	 /**   
	  * @Title: findLoginInfoServ   
	  * @Description: 根据用户usernum查询用户登录信息       
	  * @return: UserLogin        
	  */  
	@Override
	public UserLogin findLoginInfoServ( int usernum) {
		UserLogin loginInfo = new UserLogin();
		try {
			Optional<UserLogin> userLoginInfo = userLoginDao.findById(usernum);
			loginInfo = userLoginInfo.get();
			logger.debug("---S----------------查询指定用户登陆信息---loginInfo:" + loginInfo);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return loginInfo;
	}
	
	
	 /**   
	  * @Title: getLoginUserNumServ   
	  * @Description: 根据用户的登录信息，统计用户登录次数       
	  * @return: Map<String,List<Integer>>        
	  */  
	@Override
	public Map<String, List<Object>> getLoginUserNumServ( int i ) {
		Map<String,List<Object>> map = new HashMap<String,List<Object>>();
		List<Object> listUser = new ArrayList<Object>();
		List<Object> listNum = new ArrayList<Object>();
		List<Object> listName = new ArrayList<Object>();
		try {
			List<UserLogin> loginInfos = userLoginDao.findAllByUseState(i);
			logger.debug("---S----------------查询所有用户登陆信息---loginInfos:" + loginInfos);
			for( UserLogin u : loginInfos) {
				Integer num = u.getUsernum();
				if( num != null && !num.toString().isEmpty() ) {
					if( listUser.contains(num) ) {
						int index = listUser.indexOf(num);
						int orginalValue = (int) listNum.get(index);
						listNum.set( index, orginalValue + 1 );
					}else {
						listUser.add(num);						
						listNum.add(1);
						listName.add(u.getUsername());
					}
				}else {
					continue;
				}
			}
			logger.debug("---S----------------查询所有用户登陆信息---listUser:" + listUser);	
			logger.debug("---S----------------查询所有用户登陆信息---listNum:" + listNum);	
			logger.debug("---S----------------查询所有用户登陆信息---listName:" + listName);	
			map.put( "user", listUser);
			map.put( "num", listNum);
			map.put( "name", listName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}
	
}
