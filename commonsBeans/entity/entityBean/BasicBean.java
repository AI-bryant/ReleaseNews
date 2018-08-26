package entity.entityBean;

import java.util.Date;

public class BasicBean {
	private int userId;
	private String userName;
	private String userPass;
	private String nickName;
	private int userTel;
	private String userEmail;
	private String userPicturePath;
	private String userStatus;
	private Date createDate;
	
	private int columnId;
	private String columnTitle;
	
	private int themeId;
	private String themeTitle;
	
	private int newsId;
	private String newsTitle;
	private String newsContext;
	private String newsPicturePath;
	private int newsStatus;
	private String returnContext;
	private Date modifyDate;
	private Date passDate;
	private int remarkCount;

	private int remarkId;
	private String remarkContext;
	
	private int page;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserTel() {
		return userTel;
	}
	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPicturePath() {
		return userPicturePath;
	}
	public void setUserPicturePath(String userPicturePath) {
		this.userPicturePath = userPicturePath;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Date getCreateDate() {
		if(createDate==null){
			createDate = new Date();
		}
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
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
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public String getThemeTitle() {
		return themeTitle;
	}
	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}
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
	public Date getModifyDate() {
		if(modifyDate == null){
			modifyDate = new Date();
		}
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getPassDate() {
		if(passDate == null){
			passDate = new Date();
		}
		return passDate;
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
	public int getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(int remarkId) {
		this.remarkId = remarkId;
	}
	public String getRemarkContext() {
		return remarkContext;
	}
	public void setRemarkContext(String remarkContext) {
		this.remarkContext = remarkContext;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartNewsPageNum(){
		if(this.getPage()==0){
			return this.getPage();
		}
		return this.getPage()*10-10;
	}
}
