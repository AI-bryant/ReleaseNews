package C_Model.mdolDaosImple;

import entity.entityBean.AboutUs;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityDaos.aboutusDao.IAboutusDao;
import entity.entityDaos.columnDao.IColumnDao;
import entity.entityDaos.newsDao.INewsDao;
import entity.entityDaos.remarkDao.IRemarkDao;
import entity.entityDaos.themeDao.IThemeDao;
import entity.entityDaosFactory.EntityDaoFactory;
import C_Model.IEditNewsDao;

public class EditNewsDaoImpl implements IEditNewsDao{
	IColumnDao columnDao = null;
	IThemeDao themeDao = null;
	INewsDao newsDao = null;
	IRemarkDao remarkDao = null;
	IAboutusDao aboutusDao = null;
	
	public EditNewsDaoImpl(){
		columnDao = EntityDaoFactory.getColumnDaoImplInstance();
		themeDao = EntityDaoFactory.getThemeDaoImplInstance();
		newsDao = EntityDaoFactory.getNewsDaoImplInstance();
		remarkDao = EntityDaoFactory.getRemarkDaoImplInstance();
		aboutusDao = EntityDaoFactory.getAboutusDaoImplInstance();
	}
	
	@Override
	public boolean doCreateColumn(Column column) {
		boolean flag = false;
		try {
			flag = this.columnDao.doCreateNewColumn(column);
		} catch (Exception e) {
			System.err.println("创建栏目出错，出错方法：EditNewsDaoImpl.doCreateColumn");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doCreateThemeByColumnId(Theme theme) {
		boolean flag = false;
		if(theme.getColumnId()==0){
			return flag;
		}
		try {
			flag = this.themeDao.doCreateNewTheme(theme);
		} catch (Exception e) {
			System.err.println("创建主题出错，出错方法：EditNewsDaoImpl.doCreateThemeByColumnId");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doCreateNewsByThemeId(News news) {
		boolean flag = false;
		if(news.getThemeId()==0){
			return flag;
		}
		try {
			flag = this.newsDao.doCreateNewNews(news);
		} catch (Exception e) {
			System.err.println("创建新闻出错，出错方法：EditNewsDaoImpl.doCreateNewsByThemeId");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doCreateRemarkByNewsId(Remark remark) {
		boolean flag = false;
		if(remark.getNewsId()==0){
			return flag;
		}
		try {
			flag = this.remarkDao.doCreateRemark(remark);
		} catch (Exception e) {
			System.err.println("创建评论出错，出错方法：EditNewsDaoImpl.doCreateRemarkByNewsId");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateColumnTitleById(Column column) {
		boolean flag = false;
		if(column.getColumnId()==0){
			return flag;
		}
		try {
			flag = this.columnDao.doUpdateColumnTitleById(column);
		} catch (Exception e) {
			System.err.println("修改栏目出错，出错方法：EditNewsDaoImpl.doUpdateColumnTitleById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateThemeTitleById(Theme theme) {
		boolean flag = false;
		if(theme.getThemeId()==0){
			return flag;
		}
		try {
			flag = this.themeDao.doUpdateThemeTitleById(theme);
		} catch (Exception e) {
			System.err.println("修改主题出错，出错方法：EditNewsDaoImpl.doUpdateThemeTitleById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateNewsReleaseById(News news) {
		boolean flag = false;
		if(news.getNewsId()==0){
			return flag;
		}
		try {
			flag = this.newsDao.doUpdateNewsReleaseById(news);
		} catch (Exception e) {
			System.err.println("修改新闻出错，出错方法：SystemDaoImple.doUpdateNewsReleaseById");
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean doUpdateNewsReturnById(News news) {
		boolean flag = false;
		if(news.getNewsId()==0){
			return flag;
		}
		try {
			flag = this.newsDao.doUpdateNewsReturnById(news);
		} catch (Exception e) {
			System.err.println("修改审核退回新闻提示出错，出错方法：SystemDaoImple.doUpdateNewsReturnById");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doCreateNewsByColumnId(News news) {
		boolean flag = false;
		if(news.getColumnId()==0){
			return flag;
		}
		try {
			flag = this.newsDao.doCreateNewNews(news);
		} catch (Exception e) {
			System.err.println("创建新闻出错，出错方法：EditNewsDaoImpl.doCreateNewsByColumnId");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doCreateAboutUs(AboutUs aboutUs) {
		boolean flag = false;
		try {
			flag = this.aboutusDao.doCreateAboutUs(aboutUs);
		} catch (Exception e) {
			System.err.println("创建关于我们出错，出错方法：EditNewsDaoImpl.doCreateAboutUs");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdateNewStatusById(News news) {
		boolean flag = false;
		try {
			flag = this.newsDao.doUpdateNewStatusById(news);
		} catch (Exception e) {
			System.err.println("发布新闻出错，出错方法：EditNewsDaoImpl.doUpdateNewStatusById");
			e.printStackTrace();
		}
		return flag;
	}
}
