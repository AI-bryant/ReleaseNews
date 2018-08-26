package entity.entityDaos.userDao.userDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.connection.MySqlDatabaseConnection;
import entity.entityBean.BabyInfo;
import entity.entityBean.User;
import entity.entityDaos.userDao.IUserDao;


public class UserDaoImpl implements IUserDao{
	private Connection dbconn = null;
	private PreparedStatement pstmt = null;
	
	public boolean doCreateNewUser(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String createSql = "INSERT INTO release_user(user_name,user_pass,nick_name,user_tel,user_email,user_status,create_date) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.dbconn.prepareStatement(createSql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getUserPass());
		this.pstmt.setString(3, user.getNickName());
		this.pstmt.setInt(4, user.getUserTel());
		this.pstmt.setString(5, user.getUserEmail());
		this.pstmt.setString(6, user.getUserStatus());
		this.pstmt.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	public boolean doDeleteUserById(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM release_user WHERE user_id = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, user.getUserId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}
	
	public boolean doDeleteBabyInfoById(BabyInfo babyinfo) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String deleteSql = "DELETE FROM baby_info WHERE BABY_INFO_ID = ?";
		this.pstmt = this.dbconn.prepareStatement(deleteSql);
		this.pstmt.setInt(1, babyinfo.getBABY_INFO_ID());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	public boolean doUpdateUserById(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		boolean flag = false;
		String updateSql = "UPDATE release_user SET user_name=?,user_pass=?,nick_name=?,user_tel=?,user_email=?,user_picture_path=? WHERE user_id=?";
		this.pstmt = this.dbconn.prepareStatement(updateSql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getUserPass());
		this.pstmt.setString(3, user.getNickName());
		this.pstmt.setInt(4, user.getUserTel());
		this.pstmt.setString(5, user.getUserEmail());
		this.pstmt.setString(6, user.getUserPicturePath());
		this.pstmt.setInt(7, user.getUserId());
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	public User doFindUserById(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		User tempUser = null;
		String selectSql = "SELECT user_id,user_name,user_pass,nick_name,user_tel,user_email,user_picture_path,user_status,create_date FROM release_user WHERE user_id=?";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		this.pstmt.setInt(1, user.getUserId());
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			tempUser = new User();
			tempUser.setUserId(rs.getInt(1));
			tempUser.setUserName(rs.getString(2));
			tempUser.setUserPass(rs.getString(3));
			tempUser.setNickName(rs.getString(4));
			tempUser.setUserTel(rs.getInt(5));
			tempUser.setUserEmail(rs.getString(6));
			tempUser.setUserPicturePath(rs.getString(7));
			tempUser.setUserStatus(rs.getString(8));
			tempUser.setCreateDate(rs.getDate(9));
			
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return tempUser;
	}
	
	public User doFindUserByUserNameAndUserPass(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		User tempUser = null;
		String selectSql = "SELECT user_id,user_name,user_pass,nick_name,user_tel,user_email,user_picture_path,user_status,create_date FROM release_user WHERE user_name = ? AND user_pass = ?";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getUserPass());
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			tempUser = new User();
			tempUser.setUserId(rs.getInt(1));
			tempUser.setUserName(rs.getString(2));
			tempUser.setUserPass(rs.getString(3));
			tempUser.setNickName(rs.getString(4));
			tempUser.setUserTel(rs.getInt(5));
			tempUser.setUserEmail(rs.getString(6));
			tempUser.setUserPicturePath(rs.getString(7));
			tempUser.setUserStatus(rs.getString(8));
			tempUser.setCreateDate(rs.getDate(9));
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return tempUser;
	}

	public List<User> doFindAllUsers() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		List<User> userList = new ArrayList<User>();
		String selectAllSql = "SELECT user_id,user_name,user_pass,nick_name,user_tel,user_email,user_picture_path,user_status,create_date FROM release_user";
		this.pstmt = this.dbconn.prepareStatement(selectAllSql);
		ResultSet rs = this.pstmt.executeQuery();
		User tempUser = null;
		while(rs.next()){
			tempUser = new User();
			tempUser.setUserId(rs.getInt(1));
			tempUser.setUserName(rs.getString(2));
			tempUser.setUserPass(rs.getString(3));
			tempUser.setNickName(rs.getString(4));
			tempUser.setUserTel(rs.getInt(5));
			tempUser.setUserEmail(rs.getString(6));
			tempUser.setUserPicturePath(rs.getString(7));
			tempUser.setUserStatus(rs.getString(8));
			tempUser.setCreateDate(rs.getDate(9));
			userList.add(tempUser);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return userList;
	}

	@Override
	public boolean doFindUserByUserName(User user) throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql = "SELECT user_name FROM release_user WHERE user_name = ?";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		this.pstmt.setString(1, user.getUserName());
		String userName = null;
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			userName = rs.getString(1);
		}
		boolean flag = false;
		if(userName != null && userName.length()>1){
			flag = true;
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return flag;
	}

	@Override
	public int doCountUser() throws Exception {
		this.dbconn = MySqlDatabaseConnection.getConnection();
		String selectSql = "SELECT count(*) FROM release_user";
		this.pstmt = this.dbconn.prepareStatement(selectSql);
		ResultSet rs = this.pstmt.executeQuery();
		int countUser = 0;
		while(rs.next()){
			countUser= rs.getInt(1);
		}
		this.pstmt.close();
		MySqlDatabaseConnection.close();
		return countUser;
	}
}
