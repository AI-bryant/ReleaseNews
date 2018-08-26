package entity.entityBean;

import java.util.Date;

public class AboutUs {
	private int aboutusId;
	private String aboutusEmail;
	private String aboutusContext;
	private Date createDate;
	public int getAboutusId() {
		return aboutusId;
	}
	public void setAboutusId(int aboutusId) {
		this.aboutusId = aboutusId;
	}
	public String getAboutusEmail() {
		return aboutusEmail;
	}
	public void setAboutusEmail(String aboutusEmail) {
		this.aboutusEmail = aboutusEmail;
	}
	public String getAboutusContext() {
		return aboutusContext;
	}
	public void setAboutusContext(String aboutusContext) {
		this.aboutusContext = aboutusContext;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
