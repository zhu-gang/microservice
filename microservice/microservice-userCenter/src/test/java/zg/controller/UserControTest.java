package zg.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import cn.userCenter.UserCenter_8001;
import cn.userCenter.Entity.headResult.ResultJson;
import cn.userCenter.Entity.headResult.UserTableJson;
import cn.userCenter.controller.LoginController;
import cn.userCenter.controller.UserController;
import cn.userCenter.dao.UserInfoMapper;
import cn.userCenter.dao.UserMapper;
import cn.userCenter.service.inter.UserServiceInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class UserControTest {
	@Autowired
	private UserController userController;
	
	
	 /**   
	  * @Title: getUserAllList   
	  * @Description:  获取所有用户      
	  * @return: UserTableJson<List<UserOrganization>>        
	  */  
	//@Test
	public void getUserAllList() {
		UserTableJson<List<UserOrganization>> userAllList = userController.getUserAllList();
		System.out.println(userAllList);
	}
	
	
	 /**   
	  * @Title: deleteUserContro   
	  * @Description:  根据usernum删除用户          
	  * @return: void        
	  */  
	@Test
	public void deleteUserContro(){
		int usernum = 134;
		ResultJson<String> deleteUserContro = userController.deleteUserContro(usernum);
		System.out.println(deleteUserContro);
	}
	
	
}
