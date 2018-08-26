package C_Model.mdolDaosImple;

import entity.entityBean.User;
import entity.entityDaos.userDao.IUserDao;
import entity.entityDaosFactory.EntityDaoFactory;
import C_Model.IRegLogDao;

public class RegLogDaoImpl implements IRegLogDao{
	IUserDao userDao = null;
	
	public RegLogDaoImpl(){
		userDao = EntityDaoFactory.getUserDaoImplInstance();
	}
	
	@Override
	public boolean doFindUserByUserName(User user) {
		boolean flag = false;
		try {
			flag = this.userDao.doFindUserByUserName(user);
		} catch (Exception e) {
			System.err.println("用户注册出错，出错方法：RegLogDaoImpl.doFindUserByUserName");
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean doCreateNewUser(User user) {
		boolean flag = false;
		try {
			flag = this.userDao.doCreateNewUser(user);
		} catch (Exception e) {
			System.err.println("用户注册出错，出错方法：RegLogDaoImpl.doCreateNewUser");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User doFindUserByUserNameAndUserPass(User user) {
		User tempUser = null;
		try {
			tempUser = this.userDao.doFindUserByUserNameAndUserPass(user);
		} catch (Exception e) {
			System.err.println("用户登录出错，出错方法：RegLogDaoImpl.doFindUserByUserNameAndUserPass");
			e.printStackTrace();
		}
		return tempUser;
	}

	@Override
	public boolean doUpdateUserById(User user) {
		boolean flag = false;
		try {
			flag = this.userDao.doUpdateUserById(user);
		} catch (Exception e) {
			System.err.println("用户信息修改出错，出错方法：RegLogDaoImpl.doUpdateUserById");
			e.printStackTrace();
		}
		return flag;
	}

}
