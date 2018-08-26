package C_Model;

import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;

public interface IDeleNewsDao {
	
	/** 管理使用：根据栏目columnId删除栏目及栏目下的所有主题、新闻、评论 */
	public boolean doDeleteColumnById(Column column);
	
	/** 管理使用：根据主题themeId删除主题及主题下的所有新闻、评论 */
	public boolean doDeleteThemeById(Theme theme);
	
	/** 管理使用：根据新闻newsId删除新闻及新闻下的所有评论 */
	public boolean doDeleteNewsById(News news);
	
	/** 用户和管理使用：根据新闻ramarkId删除评论 */
	public boolean doDeleteRemarkById(Remark remark);
	
	/**	根据aboutusId删除关于我们的信息 */
	public boolean doDeleteAboutUsById(AboutUs aboutUs);
	
	/**	根据userId删除用户 */
	public boolean doDeleteUserById(User user);
	
	/**	根据babyInfoId删除用户 */
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo);
}
