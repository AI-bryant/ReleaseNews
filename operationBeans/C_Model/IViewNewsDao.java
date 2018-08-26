package C_Model;

import java.util.List;

import entity.entityBean.AboutUs;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;

public interface IViewNewsDao {
	
	/** 用户使用：获取全部栏目,用于显示导航栏 */
	public List<Column> doFindAllColumn();
	
	/** 用户使用：根据栏目Id获取全部主题,用于显示主题块 */
	public List<Theme> doFindAllThemeByColumnId(Theme theme);
	
	/** 用户使用：根据主题Id获取全部新闻,用于显示主题块下的全部新闻 */
	public List<News> doFindAllNewsByThemeId(News news);
	
	/** 用户使用：根据栏目Id获取全部新闻,用于显示栏目块下的全部新闻 */
	public List<News> doFindAllNewsByColumnId(News news);
	
	/** 用户使用：根据栏目Id获取栏目信息 */
	public Column doFindColumnById(Column column);
	
	/** 用户使用：根据新闻Id获取一条新闻的内容 */
	public News doFindNewsById(News news);
	
	/** 用户使用：根据新闻Id获取一条新闻的所有留言讨论 */
	public List<Remark> doFindAllRemarkByNewsId(Remark remark);
	
	/** 根据发布和未发布状态查询全部新闻 */
	public List<News> doFindAllNewsByStatus(News news);
	
	/**	查询论坛全部用户 */
	public List<User> doFindAllUsers();
	
	/** 查询所有留言信息 */
	public List<Remark> doFindAllRemark();
	
	/**	查询论坛用户数量 */
	public int doCountUser();
	
	/**	查询论坛新闻数量 */
	public int doCountNews();
	
	/**	查询论坛留言数量 */
	public int doCountRemark();
	
	/**	查询论坛关于我们信息数量 */
	public int doCountAboutUs();
	
	/** 查询全部关于我们的信息 */
	public List<AboutUs> doFindAllAboutUs();
}
