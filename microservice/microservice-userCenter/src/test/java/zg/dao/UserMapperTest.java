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
	
	//根据用户唯一标识num查询用户
	//@Test
	public void findUserByUsernum() {
		int userNum = 1;
		UserOrganization u = userMapper.findUserByUsernum(userNum);
		System.out.println(u);
	}
	
	//查询所有用户信息和对应的状态
	@Test
	public void findUsersAndState() {
		List<UserOrganization> findUsersAndState = userMapper.findUsersAndState();
		System.out.println(findUsersAndState);
	}
		
	
	//单个增加用户
	//@Test
	public void saveUser() {		
		String name = "小小";
		int parent_id = 0;
		int usernum = 134;
		String user_password = "123";
		int is_parent = 1; 
		String note = "dota";
		UserOrganization u = new UserOrganization(
				name, parent_id, usernum, user_password, is_parent, note);
		int i = userMapper.saveUser(u);
		System.out.println(i);
	}
	
	//单个增加用户,返回id
	//@Test
	public void saveUserBackId() {		
		String name = "王者荣耀";
		int parent_id = 0;
		int usernum = -1;
		String user_password = "123";
		int is_parent = 0; 
		String note = "王者荣耀";
		UserOrganization u = new UserOrganization(
				name, parent_id, usernum, user_password, is_parent, note);
		//int saveUser = userMapper.saveUser(u);
		int saveUserBackId = userMapper.saveUserBackId(u);
		System.out.println(saveUserBackId);
		System.out.println(u.getOrgid());
	}
	
	//@Test
	//批量增加用户
	public void saveUserByBatch() {
		UserOrganization u1 = new UserOrganization(
				"射手", 0, 1, "", 1, "dota");
		UserOrganization u2 = new UserOrganization(
				"法师", 0, 2, "", 1, "dota");
		UserOrganization u3 = new UserOrganization(
				"辅助", 0, 3, "", 1, "dota");
		UserOrganization u4 = new UserOrganization(
				"坦克", 0, 4, "", 1, "dota");
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
//		u2.setOrgid(13);
//		int i = userMapper.modifyUserById(u2);
//		System.out.println(i);
	}
	
	//根据userId删除用户
	//@Test
	public void deleteUserById() {
		String userId = "13";
		int i = userMapper.deleteUserById(userId);
		System.out.println(i);
		
	}
	
	//根据usernum删除用户
	//@Test
	public void deleteUserByNum() {
		int usernum = 134;
		int i = userMapper.deleteUserByUsernum(usernum);
		System.out.println(i);		
	}
	
}
