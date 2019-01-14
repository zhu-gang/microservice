
	/**  
     * @Title: LoginController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.userCenter.service.inter.UserServiceInter;

/**
  * @ClassName: LoginController
  * @Description: 登录 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping()
public class LoginController {
	
	@Autowired
	private UserServiceInter userService;
	
	
}
