package C_Model.mdolDaosImple;

import java.util.List;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;
import entity.entityDaos.babyDao.BabyDao;
import entity.entityDaosFactory.EntityDaoFactory;
import C_Model.IViewBabyInfoDao;

public class ViewBabyInfoDaoImpl implements IViewBabyInfoDao{
	BabyDao babyDao = null;
	
	public ViewBabyInfoDaoImpl(){
		this.babyDao = EntityDaoFactory.getBabyDaoImplInstance();
	}
	
	@Override
	public List<BabyInfo> doFindAllBabyInfo() {
		List<BabyInfo> babyInfoList = null;
		try {
			babyInfoList = this.babyDao.doFindAllBabyInfo();
		} catch (Exception e) {
			System.err.println("查询显示所有BabyInfo出错，出错方法：ViewNewsDaoImpl.doFindAllColumn");
			e.printStackTrace();
		}
		return babyInfoList;
	}
	
	public boolean doCreateBabyInfo(BabyInfo babyinfo){
		boolean flag = false;
		try {
			flag = this.babyDao.doCreateBabyInfo(babyinfo);
		} catch (Exception e) {
			System.err.println("创建BabyInfo失败，出错方法：EditNewsDaoImpl.doCreateNewsByThemeId");
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<BabyMedical> doFindAllMedicalInfo() {
		List<BabyMedical> babyMedicalList = null;
		try {
			babyMedicalList = this.babyDao.doFindAllBabyMedical();
		} catch (Exception e) {
			System.err.println("查询显示所有Baby就医状况出错，出错方法：ViewNewsDaoImpl.doFindAllColumn");
			e.printStackTrace();
		}
		return babyMedicalList;
	}
	
	@Override
	public int doAverageFeed(String month) {
		int averageFeed = 0;
		try {
			averageFeed = this.babyDao.doAverageFeed(month);
		} catch (Exception e) {
			System.err.println("查询显示统计关于我们留言数量出错，出错方法：ViewNewsDaoImpl.doCountAboutUs");
			e.printStackTrace();
		}
		return averageFeed;
	}
}