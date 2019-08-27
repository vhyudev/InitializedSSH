package com.lxtech.ssh.sms;

import java.net.URLEncoder;
import java.util.Random;



/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	
	private static String smsContent = "【国本善美】尊敬的国本善美用户，您的验证码为{";

	/**
	 * 验证码通知短信
	 */
	public static void execute(String to,String checkcode)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent+checkcode+"}", "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int nextInt = random.nextInt(9000);
		int a = nextInt+1000;
		System.out.println(a);
		execute("13012008589",a+"");
	}
}
