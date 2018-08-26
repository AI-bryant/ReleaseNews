package C_Model;

import entity.entityBean.AboutUs;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;

public interface IEditNewsDao {
	
	/** 管理使用：创建栏目 */
	public boolean doCreateColumn(Column column);
	
	/** 管理使用：创建栏目关联的主题 */
	public boolean doCreateThemeByColumnId(Theme theme);
	
	/** 管理使用：创建主题关联的新闻 */
	public boolean doCreateNewsByThemeId(News news);
	
	/** 管理使用：创建主题关联的新闻 */
	public boolean doCreateNewsByColumnId(News news);
	
	/** 用户使用：创建新闻关联的评论 */
	public boolean doCreateRemarkByNewsId(Remark remark);
	
	/** 管理使用：修改栏目 */
	public boolean doUpdateColumnTitleById(Column column);
	
	/** 管理使用：修改主题 */
	public boolean doUpdateThemeTitleById(Theme theme);
	
	/** 管理使用：修改新闻内容 */
	public boolean doUpdateNewsReleaseById(News news);
	
	/** 管理使用：修改新闻退回内容 */
	public boolean doUpdateNewsReturnById(News news);
	
	/**	创建关于我们的信息 */
	public boolean doCreateAboutUs(AboutUs aboutUs);
	
	/**	根据newsId发布新闻 */
	public boolean doUpdateNewStatusById(News news);
}
