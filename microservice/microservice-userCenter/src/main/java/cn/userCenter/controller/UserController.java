
	/**  
     * @Title: UserController.java
 	 * @Package cn.userCenter.controller
 	 * @Description: )
 	 * @author zhugang
 	 * @date 2019年1月17日
 	 * @version V1.0  
 	 */

        
package cn.userCenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.userCenter.Entity.headResult.ResultJson;
import cn.userCenter.Entity.headResult.UserTableJson;
import cn.userCenter.service.inter.UserServiceInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;
import cn.zg.springcloud.entities.userCenter.UserTest;

/**
  * @ClassName: UserController
  * @Description: 人员管理 - 控制层
  * @author zhugang
  * @date 2019年1月17日
  */
@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger( UserController.class );
	
	@Autowired
	private UserServiceInter userService;
	
	
	 /**   
	  * @Title: getUserAllList   
	  * @Description: 查询所有用户       
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	@PostMapping("/list")
	public UserTableJson<List<UserOrganization>> getUserAllList() {
		logger.debug("--C----------开始获取所有用户-----------");
		List<UserOrganization> userAll = userService.getUserAllListServ();
		if( userAll != null ) {
			return new UserTableJson<List<UserOrganization>>( 
					"", 0,"成功", userAll, userAll.size(),true);
		}
		return new UserTableJson<List<UserOrganization>>( 
				"", 0, "失败", userAll, userAll.size(),true);
	}
	
	
	 /**   
	  * @Title: getUserAllListTest   
	  * @Description:  查询所有用户(测试)             
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	@PostMapping("/list/test")
	public UserTableJson<List<UserTest>> getUserAllListTest() {
		logger.debug("--C----------开始获取所有用户-----------");
		UserTest userTest = new UserTest("王者", 0 , -1);
		UserTest userTest1 = new UserTest("射手", 1 ,0);
		UserTest userTest2 = new UserTest("辅助", 2 ,0);
		UserTest userTest3 = new UserTest("后裔", 11 ,1); 
		ArrayList<UserTest> arrayList = new ArrayList<UserTest>();
		arrayList.add(userTest);
		arrayList.add(userTest1);
		arrayList.add(userTest2);
		arrayList.add(userTest3);
		if( arrayList != null ) {
			return new UserTableJson<List<UserTest>>( 
					"", 0,"成功", arrayList, arrayList.size(),true);
		}
		return new UserTableJson<List<UserTest>>( 
				"", 0, "失败", arrayList, arrayList.size(),true);
	}
	
	
	 /**   
	  * @Title: registryUserContr   
	  * @Description: 注册用户       
	  * @return: ResultJson<String> 返回新增用户主键           
	  */  
	@PostMapping("")
	public ResultJson<String> registryUserContr(@RequestBody @Valid UserOrganization user){
		logger.debug("C----registryContr--- user ---" + user);
		int i = userService.saveUserServ(user);
		logger.debug("C----注册用户返回值 ---" + i);
		if( i < 0 ) {
			return new ResultJson<String>(1, "未知错误", i + "" );
		}else if( i == 0) {
			return new ResultJson<String>(1, "新增用户失败 ，插入数据为0", i + "" );
		}else {
			return new ResultJson<String>(0, "新增用户成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: registryUserInfoContr   
	  * @Description: 注册用户信息       
	  * @return: ResultJson<String>    
	  */  
	@PostMapping("/userInfo")
	public ResultJson<String> registryUserInfoContr( @RequestBody @Valid UserInfo userInfo ){
		logger.debug("C---- 注册用户信息    ---" + userInfo);
		int i = userService.saveUserInfoServ(userInfo);
		if( i < 0 ) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 注册用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "新增用户信息失败 ，插入数据为0", i + "" );
		}else {
			logger.debug("C---- 注册用户信息成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "新增用户成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: deleteUserContro   
	  * @Description: 根据usernum删除用户        
	  * @return: ResultJson<String>        
	  */  
	@DeleteMapping("/{usernum}")
	public ResultJson<String> deleteUserContro(@PathVariable("usernum") @NotNull int usernum) {
		logger.debug("-----C------- 删除用户   ---- usernum： " + usernum);
		int i = userService.deleteUserByNumServ(usernum);
		if( i < 0 ) {
			logger.debug("C---- 删除用户 失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "未知错误，删除失败", i + "" );
		}else if( i == 0) {
			logger.debug("C---- 删除用户信息失败返回值 ---i---" + i);
			return new ResultJson<String>(1, "删除用户信息失败 ，删除数据为0", i + "" );
		}else {
			logger.debug("C---- 删除用户信息成功返回值 ---i---" + i);
			return new ResultJson<String>(0, "删除用户成功", i + "" );
		}
	}
	
	
	 /**   
	  * @Title: modifyUserState   
	  * @Description: 修改用户状态       
	  * @return: ResultJson<String>        
	  */  
	@PutMapping("/{usernum}")
	public ResultJson<String> modifyUserState(@PathVariable("usernum") @NotNull int usernum){
		logger.debug("-----C------- 修改用户状态   ---- usernum： " + usernum);
		return null;
	}
}
