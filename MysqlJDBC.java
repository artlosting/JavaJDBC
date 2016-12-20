import java.sql.*;
public class MysqlJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from article");
		while(rs.next()) {
			System.out.println(rs.getString("title"));
		}
	}
}