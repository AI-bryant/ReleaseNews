package C_Model;

import java.util.List;

import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;
import entity.entityBean.Column;
import entity.entityBean.News;
import entity.entityBean.Remark;
import entity.entityBean.Theme;
import entity.entityBean.User;

public interface IViewBabyInfoDao {
	
	/** 查询baby信息列表 */
	public List<BabyInfo> doFindAllBabyInfo();
	
	/** 添加Baby信息 */
	public boolean doCreateBabyInfo(BabyInfo babyinfo);
	
	/** 查询就医信息列表 */
	public List<BabyMedical> doFindAllMedicalInfo();
	
	public int doAverageFeed(String month);
}
