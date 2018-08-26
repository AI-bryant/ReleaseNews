package entity.entityDaos.aboutusDao.aboutusDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.AboutUs;
import entity.entityDaos.aboutusDao.IAboutusDao;

public class AboutusDaoImpl implements IAboutusDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateAboutUs(AboutUs aboutUs) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_aboutus(aboutus_email,aboutus_context,create_date) VALUES(?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, aboutUs.getAboutusEmail());
		this.pstmt.setString(2, aboutUs.getAboutusContext());
		this.pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteAboutUsById(AboutUs aboutUs) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_aboutus WHERE aboutus_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, aboutUs.getAboutusId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public List<AboutUs> doFindAllAboutUs() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<AboutUs> aboutUsList = new ArrayList<AboutUs>();
		String selectAllSql = "SELECT aboutus_id,aboutus_email,aboutus_context,create_date FROM release_aboutus";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		AboutUs tempAboutUs = null;
		while(rs.next()){
			tempAboutUs = new AboutUs();
			tempAboutUs.setAboutusId(rs.getInt(1));
			tempAboutUs.setAboutusEmail(rs.getString(2));
			tempAboutUs.setAboutusContext(rs.getString(3));
			tempAboutUs.setCreateDate(rs.getDate(4));
			aboutUsList.add(tempAboutUs);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return aboutUsList;
	}

	@Override
	public int doCountAboutUs() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql = "SELECT count(*) FROM release_aboutus";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		ResultSet rs = this.pstmt.executeQuery();
		int countAboutUs = 0;
		while(rs.next()){
			countAboutUs= rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return countAboutUs;
	}
	
}
