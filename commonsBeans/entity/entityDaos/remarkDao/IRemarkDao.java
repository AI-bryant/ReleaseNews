package entity.entityDaos.remarkDao;

import java.util.List;

import entity.entityBean.Remark;


public interface IRemarkDao {
	/**	创建新闻讨论 */
	public boolean doCreateRemark(Remark remark) throws Exception;
	
	/**	根据remarkId删除讨论*/
	public boolean doDeleteRemarkById(Remark remark) throws Exception;
	
	/**	根据remarkId删除讨论*/
	public boolean doDeleteRemarkByNewsId(Remark remark) throws Exception;

	/** 根据remarkId查询新闻内的讨论数量 */
	public Integer doFindRemarkCountById(Remark remark) throws Exception;
	
	/**	根据主题newsId查询新闻内的全部讨论*/
	public List<Remark> doFindAllRemarkByNewsId(Remark remark) throws Exception;
	
	/** 查询所有留言信息 */
	public List<Remark> doFindAllRemark() throws Exception;
	
	/**	查询论坛留言数量 */
	public int doCountRemark() throws Exception;
}
