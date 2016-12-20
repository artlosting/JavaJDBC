import java.sql.*;
public class TestDML7 {
	public static void main(String[] args) throws Exception{
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##scott","tiger");
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from emp order by empno";
		ResultSet rt = st.executeQuery(sql);
		rt.next();
		System.out.println(rt.getInt(1));
		rt.last();
		System.out.println(rt.getString(1));
		System.out.println(rt.isAfterLast());
		System.out.println(rt.isBeforeFirst());
		System.out.println(rt.getRow());
		rt.previous();
		System.out.println(rt.getString(1));
		rt.absolute(6);
		System.out.println(rt.getString(1));
		st.close();
		conn.close();
	}
}