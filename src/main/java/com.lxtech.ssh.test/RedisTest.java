package com.lxtech.ssh.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lxtech.ssh.redis.JedisClient;

import redis.clients.jedis.Jedis;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
	@Autowired
	private JedisClient jds;
	@Test
	public void function(){
		Jedis jedis = new Jedis("192.168.206.128", 6379);
		String result = jedis.get("ss");
		System.out.println(result);
		jedis.close();
	}
	@Test
	public void function2(){
		
		jds.set("first1", "102");
		String result = jds.get("first1");
		System.out.println(result);
	}
			public static void main(String[] args) {
				Jedis jedis = new Jedis("192.168.206.128", 6379);
				jedis.auth("123456");
				String result = jedis.get("ss");
				System.out.println(result);
				jedis.close();
			}
}
