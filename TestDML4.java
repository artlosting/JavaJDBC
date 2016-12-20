import java.sql.*;
public class TestDML4 {
	public static void main(String[] args) throws Exception{
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//取得连接
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##scott","tiger");
		//声明
		CallableStatement cstm = conn.prepareCall("{call my_pro12(?,?,?,?)}");
		cstm.registerOutParameter(3, Types.INTEGER);
		cstm.registerOutParameter(4, Types.INTEGER);
		cstm.setInt(1, 3);
		cstm.setInt(2, 4);
		cstm.setInt(4, 5);
		System.out.println(cstm.getInt(3));
		System.out.println(cstm.getInt(4));
		cstm.close();
		conn.close();
	}
	
}