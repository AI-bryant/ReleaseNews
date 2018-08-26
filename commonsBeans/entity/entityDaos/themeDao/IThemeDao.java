package entity.entityDaos.themeDao;

import java.util.List;

import entity.entityBean.Theme;

public interface IThemeDao {
	/**	创建新闻主题 */
	public boolean doCreateNewTheme(Theme theme) throws Exception;
	
	/**	根据themeId删除主题 */
	public boolean doDeleteThemeById(Theme theme) throws Exception;
	
	/**	根据themeId更新主题的标题 */
	public boolean doUpdateThemeTitleById(Theme theme) throws Exception;
	
	/**	根据themeId查询主题 */
	public Theme doFindThemeById(Theme theme) throws Exception;
	
	/** 根据columnId查询栏目内的全部主题*/
	public List<Theme> doFindAllThemeByColumnId(Theme theme) throws Exception;
}
