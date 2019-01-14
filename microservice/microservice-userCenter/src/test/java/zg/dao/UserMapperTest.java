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
import cn.userCenter.dao.UserMapper;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class UserMapperTest {
	@Autowired
	public UserMapper userMapper;
	
	//@Test
	public void findUserById() {
		//String userId
	}
	
	//单个增加用户
	//@Test
	public void saveUser() {		
		String name = "小小";
		int parent_id = 0;
		int usernum = 1;
		String user_password = "123";
		int is_parent = 1; 
		String note = "dota";
		UserOrganization u = new UserOrganization(
				name, parent_id, usernum, user_password, is_parent, note);
		int i = userMapper.saveUser(u);
		System.out.println(i);
	}
	
	//@Test
	//批量增加用户
	public void saveUserByBatch() {
		UserOrganization u1 = new UserOrganization(
				"娜迦", 1, 2, "123", 1, "dota");
		UserOrganization u2 = new UserOrganization(
				"小黑", 1, 3, "123", 1, "dota");
		UserOrganization u3 = new UserOrganization(
				"冰女", 1, 4, "123", 1, "dota");
		UserOrganization u4 = new UserOrganization(
				"亚瑟", 1, 5, "123", 1, "dota");
		ArrayList<UserOrganization> list = new ArrayList<UserOrganization>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		int i = userMapper.saveUserByBatch(list);
		System.out.println(i);
	}
	
	//修改用户
	//@Test
	public void modifyUserById() {
		UserOrganization u2 = new UserOrganization(
				"小黑", 1, 3, "123456", 1, "dota");
		u2.setOrgid(13);
		int i = userMapper.modifyUserById(u2);
		System.out.println(i);
	}
	
	//删除用户
	@Test
	public void deleteUserById() {
		String userId = "13";
		int i = userMapper.deleteUserById(userId);
		System.out.println(i);
		
	}
	
}
