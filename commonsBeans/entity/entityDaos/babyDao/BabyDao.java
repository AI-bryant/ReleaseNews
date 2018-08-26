package entity.entityDaos.babyDao;

import java.util.List;

import entity.entityBean.AboutUs;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;

public interface BabyDao {
	/**	创建babyInfo的信息 */
	public boolean doCreateBabyInfo(BabyInfo babyinfo) throws Exception;
	
	/**	根据aboutusId删除关于我们的信息 */
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo) throws Exception;
	
	/** 查询全部宝宝基础信息 */
	public List<BabyInfo> doFindAllBabyInfo() throws Exception;
	
	/**	查询全部宝宝就医信息 */
	public List<BabyMedical> doFindAllBabyMedical() throws Exception;
	
	/**	查询宝宝平均食量 */
	public int doAverageFeed(String month) throws Exception;
}
