package entity.entityDaos.remarkDao.remarkDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.Remark;
import entity.entityDaos.remarkDao.IRemarkDao;

public class RemarkDaoImpl implements IRemarkDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateRemark(Remark remark) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_remark(remark_context,create_date,user_id,news_id) VALUES(?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, remark.getRemarkContext());
		this.pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(3, remark.getUserId());
		this.pstmt.setInt(4, remark.getNewsId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteRemarkById(Remark remark) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_remark WHERE remark_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, remark.getRemarkId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteRemarkByNewsId(Remark remark) throws Exception {
		boolean flag = false;
		String deleteSql = "DELETE FROM release_remark WHERE news_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, remark.getNewsId());
		if(this.pstmt.executeUpdate()>= 0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public Integer doFindRemarkCountById(Remark remark) throws Exception {
		String deleteSql = "DELETE FROM count(*) WHERE news_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, remark.getNewsId());
		int remarkCount = 0;
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			remarkCount=rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return remarkCount;
	}

	@Override
	public List<Remark> doFindAllRemarkByNewsId(Remark remark) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<Remark> remarkList = new ArrayList<Remark>();
		String selectAllSql = "SELECT remark_id,remark_context,create_date,user_id,news_id FROM release_remark WHERE news_id=? ORDER BY remark_id DESC";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, remark.getNewsId());
		ResultSet rs = this.pstmt.executeQuery();
		Remark tempRemark = null;
		while(rs.next()){
			tempRemark = new Remark();
			tempRemark.setRemarkId(rs.getInt(1));
			tempRemark.setRemarkContext(rs.getString(2));
			tempRemark.setCreateDate(rs.getDate(3));
			tempRemark.setUserId(rs.getInt(4));
			tempRemark.setNewsId(rs.getInt(5));
			remarkList.add(tempRemark);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return remarkList;
	}

	@Override
	public List<Remark> doFindAllRemark() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<Remark> remarkList = new ArrayList<Remark>();
		String selectAllSql = "SELECT remark_id,remark_context,create_date,user_id,news_id FROM release_remark ORDER BY remark_id DESC";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		Remark tempRemark = null;
		while(rs.next()){
			tempRemark = new Remark();
			tempRemark.setRemarkId(rs.getInt(1));
			tempRemark.setRemarkContext(rs.getString(2));
			tempRemark.setCreateDate(rs.getDate(3));
			tempRemark.setUserId(rs.getInt(4));
			tempRemark.setNewsId(rs.getInt(5));
			remarkList.add(tempRemark);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return remarkList;
	}
	
	@Override
	public int doCountRemark() throws Exception{
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql = "SELECT count(*) FROM release_remark";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		ResultSet rs = this.pstmt.executeQuery();
		int countRemark = 0;
		while(rs.next()){
			countRemark= rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return countRemark;
	}
}
