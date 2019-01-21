
	/**  
     * @Title: LoginController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月12日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.userCenter.Entity.headResult.ResultJson;
import cn.userCenter.service.inter.UserServiceInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

/**
  * @ClassName: LoginController
  * @Description: 登录 - 控制层
  * @author zhugang
  * @date 2019年1月12日
  */

@RestController
@RequestMapping("/user")
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger( LoginController.class );
	
	@Autowired
	private UserServiceInter userService;
	
	
	 /**   
	  * @Title: loginContr   
	  * @Description: 登录验证       
	  * @return: ResultJson<String>        
	  */  
	@GetMapping( "/{userName}/{userPassword}")
	public ResultJson<String> loginContr(@PathVariable("userName") @NotBlank String userName,
			@PathVariable("userPassword") @NotBlank String userPassword){
		logger.debug("-------C----------开始登陆-----------");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), userPassword.trim());
		ResultJson<String> resultJson = null;
		try {
			subject.login(token);
			resultJson = new ResultJson<String>(0, "登录成功", subject.getSession().getId() + "");
			//jsonObject.put("token", subject.getSession().getId());
			//jsonObject.put("msg", "登录成功");
		} catch (IncorrectCredentialsException e) {
			resultJson = new ResultJson<String>(0, "密码错误", null);
		} catch (DisabledAccountException e) {
			resultJson = new ResultJson<String>(0, "登录失败，该用户已被冻结", null);
		} catch (UnknownAccountException e) {
			resultJson = new ResultJson<String>(0, "该用户不存在", null);
		} catch (AuthenticationException e) {
			resultJson = new ResultJson<String>(0, "未知shiro错误", null);
		} catch (Exception e) {
			e.printStackTrace();
			resultJson = new ResultJson<String>(0, "未知错误", null);
		}
		return resultJson;
	}
	

}
