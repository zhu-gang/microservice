
	/**  
     * @Title: UserLogin.java
 	 * @Package cn.userCenter.dao.mongo
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月20日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.dao.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cn.userCenter.Entity.mongo.UserLogin;


/**
  * @ClassName: UserLogin
  * @Description: mongodb - 登录信息dao层
  * @author zhugang
  * @date 2019年1月20日
  */
@Repository
public interface UserLoginDao extends MongoRepository<UserLogin, Integer> {
	
	
	 /**   
	  * @Title: findAllByUseState   
	  * @Description: 根据用户使用状态查询，0-登录，1-退出       
	  * @return: List<UserLogin>        
	  */  
	public List<UserLogin> findAllByUseState( int i );
}
