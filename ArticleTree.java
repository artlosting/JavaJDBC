import java.sql.*;
public class ArticleTree {

	public static void main(String[] args) {
		new ArticleTree().show();
	}
	
	public void show() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
			st = conn.createStatement();
			rs = st.executeQuery("select * from article where pid = 0");
			while(rs.next()) {
				System.out.println(rs.getInt("pid")+"--"+rs.getInt("id")+" "+rs.getString("cont"));
				tree(conn,rs.getInt("id"),1);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
						conn.close();
						conn = null;
					}
			if(st != null) {
					st.close();
					st = null;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void tree(Connection conn,int id,int leavel) {
		Statement st = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<leavel; i++) {
			sb.append("     ");
		}
		try {
			st = conn.createStatement();
			String sql = "select * from article where pid ="+ id;
			rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(sb+rs.getString("pid")+"--"+rs.getString("id")+" "+rs.getString("cont"));
				tree(conn,rs.getInt("id"),leavel+1);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
