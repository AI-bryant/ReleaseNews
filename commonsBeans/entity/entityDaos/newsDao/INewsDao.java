package entity.entityDaos.newsDao;

import java.util.List;

import entity.entityBean.News;

public interface INewsDao {
	/**	创建新闻*/
	public boolean doCreateNewNews(News news) throws Exception;
	
	/**	根据newsId删除新闻*/
	public boolean doDeleteNewsById(News news) throws Exception;
	
	/**	根据newsId更新新闻的发布内容 */
	public boolean doUpdateNewsReleaseById(News news) throws Exception;
	
	/**	根据newsId更新新闻的退回内容 */
	public boolean doUpdateNewsReturnById(News news) throws Exception;
	
	/**	根据newsId查询新闻*/
	public News doFindNewsById(News news) throws Exception;
	
	/** 根据newsId查询新闻的评论数量 */
	public Integer doFindNewsRemarkCountById(News news) throws Exception;
	
	/** 根据newsId更新新闻的评论数量 */
	public boolean doUpdateNewsRemarkCountById(News news) throws Exception;
	
	/** 根据themeId查询主题内的全部新闻 */
	public List<News> doFindAllNewsByThemeId(News news) throws Exception;
	
	/** 根据columnId查询栏目内的全部新闻 */
	public List<News> doFindAllNewsByColumnId(News news) throws Exception;
	
	/** 根据发布和未发布状态查询全部新闻 */
	public List<News> doFindAllNewsByStatus(News news) throws Exception;
	
	/**	根据newsId发布新闻 */
	public boolean doUpdateNewStatusById(News news) throws Exception;
	
	/**	查询论坛新闻数量 */
	public int doCountNews() throws Exception;
}
