package zg.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.userCenter.UserCenter_8001;
import cn.userCenter.dao.UserInfoMapper;
import cn.userCenter.dao.UserMapper;
import cn.zg.springcloud.entities.userCenter.UserInfo;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class UserInfoTest {
	@Autowired
	public UserInfoMapper userInfoMapper;
	
	//@Test
	public void findUserById() {
		//String userId
	}
	
	//@Test
	public void saveUserInfo() {
		UserInfo u = new UserInfo();
		u.setUserid(3);
		u.setNname("阿珂");
		u.setAge(10);
		u.setSex(1);
		u.setAddress("王者荣耀");
		u.setTelephone(1234567890);
		u.setEmail("123@qq.com");
		u.setNote("用工具");
		u.setState(1);		
		u.setRemark1(111);
		u.setRemark2("");
		int i = userInfoMapper.saveUserInfo(u);
		System.out.println(1);		
	}
	
	@Test
	public void modifyUserInfoById() {
		UserInfo u = new UserInfo();
		u.setUserid(3);
		u.setNname("阿珂");
		u.setAge(10);
		u.setSex(1);
		u.setAddress("王者荣耀");
		u.setTelephone(1234567890);
		u.setEmail("123@qq.com");
		u.setNote("隐身");
		u.setState(1);		
		u.setRemark1(111);
		u.setRemark2("");
		int i = userInfoMapper.modifyUserInfoById(u);
		System.out.println(i);
	}
}
