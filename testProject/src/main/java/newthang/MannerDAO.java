package newthang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MannerDAO {
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
	public int RESULT(String TEAM_NAME) {
		
		int cnt=0;

		try {
			conn();
			
			String sql = "insert into MATCHING_RESULTS(m_result,time_result,fair_plays,languages,comments,team_name,total_score,numbering,result_1,result_2,result_3,num) "
					+ "values(0,0,0,0,null,?,0,(SELECT NVL(MAX(numbering)+1,1) FROM matching_results),0,0,0,1)";

			PreparedStatement psmt = conn.prepareStatement(sql);
				
			psmt.setString(1, TEAM_NAME);
			

			cnt = psmt.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close();
			}
		return cnt;

 }
	public int MATCHINGRE1(String TEAM_NAME) {
		conn();
		
		
		int cnt = 0;
		String sql = "update MATCHING_RESULTS SET TOTAL_SCORE=NVL(TOTAL_SCORE,0)+10, RESULT_1=NVL(RESULT_1,0)+1 where TEAM_NAME=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, TEAM_NAME);
			
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public int MATCHINGRE2(String TEAM_NAME) {
		conn();
		
		
		int cnt = 0;
		String sql = "update MATCHING_RESULTS SET TOTAL_SCORE=NVL(TOTAL_SCORE,0)+5, RESULT_2=NVL(RESULT_2,0)+1 where TEAM_NAME=?";

		try {
			psmt = conn.prepareStatement(sql);

			
			psmt.setString(1, TEAM_NAME);
			
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public int MATCHINGRE3(String TEAM_NAME) {
		conn();
		
		
		int cnt = 0;
		String sql = "update MATCHING_RESULTS SET RESULT_3=NVL(RESULT_3,0)+1 where TEAM_NAME=?";

		try {
			psmt = conn.prepareStatement(sql);

			
			psmt.setString(1, TEAM_NAME);
			
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public int MANNER(int time_result, int fair_plays, int languages, String TEAM_NAME) {
		conn();
		
		
		int cnt = 0;
		String sql = "update MATCHING_RESULTS SET m_result =(time_result+fair_plays+languages)/(num-1)/3 , time_result=NVL(time_result,0)+?,fair_plays=NVL(fair_plays,0)+?,languages=NVL(languages,0)+?,num=NVL(num,0)+1 "
				+ "where TEAM_NAME=?";

		try {
			psmt = conn.prepareStatement(sql);

			
			
			psmt.setInt(1, time_result);
			psmt.setInt(2, fair_plays);
			psmt.setInt(3, languages);
			psmt.setString(4, TEAM_NAME);
			

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public MannerVO MANNER_AVG(String team_name2) {

		MannerVO vo = null;
		
		conn();

		String sql = "select * from matching_results where team_name=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, team_name2);

			rs = psmt.executeQuery();

			if (rs.next()) {

				int m_result = rs.getInt(1);
				int time_result = rs.getInt(2);
				int fair_result = rs.getInt(3);
				int languages = rs.getInt(4);
				String comments = rs.getString(5);
				String team_name= rs.getString(6);
				int total_score = rs.getInt(7);
				int numbering = rs.getInt(8);
				int result_1 = rs.getInt(9);
				int result_2 = rs.getInt(10);
				int result_3 = rs.getInt(11);
				int num =rs.getInt(12);
				
				vo= new	MannerVO();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close();
		}
		return vo;
		

	}
	public ArrayList<MannerVO> MannerListData() {
	      ArrayList<MannerVO> list = new ArrayList<MannerVO>();
	      try {
	         
	         // 연결
	         conn();
	         String sql = "SELECT m_result,team_name,total_score,result_1,result_2,result_3 "
	               + "from matching_results ORDER BY total_score desc"; // 단점: 속도 늦음→INDEX
	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();
	         while (rs.next()) {
	            MannerVO vo = new MannerVO();
	            vo.setM_result(rs.getInt(1));
	            vo.setTeam_name(rs.getString(2));
	            vo.setTotal_score(rs.getInt(3));
	            vo.setResult_1(rs.getInt(4));
	            vo.setResult_2(rs.getInt(5));
	            vo.setResult_3(rs.getInt(6));
	            list.add(vo);
	         }
	         rs.close();
	      } catch (Exception ex) {
	         System.out.println(ex.getMessage());
	      } finally {
	        close();
	      }
	      return list;

	   }
}