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
import cn.userCenter.controller.LoginController;
import cn.userCenter.dao.UserInfoMapper;
import cn.userCenter.dao.UserMapper;
import cn.userCenter.service.inter.UserServiceInter;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class LoginControTest {
	@Autowired
	private LoginController loginController;
	
	@Test
	public void loginContrTest(){
		String userName = "亚瑟";
		String userPassword = "123";
		ResultJson<String> loginContr = loginController.loginContr(userName, userPassword);
		System.out.println(loginContr);			
	}
	
}
