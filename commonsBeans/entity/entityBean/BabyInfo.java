package entity.entityBean;

import java.sql.Time;
import java.util.Date;

public class BabyInfo {
	private int BABY_INFO_ID;
	private Date DATA;
	private int EAT;
	private int EXCRETION;
	private Time SLEEP;
	public int getBABY_INFO_ID() {
		return BABY_INFO_ID;
	}
	public void setBABY_INFO_ID(int bABY_INFO_ID) {
		BABY_INFO_ID = bABY_INFO_ID;
	}
	public Date getDATA() {
		return DATA;
	}
	public void setDATA(Date dATA) {
		DATA = dATA;
	}
	public int getEAT() {
		return EAT;
	}
	public void setEAT(int eAT) {
		EAT = eAT;
	}
	public int getEXCRETION() {
		return EXCRETION;
	}
	public void setEXCRETION(int eXCRETION) {
		EXCRETION = eXCRETION;
	}
	public Time getSLEEP() {
		return SLEEP;
	}
	public void setSLEEP(Time sLEEP) {
		SLEEP = sLEEP;
	}
}
	