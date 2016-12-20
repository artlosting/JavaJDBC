import java.sql.*;

public class TestDML {
	public static void main(String[] args) {
		Statement st = null;
		Connection conn = null;
		try {
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##scott","tiger");
		//声明执行
		st = conn.createStatement();
		String sql = "insert into users1 values(400,'test')";
		//开始执行
		st .executeUpdate(sql);
		//关闭资源
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException ee) {
			ee.printStackTrace();
		}
	}
}