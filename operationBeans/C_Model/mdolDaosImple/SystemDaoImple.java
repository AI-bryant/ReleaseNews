package C_Model.mdolDaosImple;

import java.util.List;

import C_Model.ISystemDao;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.User;
import entity.entityDaos.newsDao.INewsDao;
import entity.entityDaos.remarkDao.IRemarkDao;
import entity.entityDaos.userDao.IUserDao;
import entity.entityDaosFactory.EntityDaoFactory;

public class SystemDaoImple implements ISystemDao{
	IUserDao userDao = null;
	INewsDao newsDao = null;
	IRemarkDao remarkDao = null;
	
	public SystemDaoImple(){
		userDao = EntityDaoFactory.getUserDaoImplInstance();
		newsDao = EntityDaoFactory.getNewsDaoImplInstance();
		remarkDao = EntityDaoFactory.getRemarkDaoImplInstance();
	}
	
	@Override
	public User doFindUserById(User user) {
		User tempUser = null;
		if(user.getUserId()==0){
			return tempUser;
		}
		try {
			tempUser = this.userDao.doFindUserById(user);
		} catch (Exception e) {
			System.err.println("查询指定用户出错，出错方法：SystemDaoImple.doFindUserById");
			e.printStackTrace();
		}
		return tempUser;
	}
	
	@Override
	public boolean doDeleteUserById(User user) {
		boolean flag = false;
		if(user.getUserId()==0){
			return flag;
		}
		try {
			flag = this.userDao.doDeleteUserById(user);
		} catch (Exception e) {
			System.err.println("管理删除用户信息出错，出错方法：SystemDaoImple.doDeleteUserById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<User> doFindAllUsers() {
		List<User> userList = null;
		try {
			userList = this.userDao.doFindAllUsers();
		} catch (Exception e) {
			System.err.println("管理查询全部用户出错，出错方法：SystemDaoImple.doFindAllUsers");
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean doUpdateNewsCountById(News news) {
		boolean flag = false;
		if(news.getNewsId()==0){
			return flag;
		}
		Remark tempRemark = new Remark();
		tempRemark.setNewsId(news.getNewsId());
		try {
			int remarkCount = this.remarkDao.doFindRemarkCountById(tempRemark);
			news.setRemarkCount(remarkCount);
			flag = this.newsDao.doUpdateNewsRemarkCountById(news);
		} catch (Exception e) {
			System.err.println("更新评论数量出错，出错方法：SystemDaoImple.doUpdateNewsCountById");
			e.printStackTrace();
		}
		return flag;
	}

}
