package com.lxtech.ssh.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MqMessageListener implements MessageListener  {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			TextMessage textMessage = (TextMessage) message;
			//取消息内容
			String text = textMessage.getText();
			System.out.println("这是订阅到的mq信息:"+text);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}

}
