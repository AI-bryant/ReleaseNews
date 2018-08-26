package entity.entityBean;

import java.util.Date;
import java.util.List;

public class Column extends BasicBean{
	private int columnId;
	private String columnTitle;
	private String columnDescribe;
	private Date createDate;
	private String columnPicPath;
	private int userId;
	private int newsCount;
	private List<Theme> themeList;
	private List<News> newsList;
	
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public Date getCreateDate() {
		if(createDate==null){
			createDate = super.getCreateDate();
		}
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Theme> getThemeList() {
		return themeList;
	}
	public void setThemeList(List<Theme> themeList) {
		this.themeList = themeList;
	}
	public String getColumnDescribe() {
		return columnDescribe;
	}
	public void setColumnDescribe(String columnDescribe) {
		this.columnDescribe = columnDescribe;
	}
	public String getColumnPicPath() {
		return columnPicPath;
	}
	public void setColumnPicPath(String columnPicPath) {
		this.columnPicPath = columnPicPath;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public int getNewsCount() {
		return newsCount;
	}
	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
}
