package commons.modelFactory;

import C_Model.IDeleNewsDao;
import C_Model.IEditNewsDao;
import C_Model.IRegLogDao;
import C_Model.ISystemDao;
import C_Model.IViewBabyInfoDao;
import C_Model.IViewNewsDao;
import C_Model.mdolDaosImple.DeleNewsDaoImpl;
import C_Model.mdolDaosImple.EditNewsDaoImpl;
import C_Model.mdolDaosImple.RegLogDaoImpl;
import C_Model.mdolDaosImple.SystemDaoImple;
import C_Model.mdolDaosImple.ViewBabyInfoDaoImpl;
import C_Model.mdolDaosImple.ViewNewsDaoImpl;

/** 数据操作层,创建的对象为实体类对应表的数据操作对象 */
public class ModelFactory {
	private static IRegLogDao reglogDao = new RegLogDaoImpl();
	private static ISystemDao systemDao = new SystemDaoImple();
	private static IViewNewsDao viewNewsDao = new ViewNewsDaoImpl();
	private static IEditNewsDao editNewsDao = new EditNewsDaoImpl();
	private static IDeleNewsDao deleNewsDao = new DeleNewsDaoImpl();
	private static IViewBabyInfoDao viewBabyDao = new ViewBabyInfoDaoImpl();
	
	/** 获取用户(IUserDao)的DAO层 */
	public static IViewBabyInfoDao getViewBabyInfoDaoImplInstance(){
		if(viewBabyDao == null){
			viewBabyDao = new ViewBabyInfoDaoImpl();
		}
		return viewBabyDao;
	}
	
	/** 获取用户(IUserDao)的DAO层 */
	public static IRegLogDao getRegLogDaoImplInstance(){
		if(reglogDao == null){
			reglogDao = new RegLogDaoImpl();
		}
		return reglogDao;
	}
	
	/** 获取系统(ISystemDao)的DAO层 */
	public static ISystemDao getSystemDaoImplInstance(){
		if(systemDao == null){
			systemDao = new SystemDaoImple();
		}
		return systemDao;
	}
	
	/** 获取显示栏目、主题、新闻、讨论(IViewNewsDao)的DAO层 */
	public static IViewNewsDao getViewNewsDaoImplInstance(){
		if(viewNewsDao == null){
			viewNewsDao = new ViewNewsDaoImpl();
		}
		return viewNewsDao;
	}
	
	/** 获取编辑栏目、主题、新闻、讨论(IEditNewsDao)的DAO层 */
	public static IEditNewsDao getEditNewsDaoImplInstance(){
		if(editNewsDao == null){
			editNewsDao = new EditNewsDaoImpl();
		}
		return editNewsDao;
	}
	
	/** 获取删除栏目、主题、新闻、讨论(IDeleNewsDao)的DAO层 */
	public static IDeleNewsDao getDeleNewsDaoImplInstance(){
		if(deleNewsDao == null){
			deleNewsDao = new DeleNewsDaoImpl();
		}
		return deleNewsDao;
	}
}
