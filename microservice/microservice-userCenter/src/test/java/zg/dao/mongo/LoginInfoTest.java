package zg.dao.mongo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.userCenter.UserCenter_8001;
import cn.userCenter.Entity.mongo.UserLogin;
import cn.userCenter.dao.UserMapper;
import cn.userCenter.dao.mongo.UserLoginDao;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class LoginInfoTest {
	@Autowired
	public UserLoginDao userLoginDao;
	
	//单个插入
	//@Test
	public void saveLoginInfo() {
		UserLogin userLogin = new UserLogin();
		userLogin.setOrgid(1345);
		userLogin.setOrgName("射手");
		userLogin.setUsernum(11);
		userLogin.setUsername("后裔");
		userLogin.setUseState(0);
		userLogin.setLoginOutTime(new Date(System.currentTimeMillis()));
		UserLogin save = userLoginDao.save(userLogin);
		System.out.println(save);
	}
	
	//批量插入
	//@Test
	public void saveLoginInfoInBatch() {
		UserLogin userLogin1 = new UserLogin(11,"后裔",1234,"射手",
				0,new Date(System.currentTimeMillis()));
		UserLogin userLogin2 = new UserLogin(12,"伽罗",1234,"射手",
				0,new Date(System.currentTimeMillis()));
		UserLogin userLogin3 = new UserLogin(13,"小短腿",1234,"射手",
				0,new Date(System.currentTimeMillis()));
		UserLogin userLogin4 = new UserLogin(13,"小短腿",1234,"射手",
				1,new Date(System.currentTimeMillis()));
		UserLogin userLogin5 = new UserLogin(11,"后裔",1234,"射手",
				0,new Date(System.currentTimeMillis()));
		UserLogin userLogin6 = new UserLogin(12,"伽罗",1234,"射手",
				1,new Date(System.currentTimeMillis()));
		ArrayList<UserLogin> arrayList = new ArrayList<UserLogin>();
		arrayList.add(userLogin1);
		arrayList.add(userLogin2);
		arrayList.add(userLogin3);
		arrayList.add(userLogin4);
		arrayList.add(userLogin5);
		arrayList.add(userLogin6);
		List<UserLogin> saveAll = userLoginDao.saveAll(arrayList);
		System.out.println(saveAll);
	}
	
	
	//单个查询
	//@Test
	public void findLoginInfoByNum() {
		int num = 12;
		Optional<UserLogin> findById = userLoginDao.findById(num);
		System.out.println(findById);
	}
	
	@Test
	public void findLoginInfo() {
		int i = 0;
		List<UserLogin> findAllByUseState = userLoginDao.findAllByUseState(i);
		System.out.println(findAllByUseState);
	}
}
