package C_Model.mdolDaosImple;

import java.util.List;

import entity.entityBean.AboutUs;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;
import entity.entityDaos.aboutusDao.IAboutusDao;
import entity.entityDaos.columnDao.IColumnDao;
import entity.entityDaos.newsDao.INewsDao;
import entity.entityDaos.remarkDao.IRemarkDao;
import entity.entityDaos.themeDao.IThemeDao;
import entity.entityDaos.userDao.IUserDao;
import entity.entityDaosFactory.EntityDaoFactory;
import C_Model.IViewNewsDao;

public class ViewNewsDaoImpl implements IViewNewsDao{
	IColumnDao columnDao = null;
	IThemeDao themeDao = null;
	INewsDao newsDao = null;
	IRemarkDao remarkDao = null;
	IUserDao userDao = null;
	IAboutusDao aboutusDao = null;
	
	public ViewNewsDaoImpl(){
		this.columnDao= EntityDaoFactory.getColumnDaoImplInstance();
		this.themeDao = EntityDaoFactory.getThemeDaoImplInstance();
		this.newsDao = EntityDaoFactory.getNewsDaoImplInstance();
		this.remarkDao = EntityDaoFactory.getRemarkDaoImplInstance();
		this.userDao = EntityDaoFactory.getUserDaoImplInstance();
		this.aboutusDao = EntityDaoFactory.getAboutusDaoImplInstance();
	}
	
	@Override
	public List<Column> doFindAllColumn() {
		List<Column> columnList = null;
		try {
			columnList = this.columnDao.doFindAllColumn();
		} catch (Exception e) {
			System.err.println("查询显示所有栏目出错，出错方法：ViewNewsDaoImpl.doFindAllColumn");
			e.printStackTrace();
		}
		return columnList;
	}

	@Override
	public List<Theme> doFindAllThemeByColumnId(Theme theme) {
		List<Theme> themeList = null;
		if(theme.getColumnId()==0){
			return themeList;
		}
		try {
			themeList = this.themeDao.doFindAllThemeByColumnId(theme);
		} catch (Exception e) {
			System.err.println("查询显示所有主题出错，出错方法：ViewNewsDaoImpl.doFindAllThemeByColumnId");
			e.printStackTrace();
		}
		return themeList;
	}

	@Override
	public List<News> doFindAllNewsByThemeId(News news) {
		List<News> newsList = null;
		if(news.getThemeId()==0){
			return newsList;
		}
		try {
			newsList = this.newsDao.doFindAllNewsByThemeId(news);
		} catch (Exception e) {
			System.err.println("查询显示所有新闻出错，出错方法：ViewNewsDaoImpl.doFindAllNewsByThemeId");
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public News doFindNewsById(News news) {
		News tempNews = null;
		if(news.getNewsId()==0){
			return tempNews;
		}
		try {
			tempNews = this.newsDao.doFindNewsById(news);
			if(tempNews.getNewsContext()!=null){
				String newContext = tempNews.getNewsContext().replaceAll("\r\n", "<br>");
				tempNews.setNewsContext(newContext);
			}
			
		} catch (Exception e) {
			System.err.println("查询显示指定新闻出错，出错方法：ViewNewsDaoImpl.doFindNewsById");
			e.printStackTrace();
		}
		return tempNews;
	}

	@Override
	public List<Remark> doFindAllRemarkByNewsId(Remark remark) {
		List<Remark> remarkList = null;
		if(remark.getNewsId()==0){
			return remarkList;
		}
		try {
			remarkList = this.remarkDao.doFindAllRemarkByNewsId(remark);
			User userTemp = null;
			for(Remark remarkTemp:remarkList){
				userTemp = new User();
				userTemp.setUserId(remarkTemp.getUserId());
				remarkTemp.setUser(this.userDao.doFindUserById(userTemp));
			}
		} catch (Exception e) {
			System.err.println("查询显示所有讨论出错，出错方法：ViewNewsDaoImpl.doFindAllRemarkByNewsId");
			e.printStackTrace();
		}
		return remarkList;
	}

	@Override
	public List<News> doFindAllNewsByColumnId(News news) {
		List<News> newsList = null;
		if(news.getColumnId()==0){
			return newsList;
		}
		try {
			newsList = this.newsDao.doFindAllNewsByColumnId(news);
		} catch (Exception e) {
			System.err.println("查询显示所有新闻出错，出错方法：ViewNewsDaoImpl.doFindAllNewsByColumnId");
			e.printStackTrace();
		}
		return newsList;
	}
	
	@Override
	public Column doFindColumnById(Column column){
		Column tempColumn = null;
		try {
			tempColumn = this.columnDao.doFindColumnById(column);
		} catch (Exception e) {
			System.err.println("查询栏目出错，出错方法：ViewNewsDaoImpl.doFindAllNewsByColumnId");
			e.printStackTrace();
		}
		return tempColumn;
	}

	@Override
	public List<News> doFindAllNewsByStatus(News news){
		List<News> newsList = null;
		try {
			newsList = this.newsDao.doFindAllNewsByStatus(news);
		} catch (Exception e) {
			System.err.println("查询显示所有新闻出错，出错方法：ViewNewsDaoImpl.doFindAllNewsByStatus");
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public List<User> doFindAllUsers() {
		List<User> userList = null;
		try {
			userList = this.userDao.doFindAllUsers();
		} catch (Exception e) {
			System.err.println("查询显示所有用户出错，出错方法：ViewNewsDaoImpl.doFindAllUsers");
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<Remark> doFindAllRemark() {
		List<Remark> remarkList = null;
		try {
			remarkList = this.remarkDao.doFindAllRemark();
		} catch (Exception e) {
			System.err.println("查询显示所有用户出错，出错方法：ViewNewsDaoImpl.doFindAllRemark");
			e.printStackTrace();
		}
		return remarkList;
	}

	@Override
	public int doCountUser() {
		int countUser = 0;
		try {
			countUser = this.userDao.doCountUser();
		} catch (Exception e) {
			System.err.println("查询显示统计用户数量出错，出错方法：ViewNewsDaoImpl.doCountUser");
			e.printStackTrace();
		}
		return countUser;
	}

	@Override
	public List<AboutUs> doFindAllAboutUs() {
		List<AboutUs> aboutusList = null;
		try {
			aboutusList = this.aboutusDao.doFindAllAboutUs();
		} catch (Exception e) {
			System.err.println("查询显示所有关于我们出错，出错方法：ViewNewsDaoImpl.doFindAllAboutUs");
			e.printStackTrace();
		}
		return aboutusList;
	}

	@Override
	public int doCountNews() {
		int countNews = 0;
		try {
			countNews = this.newsDao.doCountNews();
		} catch (Exception e) {
			System.err.println("查询显示统计新闻数量出错，出错方法：ViewNewsDaoImpl.doCountNews");
			e.printStackTrace();
		}
		return countNews;
	}

	@Override
	public int doCountRemark() {
		int countRemark = 0;
		try {
			countRemark = this.remarkDao.doCountRemark();
		} catch (Exception e) {
			System.err.println("查询显示统计新闻回复数量出错，出错方法：ViewNewsDaoImpl.doCountRemark");
			e.printStackTrace();
		}
		return countRemark;
	}

	@Override
	public int doCountAboutUs() {
		int countAboutUs = 0;
		try {
			countAboutUs = this.aboutusDao.doCountAboutUs();
		} catch (Exception e) {
			System.err.println("查询显示统计关于我们留言数量出错，出错方法：ViewNewsDaoImpl.doCountAboutUs");
			e.printStackTrace();
		}
		return countAboutUs;
	}
}
