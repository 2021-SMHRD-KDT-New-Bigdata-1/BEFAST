package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import testProject.memberVO;

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

	public ArrayList<memberVO> Accept(){
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		try {
			// 연결
			conn();
			
			
			
			String sql = "select * from member";

			psmt = conn.prepareStatement(sql);		
			rs= psmt.executeQuery();
			while (rs.next()) {
				memberVO vo = new memberVO(sql, sql, sql, sql, sql, sql, sql, sql, sql, sql);
			vo.setMEMBER_ID(rs.getString(1));
			vo.setMEMBER_NAME(rs.getString(2));
			vo.setMEMBER_PHONE(rs.getString(3));
			vo.setMEMBER_BIRTHDATE(rs.getString(4));
			vo.setGENDER(rs.getString(5));
			vo.setPWD(rs.getString(6));
			vo.setP_AREA(rs.getString(7));
			vo.setPOSITION(rs.getString(8));
			vo.setTEAM_CODE(rs.getString(9));
			vo.setTEAM_NAME(rs.getString(10));
			list.add(vo);
			}
			
			
		
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			close();
		}
		
		return list;		
		
	}

	

	

}
