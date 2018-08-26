package B_Service;

import java.util.List;

import commons.modelFactory.ModelFactory;
import entity.entityBean.AboutUs;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;
import C_Model.IViewNewsDao;

public class ViewNewsService {
	IViewNewsDao viewNewsDao = null;
	public ViewNewsService(){
		viewNewsDao = ModelFactory.getViewNewsDaoImplInstance();
	}
	
	public List<Remark> getListRemarkByNewsId(Remark remark){
		List<Remark> remarkList = this.viewNewsDao.doFindAllRemarkByNewsId(remark);
		return remarkList;
	}
	
	public List<News> getListNewsByThemeId(News news){
		List<News> newsList = this.viewNewsDao.doFindAllNewsByThemeId(news);
		return newsList;
	}
	
	public List<Theme> getListThemeByColumnId(Theme theme){
		List<Theme> themeList = this.viewNewsDao.doFindAllThemeByColumnId(theme);
		return themeList;
	}
	
	public List<Column> getListColumn(){
		List<Column> columnList = this.viewNewsDao.doFindAllColumn();
		return columnList;
	}
	
	/** 单条新闻及评论
	 * 根据新闻newsId查询该新闻的信息，包括该新闻的全部评论内容
	 * @param news对象，必须包含newsId
	 * @return 查询到的news对象，包含的评论Remark的集合
	 */
	public News getNewsByContainListRemarkNewsId(News news){
		News tempNews = this.viewNewsDao.doFindNewsById(news);
		List<Remark> remarkList = null;
		if(tempNews != null){
			Remark tempRemark = new Remark();
			tempRemark.setNewsId(news.getNewsId());
			remarkList = this.viewNewsDao.doFindAllRemarkByNewsId(tempRemark);
		}
		tempNews.setRemarkList(remarkList);
		return tempNews;
	}
	
	/** 多个主题及对应的多条新闻
	 * 根据栏目ColumnId查询该新闻的主题，包括该主题下的全部新闻信息
	 * @param theme对象，必须包含ColumnId
	 * @return 主题集合themeList对象，包含该主题的新闻News的集合
	 */
	public List<Theme> getListThemeContainListNewsIdByColumnId(Theme theme){
		List<Theme> themeList = null;
		List<News> newsList = null;
		themeList = this.viewNewsDao.doFindAllThemeByColumnId(theme);
		
		News newsObj = null;
		for(Theme themeObj : themeList){
			newsObj = new News();
			newsObj.setColumnId(themeObj.getColumnId());
			newsList = this.viewNewsDao.doFindAllNewsByThemeId(newsObj);
			themeObj.setNewsList(newsList);
		}
		return themeList;
	}
	
	public Column getColumnContainListNewsIdByColumnId(News news){
		Column columnTemp = null;
		List<News> newsList = null;
		newsList = this.viewNewsDao.doFindAllNewsByColumnId(news);
		if(newsList != null && newsList.size() >= 0){
			columnTemp = new Column();
			columnTemp.setColumnId(news.getColumnId());
			columnTemp = this.viewNewsDao.doFindColumnById(columnTemp);
			columnTemp.setNewsList(newsList);
		}
		return columnTemp;
	}
	
	public List<News> getNewsListByStatus(News news){
		List<News> newsList = this.viewNewsDao.doFindAllNewsByStatus(news);
		return newsList;
	}
	
	public List<User> getListUser() {
		return this.viewNewsDao.doFindAllUsers();
	}
	
	public List<Remark> getListRemark() {
		return this.viewNewsDao.doFindAllRemark();
	}
	
	public int getCountUser(){
		return this.viewNewsDao.doCountUser();
	}
	
	public int getCountNews(){
		return this.viewNewsDao.doCountNews();
	}
	
	public int getCountRemark(){
		return this.viewNewsDao.doCountRemark();
	}
	
	public int getCountAboutUs(){
		return this.viewNewsDao.doCountAboutUs();
	}
	
	public List<AboutUs> getAboutUsList(){
		return this.viewNewsDao.doFindAllAboutUs();
	}
}
