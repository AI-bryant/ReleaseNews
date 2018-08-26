package entity.entityBean;

import java.util.Date;

public class Remark extends BasicBean{
	private int remarkId;
	private String remarkContext;
	private Date createDate;
	private int userId;
	private int newsId;
	private User user;
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
	public Date getCreateDate() {
		if(this.createDate==null){
			this.createDate = super.getCreateDate();
		}
		return this.createDate;
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
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
