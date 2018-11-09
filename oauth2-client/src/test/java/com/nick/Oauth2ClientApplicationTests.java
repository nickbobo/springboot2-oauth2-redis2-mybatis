package com.nick;

//import com.nick.bean.User;
//import com.nick.service.UserService;
import com.nick.bean.User;
import com.nick.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Oauth2ClientApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(Oauth2ClientApplicationTests.class);

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {

	}

	@Test
	public void get() {

		int id = 17;
		final User user = userService.insert (new User(id, "u5", "p5",2));
		log.info("[saveOrUpdate] - [{}]", user);
		//而添加、修改、删除都是会进入方法内执行具体的业务代码，然后通过切面去删除掉Redis中的缓存数据。
		// 其中 # 号代表这是一个 SpEL 表达式
		final User user1 = userService.find(id); //查询是没有日志输出的，因为它直接从缓存中获取的数据
		log.info("[get] - [{}]", user1);
		userService.delete(id);
	}
}
