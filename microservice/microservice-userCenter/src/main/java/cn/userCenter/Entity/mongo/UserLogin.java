
	/**  
     * @Title: UserLogin.java
 	 * @Package cn.zg.springcloud.entities.userCenter.mongo
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月20日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.Entity.mongo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.zg.springcloud.entities.userCenter.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
  * @ClassName: UserLogin
  * @Description: 登录信息记录
  * @author zhugang
  * @date 2019年1月20日
  */

@SuppressWarnings( "serial" )
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors( chain=true )
@Document(collection="test")
public class UserLogin implements Serializable {
	private Integer usernum;
	private String username; 
	private Integer orgid;
	private String orgName;
	private Integer useState;
	private Date loginOutTime;
	
//	public UserLogin(Integer usernum, String username, Integer orgid,
//			String orgName, Date loginTime, Date logoutTime ) {
//		this.usernum = usernum;
//		this.username = username;
//		this.orgid = orgid;
//		this.orgName = orgName;
//		this.loginTime = loginTime;
//		this.logoutTime = logoutTime;
//	}
}
