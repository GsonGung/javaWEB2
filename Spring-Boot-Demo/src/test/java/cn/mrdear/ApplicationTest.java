package cn.mrdear;

import cn.mrdear.entity.RedisUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<String, RedisUser> redisTemplate;
	
	// 保存字符串
	@Test
	public void testString() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
	
	//保存对象
	@Test
	public void testSetObj() throws Exception {
		RedisUser user = new RedisUser(1, "超人", "20");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new RedisUser(2, "蝙蝠侠", "30");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new RedisUser(3, "蜘蛛侠", "40");
		redisTemplate.opsForValue().set(user.getUsername(), user);
		Assert.assertEquals("20", redisTemplate.opsForValue().get("超人").getPassword());
		Assert.assertEquals("30", redisTemplate.opsForValue().get("蝙蝠侠").getPassword());
		Assert.assertEquals("40", redisTemplate.opsForValue().get("蜘蛛侠").getPassword());
	}
	
	//获取对象
	@Test
	public void testGetObj() throws Exception {
		RedisUser u1 = redisTemplate.opsForValue().get("超人");
		RedisUser u2 = redisTemplate.opsForValue().get("蝙蝠侠");
		RedisUser u3 = redisTemplate.opsForValue().get("蜘蛛侠");
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		
		Assert.assertEquals("20", u1.getPassword());
		Assert.assertEquals("30", u2.getPassword());
		Assert.assertEquals("40", u3.getPassword());
		}

}