package entity.entityDaos.aboutusDao;

import java.util.List;

import entity.entityBean.AboutUs;

public interface IAboutusDao {
	/**	创建关于我们的信息 */
	public boolean doCreateAboutUs(AboutUs aboutUs) throws Exception;
	
	/**	根据aboutusId删除关于我们的信息 */
	public boolean doDeleteAboutUsById(AboutUs aboutUs) throws Exception;
	
	/** 查询全部关于我们的信息 */
	public List<AboutUs> doFindAllAboutUs() throws Exception;
	
	/**	查询论坛关于我们信息数量 */
	public int doCountAboutUs() throws Exception;
}
