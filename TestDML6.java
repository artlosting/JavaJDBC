import java.sql.*;
public class TestDML6 {
	public static void main(String[] args) throws Exception{
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##scott","tiger");
		Statement st = conn.createStatement();
		st.addBatch("insert into users1 values(120,'wang')");
		st.addBatch("insert into users1 values(130,'xin')");
		st.addBatch("insert into users1 values(130,'xin')");
		st.addBatch("insert into users1 values(130,'xin')");
		st.addBatch("insert into users1 values(130,'xin')");
		st.executeBatch();
		st.close();
		conn.close();
	}
	
}