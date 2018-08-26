package B_Service;

import commons.modelFactory.ModelFactory;

import entity.entityBean.User;
import C_Model.IRegLogDao;

public class RegLogService{
	IRegLogDao regLogDao = null;
	public RegLogService(){
		regLogDao = ModelFactory.getRegLogDaoImplInstance();
	}
	
	public boolean registerUser(User user){
		boolean flag = false;
		if(!this.regLogDao.doFindUserByUserName(user)){
			flag = this.regLogDao.doCreateNewUser(user);
		}
		return flag;
	}
	
	public boolean updateUser(User user){
		boolean flag = false;
		flag = this.regLogDao.doUpdateUserById(user);
		return flag;
	}
	
	public User loginUser(User user){
		User tempUser = null;
		tempUser = this.regLogDao.doFindUserByUserNameAndUserPass(user);
		return tempUser;
	}
	
}
