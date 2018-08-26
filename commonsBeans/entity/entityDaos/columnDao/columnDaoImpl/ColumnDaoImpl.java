package entity.entityDaos.columnDao.columnDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.Column;
import entity.entityDaos.columnDao.IColumnDao;

public class ColumnDaoImpl implements IColumnDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateNewColumn(Column column) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_column(column_title,column_describe,create_date,user_id) VALUES(?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, column.getColumnTitle());
		this.pstmt.setString(2, column.getColumnDescribe());
		this.pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(4, column.getUserId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteColumnById(Column column) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_column WHERE column_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, column.getColumnId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doUpdateColumnTitleById(Column column) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_column SET column_title=?,column_describe=?,user_id=? WHERE column_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setString(1, column.getColumnTitle());
		this.pstmt.setString(2, column.getColumnDescribe());
		this.pstmt.setInt(3, column.getUserId());
		this.pstmt.setInt(4, column.getColumnId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public Column doFindColumnById(Column column) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectAllSql = "SELECT column_id,column_title,column_describe,create_date,user_id,news_count FROM release_column WHERE column_id=?";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, column.getColumnId());
		ResultSet rs = this.pstmt.executeQuery();
		Column tempColumn = null;
		while(rs.next()){
			tempColumn = new Column();
			tempColumn.setColumnId(rs.getInt(1));
			tempColumn.setColumnTitle(rs.getString(2));
			tempColumn.setColumnDescribe(rs.getString(3));
			tempColumn.setCreateDate(rs.getDate(4));
			tempColumn.setUserId(rs.getInt(5));
			tempColumn.setNewsCount(rs.getInt(6));
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return tempColumn;
	}

	@Override
	public List<Column> doFindAllColumn() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<Column> ColumnList = new ArrayList<Column>();
		String selectAllSql = "SELECT column_id,column_title,column_describe,column_pic_path,create_date,user_id,news_count FROM release_column";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		Column tempColumn = null;
		while(rs.next()){
			tempColumn = new Column();
			tempColumn.setColumnId(rs.getInt(1));
			tempColumn.setColumnTitle(rs.getString(2));
			tempColumn.setColumnDescribe(rs.getString(3));
			tempColumn.setColumnPicPath(rs.getString(4));
			tempColumn.setCreateDate(rs.getDate(5));
			tempColumn.setUserId(rs.getInt(6));
			tempColumn.setNewsCount(rs.getInt(7));
			ColumnList.add(tempColumn);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return ColumnList;
	}
}
