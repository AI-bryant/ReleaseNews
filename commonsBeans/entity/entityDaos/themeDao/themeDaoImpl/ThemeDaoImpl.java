package entity.entityDaos.themeDao.themeDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.Theme;
import entity.entityDaos.themeDao.IThemeDao;

public class ThemeDaoImpl implements IThemeDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateNewTheme(Theme theme) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_theme(theme_title,create_date,user_id,column_id) VALUES(?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, theme.getThemeTitle());
		this.pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(3, theme.getUserId());
		this.pstmt.setInt(4, theme.getColumnId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteThemeById(Theme theme) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_theme WHERE theme_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, theme.getThemeId());
		if(this.pstmt.executeUpdate() >= 0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doUpdateThemeTitleById(Theme theme) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_theme SET theme_title=?,user_id=?,column_id=? WHERE theme_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setString(1, theme.getThemeTitle());
		this.pstmt.setInt(2, theme.getUserId());
		this.pstmt.setInt(3, theme.getColumnId());
		this.pstmt.setInt(4, theme.getThemeId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public Theme doFindThemeById(Theme theme) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectAllSql = "SELECT theme_id,theme_title,create_date,user_id,column_id FROM release_theme WHERE Theme_id=?";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, theme.getThemeId());
		ResultSet rs = this.pstmt.executeQuery();
		Theme tempTheme = null;
		while(rs.next()){
			tempTheme = new Theme();
			tempTheme.setThemeId(rs.getInt(1));
			tempTheme.setThemeTitle(rs.getString(2));
			tempTheme.setCreateDate(rs.getDate(3));
			tempTheme.setUserId(rs.getInt(4));
			tempTheme.setColumnId(rs.getInt(5));
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return tempTheme;
	}

	@Override
	public List<Theme> doFindAllThemeByColumnId(Theme theme) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<Theme> ThemeList = new ArrayList<Theme>();
		String selectAllSql = "SELECT theme_id,theme_title,create_date,user_id,column_id FROM release_theme WHERE column_id = ?";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, theme.getColumnId());
		ResultSet rs = this.pstmt.executeQuery();
		Theme tempTheme = null;
		while(rs.next()){
			tempTheme = new Theme();
			tempTheme.setThemeId(rs.getInt(1));
			tempTheme.setThemeTitle(rs.getString(2));
			tempTheme.setCreateDate(rs.getDate(3));
			tempTheme.setUserId(rs.getInt(4));
			tempTheme.setColumnId(rs.getInt(5));
			ThemeList.add(tempTheme);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return ThemeList;
	}
}
