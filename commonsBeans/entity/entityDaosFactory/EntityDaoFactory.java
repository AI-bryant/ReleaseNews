package entity.entityDaosFactory;

import entity.entityDaos.aboutusDao.IAboutusDao;
import entity.entityDaos.aboutusDao.aboutusDaoImpl.AboutusDaoImpl;
import entity.entityDaos.babyDao.BabyDao;
import entity.entityDaos.babyDao.babyDaoImpl.BabyDaoImpl;
import entity.entityDaos.columnDao.IColumnDao;
import entity.entityDaos.columnDao.columnDaoImpl.ColumnDaoImpl;
import entity.entityDaos.newsDao.INewsDao;
import entity.entityDaos.newsDao.newsDaoImpl.NewsDaoImpl;
import entity.entityDaos.remarkDao.IRemarkDao;
import entity.entityDaos.remarkDao.remarkDaoImpl.RemarkDaoImpl;
import entity.entityDaos.themeDao.IThemeDao;
import entity.entityDaos.themeDao.themeDaoImpl.ThemeDaoImpl;
import entity.entityDaos.userDao.IUserDao;
import entity.entityDaos.userDao.userDaoImpl.UserDaoImpl;


/** 数据操作层,创建的对象为实体类对应表的数据操作对象 */
public class EntityDaoFactory {
	private static IUserDao userDao = null;
	private static IThemeDao themeDao = null;
	private static IRemarkDao remarkDao = null;
	private static IColumnDao columnDao = null;
	private static INewsDao newsDao = null;
	private static IAboutusDao aboutusDao = null;
	private static BabyDao babyDao = null;
	
	/** 获取用户(BabyDao)的DAO层 */
	public static BabyDao getBabyDaoImplInstance(){
		if(babyDao == null){
			babyDao = new BabyDaoImpl();
		}
		return babyDao;
	}
	
	/** 获取用户(IUserDao)的DAO层 */
	public static IUserDao getUserDaoImplInstance(){
		if(userDao == null){
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
	
	/** 获取主题(IThemeDao)的DAO层 */
	public static IThemeDao getThemeDaoImplInstance(){
		if(themeDao == null){
			themeDao = new ThemeDaoImpl();
		}
		return themeDao;
	}
	
	/** 获取讨论(IRemarkDao)的DAO层 */
	public static IRemarkDao getRemarkDaoImplInstance(){
		if(remarkDao == null){
			remarkDao = new RemarkDaoImpl();
		}
		return remarkDao;
	}
	
	/** 获取栏目(IColumnDao)的DAO层 */
	public static IColumnDao getColumnDaoImplInstance(){
		if(columnDao == null){
			columnDao = new ColumnDaoImpl();
		}
		return columnDao;
	}
	
	/** 获取新闻(IColumnDao)的DAO层 */
	public static INewsDao getNewsDaoImplInstance(){
		if(newsDao == null){
			newsDao = new NewsDaoImpl();
		}
		return newsDao;
	}
	
	/** 获取用户(IAboutusDao)的DAO层 */
	public static IAboutusDao getAboutusDaoImplInstance(){
		if(aboutusDao == null){
			aboutusDao = new AboutusDaoImpl();
		}
		return aboutusDao;
	}
}
