package C_Model;

import entity.entityBean.User;

public interface IRegLogDao {
	
	/**	用户使用：注册匹配用户名是否存在 */
	public boolean doFindUserByUserName(User user);
	
	/**	用户使用：注册创建新用户 */
	public boolean doCreateNewUser(User user);
	
	/**	用户使用：登录查询用户信息 */
	public User doFindUserByUserNameAndUserPass(User user);
	
	/**	用户使用：用户修改用户自己的信息 */
	public boolean doUpdateUserById(User user);
	
}
