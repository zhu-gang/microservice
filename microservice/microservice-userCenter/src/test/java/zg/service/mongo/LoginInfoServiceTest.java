package zg.service.mongo;

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
import cn.userCenter.service.inter.mongo.LoginInfoInter;
import cn.zg.springcloud.entities.userCenter.UserOrganization;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UserCenter_8001.class })
@WebAppConfiguration
public class LoginInfoServiceTest {
	@Autowired
	private LoginInfoInter loginInfoInter;
	
	//单个插入
	@Test
	public void getLoginUserNumServTest() {
		int i = 0;
		Map<String, List<Object>> loginUserNumServ = loginInfoInter.getLoginUserNumServ(i);
		System.out.println(loginUserNumServ);
	}
}
