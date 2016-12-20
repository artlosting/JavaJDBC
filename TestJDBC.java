import java.sql.*;
public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##scott","tiger");
			statement = conn.createStatement();
			rs = statement.executeQuery("select * from emp");
			while(rs.next()) {
				System.out.println(rs.getString("empno"));
				System.out.println("ename");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { 
					rs.close();
					rs = null;
				}
				if(statement != null) {
					statement.close();
					statement = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
//122.206.52.41