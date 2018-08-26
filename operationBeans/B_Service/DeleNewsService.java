package B_Service;

import C_Model.IDeleNewsDao;
import commons.modelFactory.ModelFactory;
import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;


public class DeleNewsService {
	IDeleNewsDao deleteDao = null;
	public DeleNewsService(){
		deleteDao = ModelFactory.getDeleNewsDaoImplInstance();
	}
	
	public boolean deleteColumnById(Column column){
		boolean flag = this.deleteDao.doDeleteColumnById(column);
		return flag;
	}
	
	public boolean deleteThemeById(Theme theme){
		boolean flag = this.deleteDao.doDeleteThemeById(theme);
		return flag;
	}
	
	public boolean deleteNewsById(News news){
		boolean flag = this.deleteDao.doDeleteNewsById(news);
		return flag;
	}
	
	public boolean deleteRemarkById(Remark remark){
		boolean flag = this.deleteDao.doDeleteRemarkById(remark);
		return flag;
	}
	
	public boolean deleteAboutUsById(AboutUs aboutUs){
		boolean flag = this.deleteDao.doDeleteAboutUsById(aboutUs);
		return flag;
	}
	
	public boolean deleteUserById(User user){
		boolean flag = this.deleteDao.doDeleteUserById(user);
		return flag;
	}
	
	public boolean deleteBabyInfoById(BabyInfo babyInfo){
		boolean flag = this.deleteDao.doDeleteBabyInfoById(babyInfo);
		return flag;
	}
}
