
	/**  
     * @Title: LoginInfoController.java
 	 * @Package cn.userCenter.controller.mongo
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月20日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.controller.mongo;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.util.JSON;

import cn.userCenter.Entity.headResult.ResultJson;
import cn.userCenter.Entity.mongo.UserLogin;
import cn.userCenter.controller.LoginController;
import cn.userCenter.service.impl.mongo.LoginInfoService;
import cn.userCenter.service.inter.UserServiceInter;

/**
  * @ClassName: LoginInfoController
  * @Description: 登录信息控制层
  * @author zhugang
  * @date 2019年1月20日
  */
@RestController
@RequestMapping("/user/loginInfo")
public class LoginInfoController {
	private static Logger logger = LoggerFactory.getLogger( LoginInfoController.class );
	@Autowired
	private LoginInfoService loginInfoService;
	
	
	 /**   
	  * @Title: getUserLoginOutContr   
	  * @Description:  统计用户登录登出信息      
	  * @return: JSONObject        
	  */  
	@GetMapping("/{state}")
	public String getUserLoginOutContr( @PathVariable("state") @NotBlank String state ){
		JSONObject jsonObject = new JSONObject();
		logger.debug("-------C----------统计用户登录登出信息-----------");
		Map<String, List<Object>> map = 
				loginInfoService.getLoginUserNumServ(Integer.parseInt(state));
		if( map != null ) {
			jsonObject.put( "state", 0 );
			jsonObject.put( "message", "统计成功" );
			jsonObject.put( "data", JSONObject.valueToString(map) );
			logger.debug("-------C----------统计用户登录登出信息成功------jsonObject:" + jsonObject);
			return jsonObject.toString();
		}else {
			jsonObject.put( "state", 1 );
			jsonObject.put( "message", "统计失败" );
			jsonObject.put( "data", "" );
			logger.debug("-------C----------统计用户登录登出信息失败------jsonObject:" + jsonObject);
			return jsonObject.toString();
		}
	}
	
}
