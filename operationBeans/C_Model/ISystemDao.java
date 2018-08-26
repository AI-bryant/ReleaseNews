package C_Model;

import java.util.List;

import entity.entityBean.News;
import entity.entityBean.User;

public interface ISystemDao {
	
	/**	系统内部：查询单个用户信息 */
	public User doFindUserById(User user);
	
	/**	管理使用：删除用户信息 */
	public boolean doDeleteUserById(User user);
	
	/**	管理使用：查询论坛全部用户 */
	public List<User> doFindAllUsers();
	
	/**	系统使用：修改新闻的总论坛数量 */
	public boolean doUpdateNewsCountById(News news);
	
	
}
