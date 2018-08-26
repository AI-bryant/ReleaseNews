package commons.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabaseConnection {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/mydemo?useSSL=false&serverTimezone=GMT";
	private static final String DBUSER = "root";
	private static final String DBPASS = "root";
	private static Connection dbconn = null;
	private MySqlDatabaseConnection(){};
	
	public static Connection getConnection(){
		try{
			if(MySqlDatabaseConnection.dbconn == null){
				Class.forName(DBDRIVER);									 						//加载驱动程序
				MySqlDatabaseConnection.dbconn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);	//连接数据库
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return MySqlDatabaseConnection.dbconn;
	}
	
	public static void close()throws Exception{
		if(MySqlDatabaseConnection.dbconn != null){
			try{
				MySqlDatabaseConnection.dbconn.close();
				MySqlDatabaseConnection.dbconn = null;
			}catch(Exception e){
				throw e;
			}
		}
	}
}
