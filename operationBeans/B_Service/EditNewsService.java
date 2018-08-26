package B_Service;

import C_Model.IEditNewsDao;
import commons.modelFactory.ModelFactory;
import entity.entityBean.AboutUs;
import entity.entityBean.News;
import entity.entityBean.Remark;

public class EditNewsService {
	IEditNewsDao editDao = null;
	public EditNewsService(){
		editDao = ModelFactory.getEditNewsDaoImplInstance();
	}
	
	public boolean doCreateNewsByColumnId(News news){
		boolean flag = this.editDao.doCreateNewsByColumnId(news);
		return flag;
	}
	
	public boolean doCreateAboutUs(AboutUs aboutUs){
		boolean flag = this.editDao.doCreateAboutUs(aboutUs);
		return flag;
	}
	
	public boolean doCreateRmearkByNewsId(Remark remark){
		boolean flag = this.editDao.doCreateRemarkByNewsId(remark);
		return flag;
	}
	
	public boolean doReleaseNewsById(News news){
		boolean flag = this.editDao.doUpdateNewStatusById(news);
		return flag;
	}
}
