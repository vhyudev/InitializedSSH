package com.lxtech.ssh.test;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ActiveMQTest {
	@Autowired
	private JmsTemplate jt;
	@Test
	public void test1() {
	
        
       jt.send(new MessageCreator() {  
            // 消息的产生，返回消息发送消息  
            public Message createMessage(Session s) throws JMSException {  
                TextMessage msg = s  
                        .createTextMessage("这是mq");  
                return msg;  
            }  
        });  
		
	}
	
	
}
