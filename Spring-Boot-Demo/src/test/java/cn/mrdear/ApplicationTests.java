package cn.mrdear;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.mrdear.entity.User;

import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	// 保存字符串
	@Test
	public void testString() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
	
	//保存对象
	@Test
	public void testSetObj() throws Exception {
		User user = new User(1, "超人", "20");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new User(2, "蝙蝠侠", "30");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new User(3, "蜘蛛侠", "40");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		Assert.assertEquals("20", redisTemplate.opsForValue().get("超人").getPassword());
		Assert.assertEquals("30", redisTemplate.opsForValue().get("蝙蝠侠").getPassword());
		Assert.assertEquals("40", redisTemplate.opsForValue().get("蜘蛛侠").getPassword());
	}
	
	//获取对象
	@Test
	public void testGetObj() throws Exception {
		User u1 = redisTemplate.opsForValue().get("超人");
		User u2 = redisTemplate.opsForValue().get("蝙蝠侠");
		User u3 = redisTemplate.opsForValue().get("蜘蛛侠");
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		
		Assert.assertEquals("20", u1.getPassword());
		Assert.assertEquals("30", u2.getPassword());
		Assert.assertEquals("40", u3.getPassword());
		}

}