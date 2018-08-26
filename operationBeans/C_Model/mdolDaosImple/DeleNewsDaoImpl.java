package C_Model.mdolDaosImple;

import java.util.List;

import C_Model.IDeleNewsDao;
import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
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

public class DeleNewsDaoImpl implements IDeleNewsDao{
	IColumnDao columnDao = null;
	IThemeDao themeDao = null;
	INewsDao newsDao = null;
	IRemarkDao remarkDao = null;
	IAboutusDao aboutusDao = null;
	IUserDao userDao = null;
	
	public DeleNewsDaoImpl(){
		this.columnDao = EntityDaoFactory.getColumnDaoImplInstance();
		this.themeDao = EntityDaoFactory.getThemeDaoImplInstance();
		this.newsDao = EntityDaoFactory.getNewsDaoImplInstance();
		this.remarkDao = EntityDaoFactory.getRemarkDaoImplInstance();
		this.aboutusDao = EntityDaoFactory.getAboutusDaoImplInstance();
		this.userDao = EntityDaoFactory.getUserDaoImplInstance();
	}
	
	@Override
	public boolean doDeleteColumnById(Column column) {
		boolean flag = false;
		if(column.getColumnId()==0){
			return flag;
		}
		try {
			Theme themeTemp = new Theme();
			themeTemp.setColumnId(column.getColumnId());
			List<Theme> themeList = this.themeDao.doFindAllThemeByColumnId(themeTemp);
			int countTheme = 0;
			boolean flagTheme = false;
			for(Theme theme : themeList){
				flagTheme = this.doDeleteThemeById(theme);
				if(flagTheme){
					countTheme++;
				}
				flagTheme = false;
			}
			if(themeList != null && themeList.size() == countTheme){
				flag = this.columnDao.doDeleteColumnById(column);
			}
		} catch (Exception e) {
			System.err.println("删除栏目出错，出错方法：doDeleteNewsDaoImpl.doDeleteColumnById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doDeleteThemeById(Theme theme) {
		boolean flag = false;
		if(theme.getThemeId()==0){
			return flag;
		}
		try {
			News tempNews = new News();
			tempNews.setThemeId(tempNews.getThemeId());
			List<News> newsList = this.newsDao.doFindAllNewsByThemeId(tempNews);
			int countNews = 0;
			boolean flagNews = false;
			for(News news : newsList){
				flagNews = this.doDeleteNewsById(news);
				if(flagNews){
					countNews++;
				}
				flagNews = false;
			}
			if(newsList != null && newsList.size() == countNews){
				flag = this.themeDao.doDeleteThemeById(theme);
			}
		} catch (Exception e) {
			System.err.println("删除主题出错，出错方法：doDeleteNewsDaoImpl.doDeleteThemeById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doDeleteNewsById(News news) {
		boolean flag = false;
		if(news.getNewsId()==0){
			return flag;
		}
		try {
			Theme tempTheme = new Theme();
			tempTheme.setNewsId(news.getNewsId());
			if(this.themeDao.doCreateNewTheme(tempTheme)){
				flag = this.newsDao.doDeleteNewsById(news);
			}
		} catch (Exception e) {
			System.err.println("删除主题出错，出错方法：doDeleteNewsDaoImpl.doDeleteNewsById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doDeleteRemarkById(Remark remark) {
		boolean flag = false;
		if(remark.getRemarkId()==0){
			return flag;
		}
		try {
			flag = this.remarkDao.doDeleteRemarkById(remark);
		} catch (Exception e) {
			System.err.println("删除主题出错，出错方法：doDeleteNewsDaoImpl.doDeleteRemarkById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doDeleteAboutUsById(AboutUs aboutUs) {
		boolean flag = false;
		if(aboutUs.getAboutusId()==0){
			return flag;
		}
		try {
			flag = this.aboutusDao.doDeleteAboutUsById(aboutUs);
		} catch (Exception e) {
			System.err.println("删除关于我们出错，出错方法：doDeleteNewsDaoImpl.doDeleteAboutUsById");
			e.printStackTrace();
		}
		return flag;
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
			System.err.println("删除用户出错，出错方法：doDeleteNewsDaoImpl.doDeleteUserById");
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo) {
		boolean flag = false;
		if(babyinfo.getBABY_INFO_ID()==0){
			return flag;
		}
		try {
			flag = this.userDao.doDeleteBabyInfoById(babyinfo);
		} catch (Exception e) {
			System.err.println("删除BabyInfo出错，出错方法：doDeleteNewsDaoImpl.doDeleteUserById");
			e.printStackTrace();
		}
		return flag;
	}
}
