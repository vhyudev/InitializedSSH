package com.lxtech.ssh.service.impl;


import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxtech.ssh.dao.AssociatorDao;
import com.lxtech.ssh.dao.GenderDao;
import com.lxtech.ssh.dao.ManagerDao;
import com.lxtech.ssh.dao.UserDao;
import com.lxtech.ssh.entity.Gender;
import com.lxtech.ssh.entity.Manager;
import com.lxtech.ssh.entity.User;
import com.lxtech.ssh.service.AssociatorService;
import com.lxtech.ssh.service.ManagerService;
import com.lxtech.ssh.service.UserService;
import com.lxtech.ssh.util.Encrypt;
import com.lxtech.ssh.util.QueryResult;
import com.lxtech.ssh.vo.MessegeDto;
import com.lxtech.ssh.vo.RegistDto;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<Long, User> implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GenderDao genderDao;
	
	@Autowired
	private AssociatorService associatorService;
	
	@Autowired
	private ManagerService managerService;
	
	public MessegeDto regist(RegistDto registDto){
		User user = new User();
		MessegeDto md = new MessegeDto();
		Manager associator = new Manager();
		//String id = UUID.randomUUID().toString().replaceAll("-", "");
		user.setSign(0);//0代表管理员 ，1代表会员
		user.setMobile(registDto.getMobile());
		user.setUsername(registDto.getUserName());
		user.setPassword(Encrypt.md5(registDto.getPassword(), registDto.getUserName()));
		try{
			Gender gender = genderDao.findById(Long.parseLong(registDto.getSex()));//30男，33女
			associator.setGender(gender);
			associator.setIdCardNo(registDto.getIdCardNo());
			associator.setUser(user);
			//user.setManager(associator);
			managerService.save(associator);
			md.setStatus("0");//成功
			md.setMessage("注册成功！");
		}catch(Exception e){
			md.setStatus("1");//失败
			md.setMessage("注册信息保存异常！");
			return md;
		}
		
		
		
		return md;
	}
	/**
	 * 管理员用户名查重
	 * sign 0 代表 管理员 1代表会员
	 * @param userName
	 * @return
	 */
	public boolean checkUser(String userName,int sign){
		QueryResult<User> qr = userDao.findByUserName(userName,sign);
		if(qr.getTotalCount() == 0){
			return true;
		}
		return false;
	}

}
