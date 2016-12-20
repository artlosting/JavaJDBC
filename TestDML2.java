import java.sql.*;

public class TestDML2 {
	public static void main(String[] args) {
		//判断输入的参数是否正确
		if(args.length != 2) {
			System.out.println("The parameter failed,please input again!");
			System.exit(-1);
		}
		//拿到两个参数，第一个是数字，第二个是字符串
		int userid = 0;
		try {
			userid = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		String name = args[1];
		
		Statement st = null;
		Connection conn = null;
		try {
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//创建连接
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##scott","tiger");
		//声明执行
		st = conn.createStatement();
		String sql = "insert into users1 values("+userid+",'"+ name +"')";
		System.out.println(sql);
		
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