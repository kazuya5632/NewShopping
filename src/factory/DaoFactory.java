package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.ItemDAO;
import dao.jdbcItemDao;
import exception.DBAccessException;

// DAOファクトリクラス
public class DaoFactory {

	// ItemDAO生成
	public static ItemDAO createItemDAO() {
		return new jdbcItemDao(getConnection());
	}


	// JDBC取得
	public static Connection getConnection() {
		Connection con = null;
		try {
			// JDBC
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "56325632");
		} catch (Exception e) {
			 throw new DBAccessException();
		}
		return con;
	}
}
