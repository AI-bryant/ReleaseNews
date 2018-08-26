package entity.entityDaos.babyDao.babyDaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.BabyInfo;
import entity.entityBean.BabyMedical;
import entity.entityDaos.babyDao.BabyDao;

public class BabyDaoImpl implements BabyDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateBabyInfo(BabyInfo babyinfo) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO baby_info(DATA,EAT,EXCRETION,SLEEP) VALUES(?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setDate(1, (Date) babyinfo.getDATA());
		this.pstmt.setInt(2, babyinfo.getEAT());
		this.pstmt.setInt(3, babyinfo.getEXCRETION());
		this.pstmt.setTime(4, babyinfo.getSLEEP());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_aboutus WHERE aboutus_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, babyinfo.getBABY_INFO_ID());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public List<BabyInfo> doFindAllBabyInfo() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<BabyInfo> babyInfoList = new ArrayList<BabyInfo>();
		String selectAllSql = "SELECT * FROM BABY_INFO";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		BabyInfo tempBabyInfo = null;
		while(rs.next()){
			tempBabyInfo = new BabyInfo();
			tempBabyInfo.setBABY_INFO_ID(rs.getInt(1));
			tempBabyInfo.setDATA(rs.getDate(2));
			tempBabyInfo.setEAT(rs.getInt(3));
			tempBabyInfo.setEXCRETION(rs.getInt(4));
			tempBabyInfo.setSLEEP(rs.getTime(5));
			babyInfoList.add(tempBabyInfo);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return babyInfoList;
	}
	
	@Override
	public List<BabyMedical> doFindAllBabyMedical() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<BabyMedical> babyMedicalList = new ArrayList<BabyMedical>();
		String selectAllSql = "SELECT * FROM baby_medical_records";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		BabyMedical tempBabyInfo = null;
		while(rs.next()){
			tempBabyInfo = new BabyMedical();
			tempBabyInfo.setMEDICAL_ID(rs.getInt(1));
			tempBabyInfo.setDATA(rs.getDate(2));
			tempBabyInfo.setWEIGTH(rs.getString(3));
			tempBabyInfo.setHEAD(rs.getString(4));
			tempBabyInfo.setLENGTH(rs.getString(5));
			tempBabyInfo.setDRUG(rs.getString(6));
			tempBabyInfo.setREMARKS(rs.getString(7));
			babyMedicalList.add(tempBabyInfo);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return babyMedicalList;
	}
	
	@Override
	public int doAverageFeed(String month) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql;
		if(month.equals("")||month==null) {
			selectSql = "SELECT AVG(EAT) FROM baby_info";
		}else {
			selectSql = "SELECT AVG(EAT) FROM baby_info WHERE DATA like '%"+month+"%'";
		}
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		ResultSet rs = this.pstmt.executeQuery();
		int averageFeed = 0;
		while(rs.next()){
			averageFeed= rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return averageFeed;
	}
}
