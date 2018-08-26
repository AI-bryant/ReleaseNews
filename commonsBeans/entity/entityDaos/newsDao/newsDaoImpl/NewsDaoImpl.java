package entity.entityDaos.newsDao.newsDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.News;
import entity.entityDaos.newsDao.INewsDao;

public class NewsDaoImpl implements INewsDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	@Override
	public boolean doCreateNewNews(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_news(news_title,news_context,news_picture_path,news_status,create_date,user_id,column_id) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, news.getNewsTitle());
		/*if(news.getNewsContext() != null){
			String context = news.getNewsContext().replace("", "")
		}*/
		this.pstmt.setString(2, news.getNewsContext());
		this.pstmt.setString(3, news.getNewsPicturePath());
		this.pstmt.setInt(4, news.getNewsStatus());
		this.pstmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(6, news.getUserId());
		this.pstmt.setInt(7, news.getColumnId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doDeleteNewsById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_news WHERE news_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, news.getNewsId());
		if(this.pstmt.executeUpdate() >= 0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doUpdateNewsReleaseById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_news SET news_title=?,news_context=?,news_picture_path=?,modify_date=?,user_id=?,theme_id=? WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setString(1, news.getNewsTitle());
		this.pstmt.setString(2, news.getNewsContext());
		this.pstmt.setString(3, news.getNewsPicturePath());
		this.pstmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(5, news.getUserId());
		this.pstmt.setInt(6, news.getThemeId());
		this.pstmt.setInt(7, news.getNewsId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public News doFindNewsById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectAllSql = "SELECT news_id,news_title,news_context,news_picture_path,news_status,return_context,create_date,modify_date,pass_date,remark_count,user_id,theme_id FROM release_news WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, news.getNewsId());
		ResultSet rs = this.pstmt.executeQuery();
		News tempNews = null;
		while(rs.next()){
			tempNews = new News();
			tempNews.setNewsId(rs.getInt(1));
			tempNews.setNewsTitle(rs.getString(2));
			tempNews.setNewsContext(rs.getString(3));
			tempNews.setNewsPicturePath(rs.getString(4));
			tempNews.setNewsStatus(rs.getInt(5));
			tempNews.setReturnContext(rs.getString(6));
			tempNews.setCreateDate(rs.getDate(7));
			tempNews.setModifyDate(rs.getDate(8));
			tempNews.setPassDate(rs.getDate(9));
			tempNews.setRemarkCount(rs.getInt(10));
			tempNews.setUserId(rs.getInt(11));
			tempNews.setThemeId(rs.getInt(12));
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return tempNews;
	}

	@Override
	public List<News> doFindAllNewsByThemeId(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<News> newsList = new ArrayList<News>();
		String selectAllSql = "SELECT news_id,news_title,news_context,news_picture_path,news_status,return_context,create_date,modify_date,pass_date,remark_count,user_id,theme_id FROM release_news WHERE theme_id = ? ORDER BY news_id DESC";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, news.getThemeId());
		ResultSet rs = this.pstmt.executeQuery();
		News tempNews = null;
		while(rs.next()){
			tempNews = new News();
			tempNews.setNewsId(rs.getInt(1));
			tempNews.setNewsTitle(rs.getString(2));
			tempNews.setNewsContext(rs.getString(3));
			tempNews.setNewsPicturePath(rs.getString(4));
			tempNews.setNewsStatus(rs.getInt(5));
			tempNews.setReturnContext(rs.getString(6));
			tempNews.setCreateDate(rs.getDate(7));
			tempNews.setModifyDate(rs.getDate(8));
			tempNews.setPassDate(rs.getDate(9));
			tempNews.setRemarkCount(rs.getInt(10));
			tempNews.setUserId(rs.getInt(11));
			tempNews.setThemeId(rs.getInt(12));
			newsList.add(tempNews);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return newsList;
	}

	@Override
	public Integer doFindNewsRemarkCountById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectAllSql = "SELECT remark_count FROM release_news WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, news.getNewsId());
		ResultSet rs = this.pstmt.executeQuery();
		int remarkCount = 0;
		while(rs.next()){
			remarkCount = rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return remarkCount;
	}

	@Override
	public boolean doUpdateNewsRemarkCountById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_news SET remark_count=? WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setInt(1, news.getRemarkCount());
		this.pstmt.setInt(2, news.getNewsId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public boolean doUpdateNewsReturnById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_news SET return_context=?,news_status=?,pass_date=? WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setString(1, news.getReturnContext());
		this.pstmt.setInt(2, news.getNewsStatus());
		this.pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(4, news.getNewsId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public List<News> doFindAllNewsByColumnId(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<News> newsList = new ArrayList<News>();
		String selectAllSql = null;
		selectAllSql = "SELECT news_id,news_title,news_context,news_picture_path,news_status,return_context,create_date,modify_date,pass_date,remark_count,user_id,theme_id,column_id FROM release_news WHERE column_id = ? AND news_status = ? ORDER BY news_id DESC limit ?,10";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, news.getColumnId());
		this.pstmt.setInt(2, news.getNewsStatus());
		this.pstmt.setInt(3, news.getStartNewsPageNum());
		ResultSet rs = this.pstmt.executeQuery();
		News tempNews = null;
		while(rs.next()){
			tempNews = new News();
			tempNews.setNewsId(rs.getInt(1));
			tempNews.setNewsTitle(rs.getString(2));
			tempNews.setNewsContext(rs.getString(3));
			tempNews.setNewsPicturePath(rs.getString(4));
			tempNews.setNewsStatus(rs.getInt(5));
			tempNews.setReturnContext(rs.getString(6));
			tempNews.setCreateDate(rs.getDate(7));
			tempNews.setModifyDate(rs.getDate(8));
			tempNews.setPassDate(rs.getDate(9));
			tempNews.setRemarkCount(rs.getInt(10));
			tempNews.setUserId(rs.getInt(11));
			tempNews.setThemeId(rs.getInt(12));
			tempNews.setColumnId(rs.getInt(13));
			newsList.add(tempNews);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return newsList;
	}

	@Override
	public List<News> doFindAllNewsByStatus(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<News> newsList = new ArrayList<News>();
		String selectAllSql = "SELECT news_id,news_title,news_context,news_picture_path,news_status,return_context,create_date,modify_date,pass_date,remark_count,user_id,theme_id,column_id FROM release_news WHERE news_status = ? ORDER BY news_id DESC";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		this.pstmt.setInt(1, news.getNewsStatus());
		ResultSet rs = this.pstmt.executeQuery();
		News tempNews = null;
		while(rs.next()){
			tempNews = new News();
			tempNews.setNewsId(rs.getInt(1));
			tempNews.setNewsTitle(rs.getString(2));
			tempNews.setNewsContext(rs.getString(3));
			tempNews.setNewsPicturePath(rs.getString(4));
			tempNews.setNewsStatus(rs.getInt(5));
			tempNews.setReturnContext(rs.getString(6));
			tempNews.setCreateDate(rs.getDate(7));
			tempNews.setModifyDate(rs.getDate(8));
			tempNews.setPassDate(rs.getDate(9));
			tempNews.setRemarkCount(rs.getInt(10));
			tempNews.setUserId(rs.getInt(11));
			tempNews.setThemeId(rs.getInt(12));
			tempNews.setColumnId(rs.getInt(13));
			newsList.add(tempNews);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return newsList;
	}

	@Override
	public boolean doUpdateNewStatusById(News news) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_news SET news_status=?,pass_date=? WHERE news_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setInt(1, News.STATUS_RELEASE_SUCCESS);
		this.pstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setInt(3, news.getNewsId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public int doCountNews() throws Exception{
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql = "SELECT count(*) FROM release_news";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		ResultSet rs = this.pstmt.executeQuery();
		int countNews = 0;
		while(rs.next()){
			countNews= rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return countNews;
	}
}
