package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeamJoinDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void conn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "cgi_6_5";
			String dbpw = "smhrd5";
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {

		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();

			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int TeamJoin(String team_name,String member_id) {
		
		int cnt=0;
		
		try {
			// 연결
			conn();
			
			
			
			String sql = "UPDATE members SET team_name=? WHERE member_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, team_name); // ?에 값을 채운다
			psmt.setString(2, member_id); // ?에 값을 채운다
			
			cnt= psmt.executeUpdate();
			
			
			
	
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		
		return cnt;		
		
	}


	

	

}
