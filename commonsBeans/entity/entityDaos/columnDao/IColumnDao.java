package entity.entityDaos.columnDao;

import java.util.List;

import entity.entityBean.Column;

public interface IColumnDao {
	/**	创建新闻栏目 */
	public boolean doCreateNewColumn(Column column) throws Exception;
	
	/**	根据columnId删除栏目 */
	public boolean doDeleteColumnById(Column column) throws Exception;
	
	/**	根据columnId更新栏目的标题 */
	public boolean doUpdateColumnTitleById(Column column) throws Exception;
	
	/**	根据columnId查询栏目 */
	public Column doFindColumnById(Column column) throws Exception;
	
	/** 查询全部栏目 */
	public List<Column> doFindAllColumn() throws Exception;
}
