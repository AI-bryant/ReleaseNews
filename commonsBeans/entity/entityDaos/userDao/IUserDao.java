package entity.entityDaos.userDao;

import java.util.List;

import entity.entityBean.BabyInfo;
import entity.entityBean.User;

public interface IUserDao {
	
	/**	创建新闻用户 */
	public boolean doCreateNewUser(User user) throws Exception;
	
	/**	根据userId删除用户 */
	public boolean doDeleteUserById(User user) throws Exception;
	
	/**	根据BabyInfoId删除信息 */
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo) throws Exception;
	
	/**	根据userId修改用户 */
	public boolean doUpdateUserById(User user) throws Exception;
	
	/**	根据userId查询用户 */
	public User doFindUserById(User user) throws Exception;
	
	/**	根据userName查询用户 */
	public boolean doFindUserByUserName(User user) throws Exception;
	
	/**	根据userName和userPass查询用户 */
	public User doFindUserByUserNameAndUserPass(User user) throws Exception;
	
	/**	查询论坛全部用户 */
	public List<User> doFindAllUsers() throws Exception;
	
	/**	查询论坛用户数量 */
	public int doCountUser() throws Exception;
}
