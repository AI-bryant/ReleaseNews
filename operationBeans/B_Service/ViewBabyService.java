package B_Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import commons.modelFactory.ModelFactory;
import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;
import C_Model.IViewBabyInfoDao;
import C_Model.IViewNewsDao;

public class ViewBabyService {
	IViewBabyInfoDao viewBabyDao = null;
	public ViewBabyService(){
		viewBabyDao = ModelFactory.getViewBabyInfoDaoImplInstance();
	}
	
	public List<BabyInfo> getBabyList(){
		List<BabyInfo> babyInfoList = this.viewBabyDao.doFindAllBabyInfo();
		return babyInfoList;
	}
	
	public boolean doCreateBabyInfo(BabyInfo babyinfo){
		boolean flag = this.viewBabyDao.doCreateBabyInfo(babyinfo);
		//boolean flag=true;
		return flag;
	}
	
	public List<BabyMedical> getMedicalList(){
		List<BabyMedical> babyInfoList = this.viewBabyDao.doFindAllMedicalInfo();
		return babyInfoList;
	}
	
	public int getAverageFeed(String month){
		return this.viewBabyDao.doAverageFeed(month);
	}
}
