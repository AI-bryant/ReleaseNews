package entity.entityBean;

import java.util.Date;
import java.util.List;

public class News extends BasicBean{
	public static final int STATUS_RELEASE_SUBMIT = 0;	//新闻编辑完毕提交
	public static final int STATUS_RELEASE_RETRUEN = 2;	//新闻退回重新编辑
	public static final int STATUS_RELEASE_FAULT = 3;	//新闻审核失败不发布
	public static final int STATUS_RELEASE_SUCCESS = 4;	//新闻审核成功发布
	
	private int newsId;
	private String newsTitle;
	private String newsContext;
	private String newsPicturePath;
	private int newsStatus;
	private String returnContext;
	private Date createDate;
	private Date modifyDate;
	private Date passDate;
	private int remarkCount;
	private int userId;
	private int themeId;
	private int columnId;
	private List<Remark> remarkList;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContext() {
		return newsContext;
	}
	public void setNewsContext(String newsContext) {
		this.newsContext = newsContext;
	}
	public String getNewsPicturePath() {
		return newsPicturePath;
	}
	public void setNewsPicturePath(String newsPicturePath) {
		this.newsPicturePath = newsPicturePath;
	}
	public int getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(int newsStatus) {
		this.newsStatus = newsStatus;
	}
	public String getReturnContext() {
		return returnContext;
	}
	public void setReturnContext(String returnContext) {
		this.returnContext = returnContext;
	}
	public Date getCreateDate() {
		if(this.createDate==null){
			this.createDate = super.getCreateDate();
		}
		return this.createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		if(this.modifyDate==null){
			this.modifyDate = super.getCreateDate();
		}
		return this.modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getPassDate() {
		if(this.passDate==null){
			this.passDate = super.getCreateDate();
		}
		return this.passDate;
	}
	public void setPassDate(Date passDate) {
		this.passDate = passDate;
	}
	public int getRemarkCount() {
		return remarkCount;
	}
	public void setRemarkCount(int remarkCount) {
		this.remarkCount = remarkCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public List<Remark> getRemarkList() {
		return remarkList;
	}
	public void setRemarkList(List<Remark> remarkList) {
		this.remarkList = remarkList;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
}
