package entity.entityBean;

import java.util.Date;

public class BabyMedical {
	private int MEDICAL_ID;
	private Date DATA;		//日期	
	private String WEIGTH;	//体重
	private String HEAD;	//头围
	private String LENGTH;	//身高
	private String DRUG;	//配药
	private String REMARKS;	//医生备注
	
	public int getMEDICAL_ID() {
		return MEDICAL_ID;
	}
	public void setMEDICAL_ID(int mEDICAL_ID) {
		MEDICAL_ID = mEDICAL_ID;
	}
	public Date getDATA() {
		return DATA;
	}
	public void setDATA(Date dATA) {
		DATA = dATA;
	}
	public String getWEIGTH() {
		return WEIGTH;
	}
	public void setWEIGTH(String wEIGTH) {
		WEIGTH = wEIGTH;
	}
	public String getHEAD() {
		return HEAD;
	}
	public void setHEAD(String hEAD) {
		HEAD = hEAD;
	}
	public String getLENGTH() {
		return LENGTH;
	}
	public void setLENGTH(String lENGTH) {
		LENGTH = lENGTH;
	}
	public String getDRUG() {
		return DRUG;
	}
	public void setDRUG(String dRUG) {
		DRUG = dRUG;
	}
	public String getREMARKS() {
		return REMARKS;
	}
	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}
}
	