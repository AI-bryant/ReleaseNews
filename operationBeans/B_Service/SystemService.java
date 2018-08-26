package B_Service;

import java.util.List;

import commons.modelFactory.ModelFactory;

import entity.entityBean.User;
import C_Model.ISystemDao;

public class SystemService {
	ISystemDao systemDao = null;
	public SystemService(){
		systemDao = ModelFactory.getSystemDaoImplInstance();
	}
	
	public User getUserById(User user){
		User tempUser = null;
		tempUser = this.systemDao.doFindUserById(user);
		return tempUser;
	}
	
	public List<User> getListUsers(){
		List<User> userList = null;
		userList = this.systemDao.doFindAllUsers();
		return userList;
	}
	
	public boolean deleteUser(User user){
		boolean flag = false;
		flag = this.systemDao.doDeleteUserById(user);
		return flag;
	}
}
